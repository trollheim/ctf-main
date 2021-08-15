package net.trollheim.security.ctf.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class SubmissionDto {


    private int flag;

    @NotBlank
    private String code;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}


