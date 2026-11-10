package es.uniovi.ds.lab.observers.wrappers;

import es.uniovi.ds.lab.survey.*;

public class Sampler implements VoteObserver {

    private VoteObserver otherObserver;
    private int count, frequency;

    public Sampler(int frequency, VoteObserver otherObserver) {
        this.otherObserver = otherObserver;
        this.count = this.frequency = frequency;
    }

    @Override
    public void voteReceived(Survey survey) {

        if (count == frequency) {
            otherObserver.voteReceived(survey);
            count = 1;
        } else
            count++;
    }

}

// --------------------------------
// QUESTION: Which pattern is this class implementing (apart from the Observer pattern)?
