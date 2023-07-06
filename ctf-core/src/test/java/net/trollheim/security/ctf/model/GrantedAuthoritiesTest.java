package net.trollheim.security.ctf.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrantedAuthoritiesTest {
    @Test
    @DisplayName("get all privileges")
    public void getAll() {
         var allRoles =  GrantedAuthorities.fromId(15);
        System.out.println(allRoles);

    }
}