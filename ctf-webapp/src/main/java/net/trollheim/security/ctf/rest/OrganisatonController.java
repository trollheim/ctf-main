package net.trollheim.security.ctf.rest;

import net.trollheim.security.ctf.dto.*;
import net.trollheim.security.ctf.model.AppUser;
import net.trollheim.security.ctf.model.Organisation;
import net.trollheim.security.ctf.service.AppUserService;
import net.trollheim.security.ctf.service.OrganisationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Map;

@RestController()
public class OrganisatonController {

    private final OrganisationService organisationService;

    public OrganisatonController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @PostMapping(path = "/api/admin/organisation/new", consumes = "application/json")
    public Result createNewOrg(@Validated @RequestBody NewOrganisationDto newOrganisationDto) {
        organisationService.createOrganisation(newOrganisationDto);
       return Result.OK;
    }
    @GetMapping(path = "/api/admin/organisation/list")
    public List<OrganisationListItem> getOrganisationsList() {
        return organisationService.getOrganisationsList();
    }

    @RolesAllowed("ROLE_ADMIN")
    @GetMapping(path = "/api/admin/organisation/{id}/addinvite")
    public Result addInvite(@PathVariable("id") Long id) {
        organisationService.addInvite(id,1);
        return Result.OK;
    }

    @PostMapping(path = "/api/admin/organisation/{id}", consumes = "application/json")
    public Result editOrg(@Validated @RequestBody Map createOrg) {
        return Result.OK;
    }

    @DeleteMapping(path = "/api/admin/organisation/{id}")
    public Result delete() {
        return Result.OK;
    }
    
    @GetMapping(path = "/api/admin/organisation/{id}")
    public Result getOrg() {
        return Result.OK;
    }
}
