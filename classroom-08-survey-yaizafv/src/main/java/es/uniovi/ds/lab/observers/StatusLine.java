package es.uniovi.ds.lab.observers;

import es.uniovi.ds.lab.survey.*;

public class StatusLine implements VoteObserver {

    public void voteReceived(Survey survey) {
        System.out.println("StatusLine: Yes=" + survey.getYesVotes() + ", No=" + survey.getNoVotes());
    }

}
