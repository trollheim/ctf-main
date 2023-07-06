package net.trollheim.security.ctf.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

//@Entity
public class AppUserRole implements GrantedAuthority {

    @Id
    private Long id;



    private String authority;

//    @ManyToMany(mappedBy = "roles")
//    List<AppUser> users;



    @Override
    public String getAuthority() {
        return authority;
    }
}
