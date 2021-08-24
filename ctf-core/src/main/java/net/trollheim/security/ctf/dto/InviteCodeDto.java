package net.trollheim.security.ctf.dto;

public class InviteCodeDto {

    private final String code;
    private final boolean active;

    public InviteCodeDto(String code, boolean active) {
        this.code = code;
        this.active = active;
    }

    public String getCode() {
        return code;
    }


    public boolean isActive() {
        return active;
    }
}
