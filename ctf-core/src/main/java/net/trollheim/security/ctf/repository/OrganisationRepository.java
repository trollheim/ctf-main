package net.trollheim.security.ctf.repository;

import net.trollheim.security.ctf.model.Organisation;
import net.trollheim.security.ctf.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationRepository extends JpaRepository<Organisation, Long>, JpaSpecificationExecutor<Organisation> {
}
