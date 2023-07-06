package net.trollheim.security.ctf.repository.spec;

import net.trollheim.security.ctf.model.AppUser;
import net.trollheim.security.ctf.model.Organisation;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public enum OrganisationSpecifications {
    ;

    public static Specification<Organisation> withUser(String username){
        return new Specification<Organisation>() {
            @Override
            public Predicate toPredicate(Root<Organisation> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return  criteriaBuilder.equal(root.join("users").get("username"), username);
            }
        };
    }



}
