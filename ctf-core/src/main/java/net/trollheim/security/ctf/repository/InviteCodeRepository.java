package net.trollheim.security.ctf.repository;

import net.trollheim.security.ctf.dto.InviteCodeDto;
import net.trollheim.security.ctf.model.InviteCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InviteCodeRepository extends JpaRepository<InviteCode, Long> {

    InviteCode findByInviteCode(String inviteCode);

//    @Query(value = "SELECT username as name, count(s.id) as score FROM app_user u left join submission s on u.id=s.user_id where u.enabled = true group by u.id, username order by score desc limit 10;", nativeQuery = true)
    List<InviteCode> findByOwnerId (Long userid);
}
