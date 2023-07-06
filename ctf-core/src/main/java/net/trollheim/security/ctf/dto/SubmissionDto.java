package net.trollheim.security.ctf.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class SubmissionDto {


    private Long flag;

    @NotBlank
    private String code;

    public Long getFlag() {
        return flag;
    }

    public void setFlag(Long flag) {
        this.flag = flag;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}


