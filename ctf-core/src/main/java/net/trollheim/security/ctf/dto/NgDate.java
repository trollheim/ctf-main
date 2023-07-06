package net.trollheim.security.ctf.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record NgDate(int day, int month, int year) {


    public LocalDate asLocalDate() {

        String date = "%d-%02d-%02d".formatted(year,month,day);
        return LocalDate.parse(date);
    }
}
