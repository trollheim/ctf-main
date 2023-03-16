package net.trollheim.security.ctf;

import net.trollheim.security.ctf.model.AppUser;
import net.trollheim.security.ctf.model.InviteCode;
import net.trollheim.security.ctf.repository.AppUserRepository;
import net.trollheim.security.ctf.repository.InviteCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

@SpringBootApplication
@EnableAutoConfiguration
public class AddUser implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AddUser.class, args);
    }

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    InviteCodeRepository inviteCodeRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
//        appUserRepository.findAll().stream().flatMap(u-> inviteCodeRepository.findByOwnerId(u.getId()).stream()).map(i->i.getInviteCode()).forEach(System.out::println);

        AppUser user = appUserRepository.findByUsername("test123").orElseThrow(RuntimeException::new);
        Set<InviteCode> codes = user.getOrganisation().getInviteCodes();
        codes.forEach(c-> System.out.println(c.getInviteCode()+" "+c.isActive()));
////        for (AppUser u : appUserRepository.findAll()){
////            Set<InviteCode> codes = new HashSet<>();
//            for (int i=0;i<20;i++) {
//                String code = UUID.randomUUID().toString();
//                InviteCode ic  = new InviteCode();
//                ic.setActive(true);
//                ic.setInviteCode(code);
//                ic.setOwner(user);
//                codes.add(ic);
//            }
////            u.setInviteCodes(codes);
//            appUserRepository.save(user);
//        }

//        appUserRepository.findTopPlayers().stream().map(u->u.getName()+
//                " "+u.getScore()).forEach(System.out::println);
//        String password = passwordEncoder.encode("password");
//        AppUser appUser = new AppUser("aegon", password);
//        appUser.setEnabled(false);
//        Set<InviteCode> codes = new HashSet<>();
//        for (int i=0;i<10;i++) {
//                String code = UUID.randomUUID().toString();
//                InviteCode ic  = new InviteCode();
//                ic.setActive(true);
//                ic.setInviteCode(code);
//                ic.setOwner(appUser);
//                codes.add(ic);
//            }
//        appUser.setInviteCodes(codes);
////
//        appUserRepository.save(appUser);
    }
}
