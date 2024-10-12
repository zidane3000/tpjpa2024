package com.kahoot.dto;

public class KahootDTO {

        private int score;
        private int classement;
        private String type;
        private String question;

        // Getters and Setters
        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getClassement() {
            return classement;
        }

        public void setClassement(int classement) {
            this.classement = classement;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

}
