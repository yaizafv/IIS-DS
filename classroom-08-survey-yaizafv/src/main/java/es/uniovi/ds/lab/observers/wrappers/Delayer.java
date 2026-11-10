package es.uniovi.ds.lab.observers.wrappers;

import es.uniovi.ds.lab.survey.*;

public class Delayer implements VoteObserver {

    private VoteObserver otherObserver;
    private int countdown;

    public Delayer(int countdown, VoteObserver otherObserver) {
        this.otherObserver = otherObserver;
        this.countdown = countdown;
    }

    @Override
    public void voteReceived(Survey survey) {

        if (countdown == 1)
            otherObserver.voteReceived(survey);
        else
            countdown--;
    }
}

// --------------------------------
// QUESTION: Which pattern is this class implementing (apart from the Observer pattern)?
