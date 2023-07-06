package net.trollheim.security.ctf.service;

import net.trollheim.security.ctf.dto.NewOrganisationDto;
import net.trollheim.security.ctf.dto.OrganisationListItem;
import net.trollheim.security.ctf.model.AppUser;
import net.trollheim.security.ctf.model.InviteCode;
import net.trollheim.security.ctf.model.Organisation;
import net.trollheim.security.ctf.repository.InviteCodeRepository;
import net.trollheim.security.ctf.repository.OrganisationRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class OrganisationService {
    private final OrganisationRepository organisationRepository;
    private final InviteCodeRepository inviteCodeRepository;

    public OrganisationService(OrganisationRepository organisationRepository, InviteCodeRepository inviteCodeRepository) {
        this.organisationRepository = organisationRepository;
        this.inviteCodeRepository = inviteCodeRepository;
    }

    public void addInvite(Long id, int inviteCount) {
        var user = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var organisation = organisationRepository.findById(id).orElseThrow(RuntimeException::new);


            for (int i=0;i<inviteCount;i++){
                InviteCode code = new InviteCode();
                code.setInviteCode(UUID.randomUUID().toString());
                code.setActive(true);
                code.setOwner(organisation);
                inviteCodeRepository.save(code);
            }


    }

    @Transactional
    public List<OrganisationListItem> getOrganisationsList() {
        return organisationRepository.findAll().stream().map(this::asOrganisationListItem).toList();

    }

    private OrganisationListItem asOrganisationListItem(Organisation organisation) {
        return new OrganisationListItem(organisation.getId(),organisation.getName(), organisation.getImage(),organisation.getUsers().size());
    }

    public void createOrganisation(NewOrganisationDto newOrganisationDto) {
        Organisation organisation = new Organisation();
        organisation.setName(newOrganisationDto.name());
        organisation.setImage(newOrganisationDto.image());
        organisationRepository.save(organisation);
    }
}
