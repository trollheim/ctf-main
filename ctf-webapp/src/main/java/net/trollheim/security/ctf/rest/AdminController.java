package net.trollheim.security.ctf.rest;

import net.trollheim.security.ctf.dto.FlagAdminDetailsDto;
import net.trollheim.security.ctf.dto.NewFlagDto;
import net.trollheim.security.ctf.dto.Result;
import net.trollheim.security.ctf.service.FlagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    private final FlagService flagService;

    public AdminController(FlagService flagService) {
        this.flagService = flagService;
    }

    @GetMapping("/api/admin/flag/list")
    public List<FlagAdminDetailsDto> getAdminFlagsDetails() {
        return flagService.getAdminFlagsDetails();
    }

    @PostMapping(value = "/api/admin/flag/new", consumes = "application/json")
    public Result createNewFlag(@RequestBody NewFlagDto newFlagDto) {
        flagService.createFlag(newFlagDto);
        return Result.OK;
    }

}
