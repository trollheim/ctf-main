package net.trollheim.security.ctf.dto;

public class FlagDetailsDto {
    private int number;
    private String title;
    private String description;
    private String url;
    private boolean submitted;

    public FlagDetailsDto(int number, String title, String description, String url, boolean submitted) {
        this.number = number;
        this.title = title;
        this.description = description;
        this.url = url;
        this.submitted = submitted;
    }

    public FlagDetailsDto() {
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }
}
