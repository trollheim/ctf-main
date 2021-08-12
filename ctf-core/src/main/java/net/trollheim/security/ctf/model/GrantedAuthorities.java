package net.trollheim.security.ctf.model;

import org.springframework.security.core.GrantedAuthority;

public enum GrantedAuthorities implements GrantedAuthority {

    USER("ROLE_USER"), ADMIN("ROLE_ADMIN");

    private final String role;

    GrantedAuthorities(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
