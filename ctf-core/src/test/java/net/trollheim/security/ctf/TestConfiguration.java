package net.trollheim.security.ctf;

import com.zaxxer.hikari.HikariDataSource;
import net.trollheim.security.ctf.model.AppUser;
import net.trollheim.security.ctf.model.Organisation;
import net.trollheim.security.ctf.repository.AppUserRepository;
import net.trollheim.security.ctf.repository.FlagRepository;
import net.trollheim.security.ctf.repository.InviteCodeRepository;
import net.trollheim.security.ctf.repository.OrganisationRepository;
import net.trollheim.security.ctf.service.FlagService;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.junit.ClassRule;
import org.mockito.Mockito;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.TestPropertySourceUtils;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;


@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories
@ComponentScan(basePackages = {
        "net.trollheim.security.ctf"
})
@Testcontainers
public class TestConfiguration {

    @Container
    public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:11.1")
            .withDatabaseName("ctf_tests")
            .withUsername("sa")
            .withPassword("sa");

    static {
        postgreSQLContainer.start();
        System.setProperty("DB_URL", postgreSQLContainer.getJdbcUrl());
    }


    @Bean
    public DataSource dataSource(){
        HikariDataSource    datasource =  new HikariDataSource();
        datasource.setJdbcUrl(postgreSQLContainer.getJdbcUrl());
        datasource.setUsername(postgreSQLContainer.getUsername());
        datasource.setPassword(postgreSQLContainer.getPassword());
        return datasource;
    }
    @Bean
    public Flyway flyway(DataSource dataSource){
        System.out.println(postgreSQLContainer.isRunning());
        FluentConfiguration config = Flyway.configure();
        config.cleanDisabled(false);
        config.dataSource(dataSource);
        return new Flyway(config);
    }



}
