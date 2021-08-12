package net.trollheim.security.ctf.repository;

import net.trollheim.security.ctf.model.InviteCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InviteCodeRepository extends JpaRepository<InviteCode, Long> {

    InviteCode findByInviteCode(String inviteCode);
}
