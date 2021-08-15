package net.trollheim.security.ctf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class SecurityConfiguration extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http

                .cors().and().csrf().disable()
                .formLogin().loginProcessingUrl("/login").loginPage("/")
    .defaultSuccessUrl("/app/index.html")
                .and().authorizeRequests().antMatchers("/", "/res/**","/index.html", "/userAPI/register").
                permitAll().anyRequest().authenticated();

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.setOrder(Ordered.LOWEST_PRECEDENCE);
        registry.addViewController("/").setViewName("forward:index.html");
//        registry.addViewController("{/app(/?)(#?)}").setViewName("forward:app/index.html");
        registry.addViewController("/app").setViewName("forward:app/index.html");
        registry.addViewController("/app/").setViewName("forward:app/index.html");



    }
}