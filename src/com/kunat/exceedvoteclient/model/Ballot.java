package com.kunat.exceedvoteclient.model;


public class Ballot{

        public Long id;
        public Contestant contestant;
        
        public int score;
        
      
        public Ballot() {
                
        }
        
        public Ballot(Contestant contestant, int score) {
                this.contestant = contestant;
                this.score = score;
        }
        
        public Contestant getContestant() {
                return contestant;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public void setContestant(Contestant contestant) {
                this.contestant = contestant;
        }

        public int getScore() {
                return score;
        }

        public void setScore(int score) {
                this.score = score;
        }
        
        public String toString() {
                return "";
        }

}