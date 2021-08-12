package net.trollheim.security.ctf;

import net.trollheim.security.ctf.model.AppUser;
import net.trollheim.security.ctf.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableAutoConfiguration
public class AddUser implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AddUser.class, args);
    }

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
//        appUserRepository.findTopPlayers().stream().map(u->u.getName()+
//                " "+u.getScore()).forEach(System.out::println);
//        String password = passwordEncoder.encode("password");
//        AppUser appUser = new AppUser("test123", password);
//
//        appUserRepository.save(appUser);
    }
}
