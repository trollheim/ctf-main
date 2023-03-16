package net.trollheim.security.ctf.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public enum GrantedAuthorities implements GrantedAuthority {




    USER(1, "ROLE_USER"),          //can sumbit solutions
    CREATOR(2, "ROLE_CREATOR"),    //can create flags
    ORG_ADMIN(4,"ROLE_ORG_ADMIN"),//can invite people to organisation
    APP_ADMIN(8, "ROLE_ADMIN")     //can create organisation, and invite people
    ;


    public static final String[] ADMIN_ROLES = {"APP_ADMIN", "ORG_ADMIN"};

    public final String role;
    private final int roleId;

    GrantedAuthorities(int id, String role) {
        this.role = role;
        this.roleId = id;
    }

    @Override
    public String getAuthority() {
        return role;
    }


    public static List<GrantedAuthorities> fromId(int id){
        var list = new ArrayList<GrantedAuthorities>();
        if(id%2 ==1){
            id/=2;
            list.add(USER);
        }
        if(id%2 ==1){
            id/=2;
            list.add(CREATOR);
        }
        if(id%2 ==1){
            id/=2;
            list.add(ORG_ADMIN);
        }
        if(id%2 ==1){
            list.add(APP_ADMIN);
        }

        return list;
    }


}
