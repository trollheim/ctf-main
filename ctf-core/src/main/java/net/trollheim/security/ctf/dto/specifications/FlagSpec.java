package net.trollheim.security.ctf.dto.specifications;

import net.trollheim.security.ctf.model.Flag;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public enum FlagSpec {
    ;


    public final static Specification<Flag> FIND_ACTIVE = (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("endDate"), LocalDateTime.now());
}
