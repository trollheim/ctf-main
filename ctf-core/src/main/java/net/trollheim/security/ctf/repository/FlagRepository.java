package net.trollheim.security.ctf.repository;

import net.trollheim.security.ctf.model.Flag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlagRepository extends JpaRepository<Flag, Long>, JpaSpecificationExecutor<Flag> {
}
