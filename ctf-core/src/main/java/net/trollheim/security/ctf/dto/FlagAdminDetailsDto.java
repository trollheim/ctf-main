package net.trollheim.security.ctf.dto;

import net.trollheim.security.ctf.model.Flag;

import java.time.LocalDateTime;

public record FlagAdminDetailsDto(long id, String title, String description, String start, LocalDateTime end, String url, int submissions) {

    public static FlagAdminDetailsDto fromFlag(Flag flag) {

        return new FlagAdminDetailsDto(flag.getId(), flag.getTitle(), flag.getDescription(), "", flag.getEndDate(), flag.getUrl(), flag.getSubmissions().size());
    }
}
