package net.trollheim.security.ctf.dto;

import java.util.ArrayList;
import java.util.List;

public class RankDto {
    private int player;
    private List<Score> top;

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public List<Score> getTop() {
        return top;
    }

    public void setTop(List<Score> top) {
        this.top = top;
    }


    public static interface Score {

//        private String name;
//        private int score;
//
//        public Score(String name, int score) {
//            this.name = name;
//            this.score = score;
//        }

        public String getName() ;

//        public void setName(String name) {
//            this.name = name;
//        }

        public int getScore() ;

    }


}
