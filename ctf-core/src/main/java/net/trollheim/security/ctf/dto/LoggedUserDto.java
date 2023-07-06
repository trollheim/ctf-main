package net.trollheim.security.ctf.dto;

import java.util.List;

public record LoggedUserDto (

        String username, List<String> roles, OrganisationDto organisation){




}
