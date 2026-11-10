package es.uniovi.ds.lab.survey;

import java.util.*;

public class Survey {

    private String question;
    private int yes, no;
    private List<VoteObserver> observers = new ArrayList<>();

    public Survey(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public int getYesVotes() {
        return yes;
    }

    public int getNoVotes() {
        return no;
    }

    public void addYesVote() {
        yes++;
        notifyObservers();
    }

    public void addNoVote() {
        no++;
        notifyObservers();
    }

    // Observer pattern methods

    public void addObserver(VoteObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(VoteObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (VoteObserver observer : observers)
            observer.voteReceived(this);
    }

}
