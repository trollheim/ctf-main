package net.trollheim.security.ctf.service;


import net.trollheim.security.ctf.dto.CreateUserDto;
import net.trollheim.security.ctf.model.AppUser;
import net.trollheim.security.ctf.model.InviteCode;
import net.trollheim.security.ctf.repository.AppUserRepository;
import net.trollheim.security.ctf.repository.InviteCodeRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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


    public AppUser createUser(CreateUserDto createUserDto) {
        InviteCode inviteCode = inviteCodeRepository.findByInviteCode(createUserDto.getInviteCode());
        if (inviteCode == null) {
            //TODO exception hierarchy
            throw new RuntimeException();
        }
        String password = passwordEncoder.encode(createUserDto.getPassword());
        AppUser appUser = new AppUser(createUserDto.getUsername(), password);
        appUserRepository.save(appUser);
        inviteCodeRepository.delete(inviteCode);
        return appUser;
    }

}
