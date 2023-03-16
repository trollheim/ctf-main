package net.trollheim.security.ctf.repository;

import net.trollheim.security.ctf.dto.RankDto;
import net.trollheim.security.ctf.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long>, JpaSpecificationExecutor<AppUser> {

    Optional<AppUser> findByUsername(String username);

    @Query(value = "SELECT username as name, count(s.id) as score FROM app_user u left join submission s on u.id=s.user_id where u.organisation_id = :organisationId and u.enabled = true group by u.id, username order by score desc limit 10;", nativeQuery = true)
    List<RankDto.Score> findTopPlayers(Long organisationId);



}
