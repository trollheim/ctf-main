package net.trollheim.security.ctf.service;


import net.trollheim.security.ctf.dto.FlagDetailsDto;
import net.trollheim.security.ctf.dto.FlagDto;
import net.trollheim.security.ctf.dto.RankDto;
import net.trollheim.security.ctf.dto.ScoreDto;
import net.trollheim.security.ctf.dto.specifications.FlagSpec;
import net.trollheim.security.ctf.model.AppUser;
import net.trollheim.security.ctf.model.Flag;
import net.trollheim.security.ctf.repository.AppUserRepository;
import net.trollheim.security.ctf.repository.FlagRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class FlagService {

    private final FlagRepository flagRepository;
    private final AppUserRepository appUserRepository;
    private final Function<Flag, FlagDetailsDto> flagConverter = flag -> new FlagDetailsDto(flag.getNumber(), flag.getTitle(), flag.getDescription(),
            flag.getUrl(), flag.getSubmissions().stream().filter(s -> s.getAppUser().getId().equals(((AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId())).findAny().isPresent());


    public FlagService(FlagRepository flagRepository, AppUserRepository appUserRepository) {
        this.flagRepository = flagRepository;
        this.appUserRepository = appUserRepository;
    }


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
        System.out.println(authentication.getPrincipal());
        AppUser user = (AppUser) authentication.getPrincipal();


        List<ScoreDto.Flag> flags = appUserRepository.findById(user.getId()).get().getSubmissions().stream().map(s -> new ScoreDto.Flag(s.getFlag().getTitle(), 1)).collect(Collectors.toList());
        RankDto rankDto = new RankDto();
        rankDto.setPlayer(appUserRepository.findById(user.getId()).get().getSubmissions().size());

        rankDto.setTop(appUserRepository.findTopPlayers());

        return rankDto;
    }


    public FlagDetailsDto getFlagDetails(int number) {
        Optional<Flag> flagOptional = flagRepository.findByNumber(number);
        //TODO check is flag active
        return flagOptional.map(flagConverter).orElseThrow(() -> new RuntimeException("Not found"));
    }
}
