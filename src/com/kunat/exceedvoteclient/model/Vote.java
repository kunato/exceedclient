package com.kunat.exceedvoteclient.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="vote")
public class Vote{
       	@Element(name="id")
        public Long id;
        
        public User user;
        
        public Criterion criterion;
        @Element(name="contestants")
        public List<Ballot> ballots = new ArrayList<Ballot>();
        
       

        public Vote() {
                
        }
        
        public Vote(User user, Criterion criterion) {
                this.user = user;
                this.criterion = criterion;
        }
        
        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }
        
        public User getUser() {
                return user;
        }

        public void setUser(User user) {
                this.user = user;
        }

        public Criterion getCriterion() {
                return criterion;
        }

        public void setCriterion(Criterion criterion) {
                this.criterion = criterion;
        }
        
        public List<Ballot> getBallots() {
                return ballots;
        }

        public void setBallots(List<Ballot> ballots) {
                this.ballots = ballots;
        }
        
        public int getBallotsNumber() {
                return ballots.size();
        }
        
        public void addBallot(Ballot ballot) {
                ballots.add(ballot);
        }

        public String toString() {
                return "";
        }

}