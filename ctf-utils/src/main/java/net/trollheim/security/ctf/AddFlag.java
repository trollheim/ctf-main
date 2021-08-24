package net.trollheim.security.ctf;

import net.trollheim.security.ctf.dto.ScoreDto;
import net.trollheim.security.ctf.model.AppUser;
import net.trollheim.security.ctf.model.Flag;
import net.trollheim.security.ctf.repository.AppUserRepository;
import net.trollheim.security.ctf.repository.FlagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableAutoConfiguration
public class AddFlag implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AddUser.class, args);
    }

    @Autowired
    FlagRepository flagRepository;


    @Override
    public void run(String... args) throws Exception {


//        Flag flag = new Flag();
//        flag.setCode("flag-code");
//        flag.setEndDate(LocalDateTime.now().plusMonths(1L));
//        flag.setNumber(1);
//        flag.setTitle("First flag");
//        flag.setUrl("https://localhost");
//        flag.setDescription("This is flag");
//        flagRepository.save(flag);
    }
}
