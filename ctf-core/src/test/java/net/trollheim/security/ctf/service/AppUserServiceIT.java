package net.trollheim.security.ctf.service;

import net.trollheim.security.ctf.TestConfiguration;

import net.trollheim.security.ctf.model.AppUser;
import net.trollheim.security.ctf.repository.AppUserRepository;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


@Profile("test")
@SpringBootTest(classes = {TestConfiguration.class})
public class AppUserServiceIT {


    @Autowired
    AppUserService appUserService;

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    Flyway flyway;

    @BeforeEach
    public void setup(){

      flyway.clean();

      flyway.migrate();

    }



    @Test
    @DisplayName("getUsers")
    public void getRanks() {

        UserDetails appuser = appUserService.loadUserByUsername("AnotherUser_3");
        Assertions.assertNotNull(appuser);
    }


}