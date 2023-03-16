package net.trollheim.security.ctf.service;

import net.trollheim.security.ctf.TestConfiguration;
import net.trollheim.security.ctf.dto.RankDto;
import net.trollheim.security.ctf.model.AppUser;
import net.trollheim.security.ctf.model.Organisation;
import net.trollheim.security.ctf.repository.AppUserRepository;
import net.trollheim.security.ctf.repository.FlagRepository;
import net.trollheim.security.ctf.repository.OrganisationRepository;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;


@Profile("test")
@SpringBootTest(classes = {TestConfiguration.class})
public class FlagServiceIT {


    @Autowired
    FlagService flagService;

    @Autowired
    FlagRepository flagRepository;


    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    OrganisationRepository organisationRepository;

    @Autowired
    Flyway flyway;

    @BeforeEach
    public void setup(){

        flyway.clean();

        flyway.migrate();

        AppUser user = appUserRepository.findById(1L).orElseThrow(() -> new RuntimeException("test is not ready"));
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user,""));
    }

    @Test
    @DisplayName("aaa")
  //  @WithMockUser(username="admin",roles={"USER","ADMIN"})
    public void getRanks(){
        RankDto result = flagService.getRanks();
        assertNotNull(result);
        assertEquals(3,result.getTop().size());
        Optional<String> optionalUser = result.getTop().stream().map(RankDto.Score::getName)
                .filter(n -> n.equals("AnotherUser_3")).findFirst();
        assertFalse(optionalUser.isPresent());
    }
    @Test
    @DisplayName("bbb")
    //  @WithMockUser(username="admin",roles={"USER","ADMIN"})
    public void getRank2s(){
        RankDto result = flagService.getRanks();
        assertNotNull(result);
    }

    @AfterEach
    public void clean(){

    }
}