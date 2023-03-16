package net.trollheim.security.ctf.service;


import net.trollheim.security.ctf.dto.CreateUserDto;
import net.trollheim.security.ctf.dto.LoggedUserDto;
import net.trollheim.security.ctf.dto.OrganisationDto;
import net.trollheim.security.ctf.model.*;
import net.trollheim.security.ctf.repository.AppUserRepository;
import net.trollheim.security.ctf.repository.InviteCodeRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AppUserService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    private final InviteCodeRepository inviteCodeRepository;


    private final PasswordEncoder passwordEncoder;

    public AppUserService(AppUserRepository appUserRepository, InviteCodeRepository inviteCodeRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.inviteCodeRepository = inviteCodeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User does not exist"));
    }


    @Transactional
    public AppUser createUser(CreateUserDto createUserDto) {
        InviteCode inviteCode = inviteCodeRepository.findByInviteCode(createUserDto.getInviteCode());
        if (inviteCode == null || !inviteCode.isActive()) {
            //TODO exception hierarchy
            throw new RuntimeException();
        }



        Organisation organisation = inviteCode.getOwner();

        String password = passwordEncoder.encode(createUserDto.getPassword());
        AppUser appUser = new AppUser(createUserDto.getUsername(), password);

        //TODO find roles
        var roles = extractRoles(inviteCode);

        appUser.setRoles(roles);
        appUser.setOrganisation(organisation);

        appUser = appUserRepository.save(appUser);

        inviteCode.setActive(false);
        inviteCode.setApplicant(appUser);

        return appUser;
    }

    private int extractRoles(InviteCode invite) {
        var invideCode = invite.getInviteCode();
        int rolesId = 1;
        var splited = invideCode.split(InviteCode.SEPARATOR);

        if (splited.length==2){
            rolesId = Integer.parseInt(splited[0]);
        }
        return rolesId;

    }




    @Transactional
    public LoggedUserDto getLoggedUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser user= (AppUser) authentication.getPrincipal();

        AppUser dbUser = appUserRepository.findByUsername(user.getUsername()).orElseThrow(() -> new RuntimeException("TODO"));
        var organisation = dbUser.getOrganisation();
        OrganisationDto organisationDto = new OrganisationDto(organisation.getName(), organisation.getImage());
        var roles = dbUser.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return new LoggedUserDto(dbUser.getUsername(), roles,organisationDto);
    }
}
