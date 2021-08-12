package net.trollheim.security.ctf.dto;


public enum Result {
    VALID("valid"),
    INVALID("invalid"),
    EXPIRED("expired"),
    OK("ok"),
    ;


    Result(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    private final String result;

}
