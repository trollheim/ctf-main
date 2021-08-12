package net.trollheim.security.ctf.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AppUserRoles implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }
}
