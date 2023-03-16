package net.trollheim.security.ctf.repository.spec;

import net.trollheim.security.ctf.model.AppUser;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public enum AppUserSpecifications {
    ;

    Specification<AppUser> findAllUsersForOrganisation(Long organisationId){
        return new Specification<AppUser>() {
            @Override
            public Predicate toPredicate(Root<AppUser> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return  criteriaBuilder.equal(root.get("organisation").get("id"), organisationId);
            }
        };
    }



}
