package net.trollheim.security.ctf.dto;

import java.util.List;

public class ScoreDto {


    private int total;
    private List<Flag> flags;

    public List<Flag> getFlags() {
        return flags;
    }

    public void setFlags(List<Flag> flags) {
        this.flags = flags;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public static class Flag {
        private String title;
        private int score;

        public Flag(String title, int score) {
            this.title = title;
            this.score = score;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }

}
