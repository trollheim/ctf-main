package net.trollheim.security.ctf.repository;

import net.trollheim.security.ctf.dto.ScoreDto;

import java.util.List;

public interface FlagRepositoryCustom {

    List<ScoreDto.Flag> getUserFlags(long userId);

}
