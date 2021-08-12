package net.trollheim.security.ctf.rest;

import net.trollheim.security.ctf.dto.CreateUserDto;
import net.trollheim.security.ctf.dto.Result;
import net.trollheim.security.ctf.model.AppUser;
import net.trollheim.security.ctf.service.AppUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    private final AppUserService appUserService;

    public UserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping(path = "/userAPI/register", consumes = "application/json")
    public Result register(@RequestBody CreateUserDto createUserDto) {

        AppUser user = appUserService.createUser(createUserDto);
        return Result.OK;
    }

    @GetMapping(path = "/userAPI/register")
    public Result registerx() {

        return Result.OK;
    }
}
