package net.trollheim.security.ctf.repository;

import net.trollheim.security.ctf.dto.ScoreDto;
import net.trollheim.security.ctf.model.Flag;
import net.trollheim.security.ctf.model.Submission;


import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

public class FlagRepositoryImpl implements FlagRepositoryCustom{


    private final EntityManager entityManager;

    public FlagRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<ScoreDto.Flag> getUserFlags(long userId) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ScoreDto.Flag> criteriaQuery =
                builder.createQuery(ScoreDto.Flag.class);
        Root<Flag> flag = criteriaQuery.from(Flag.class);
        Join<Flag, Submission> submission = flag.join("submission", JoinType.LEFT);

        criteriaQuery.multiselect(flag.get("title") );

        return null;
    }
}
