package net.trollheim.security.ctf.dto;

public record NewFlagDto(String title, String description, String code, String url, NgDate startDate, NgDate endDate) {
}
