package net.trollheim.security.ctf.service;


import net.trollheim.security.ctf.dto.*;
import net.trollheim.security.ctf.dto.specifications.FlagSpec;
import net.trollheim.security.ctf.model.AppUser;
import net.trollheim.security.ctf.model.Flag;
import net.trollheim.security.ctf.model.GrantedAuthorities;
import net.trollheim.security.ctf.model.InviteCode;
import net.trollheim.security.ctf.repository.AppUserRepository;
import net.trollheim.security.ctf.repository.FlagRepository;
import net.trollheim.security.ctf.repository.InviteCodeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FlagService {

    private final FlagRepository flagRepository;
    private final AppUserRepository appUserRepository;
    private final InviteCodeRepository inviteCodeRepository;

    private final Function<Flag, FlagDetailsDto> flagConverter = flag -> new FlagDetailsDto(flag.getId(), flag.getTitle(), flag.getDescription(),
            flag.getUrl(), flag.getSubmissions().stream().filter(s -> s.getAppUser().getId().equals(((AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId())).findAny().isPresent());


    public FlagService(FlagRepository flagRepository, AppUserRepository appUserRepository, InviteCodeRepository inviteCodeRepository) {
        this.flagRepository = flagRepository;
        this.appUserRepository = appUserRepository;
        this.inviteCodeRepository = inviteCodeRepository;
    }

    @Deprecated
    public Flag createFlag(FlagDto flagDto) {
        Flag flag = new Flag();
        flag.setCode(flagDto.getCode());
        flag.setDescription(flagDto.getDescription());

        return flagRepository.save(flag);
    }


    public List<FlagDetailsDto> getActiveFlagsDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


        List<Flag> activeFlags = flagRepository.findAll(FlagSpec.FIND_ACTIVE);

        if (activeFlags.isEmpty()) {
            return Collections.emptyList();
        }

        //TODO use query for that
        List<FlagDetailsDto> flagsDtos = activeFlags.stream().map(flagConverter).collect(Collectors.toList());

        return flagsDtos;
    }

    public ScoreDto getUserScore() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser user = (AppUser) authentication.getPrincipal();


        List<ScoreDto.Flag> flags = appUserRepository.findById(user.getId()).get().getSubmissions().stream().map(s -> new ScoreDto.Flag(s.getFlag().getTitle(), 10)).collect(Collectors.toList());
        ScoreDto scoreDto = new ScoreDto();
        scoreDto.setTotal(appUserRepository.findById(user.getId()).get().getSubmissions().size());
        scoreDto.setFlags(flags);
        return scoreDto;
    }

    public RankDto getRanks() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        AppUser user = (AppUser) authentication.getPrincipal();
        user = appUserRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException());

        List<ScoreDto.Flag> flags = user.getSubmissions().stream().map(s -> new ScoreDto.Flag(s.getFlag().getTitle(), 1)).collect(Collectors.toList());
        RankDto rankDto = new RankDto();
        rankDto.setPlayer( user.getSubmissions().size());

        rankDto.setTop(appUserRepository.findTopPlayers(user.getOrganisation().getId()));

        return rankDto;
    }


    public FlagDetailsDto getFlagDetails(long id) {
        Optional<Flag> flagOptional = flagRepository.findById(id);
        //TODO check is flag active
        return flagOptional.map(flagConverter).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public List<InviteCodeDto> getInvites() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser user = (AppUser) authentication.getPrincipal();
        final Stream<InviteCode> stream;
        if (user.getAuthorities().contains(GrantedAuthorities.APP_ADMIN)){
            stream = inviteCodeRepository.findAll().stream();
        } else {
            stream = inviteCodeRepository.findByOwnerId(user.getOrganisation().getId()).stream();
        }

        //if admin - get all codes
        //if org admin get roles only gor org



        return  stream.map(code -> new InviteCodeDto(code.getInviteCode(), code.getOwner().getName(), code.isActive())).collect(Collectors.toList());
    }

    @Transactional
    public List<FlagAdminDetailsDto> getAdminFlagsDetails() {
        List<Flag> flags = flagRepository.findAll();
        List<FlagAdminDetailsDto> list = flags.stream().map(FlagAdminDetailsDto::fromFlag).toList();
        return list;
    }


    public void createFlag(NewFlagDto newFlagDto) {
        Flag flag = new Flag();
        flag.setCode(newFlagDto.code());
        flag.setDescription(newFlagDto.description());
        flag.setTitle(newFlagDto.title());
        flag.setUrl(newFlagDto.url());
        flag.setStartDate(newFlagDto.startDate().asLocalDate().atTime(LocalTime.MIN));
        flag.setEndDate(newFlagDto.endDate().asLocalDate().atTime(LocalTime.MAX));
        flagRepository.save(flag);
    }
}
