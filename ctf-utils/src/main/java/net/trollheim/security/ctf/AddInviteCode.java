package net.trollheim.security.ctf;

import net.trollheim.security.ctf.model.AppUser;
import net.trollheim.security.ctf.model.InviteCode;
import net.trollheim.security.ctf.model.Organisation;
import net.trollheim.security.ctf.repository.AppUserRepository;
import net.trollheim.security.ctf.repository.InviteCodeRepository;
import net.trollheim.security.ctf.repository.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;
import java.util.UUID;

@SpringBootApplication
@EnableAutoConfiguration
public class AddInviteCode implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AddInviteCode.class, args);
    }

    @Autowired
    OrganisationRepository organisationRepository;

    @Autowired
    InviteCodeRepository inviteCodeRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    void addInviteCode(Organisation organisation, int count){
        for (int i=0;i<count;i++) {
                String code = UUID.randomUUID().toString();
                InviteCode ic  = new InviteCode();
                ic.setActive(true);
                ic.setInviteCode(code);
                ic.setOwner(organisation);

            inviteCodeRepository.save(ic);

            }

        }




    @Override
    public void run(String... args) throws Exception {
        var organisation = organisationRepository.findById(1L).orElseThrow(RuntimeException::new);
//
        addInviteCode(organisation,10);

    }
}
