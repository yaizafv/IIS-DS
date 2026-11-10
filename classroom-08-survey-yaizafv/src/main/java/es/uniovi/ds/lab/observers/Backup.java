package es.uniovi.ds.lab.observers;

import es.uniovi.ds.lab.survey.*;

public class Backup implements VoteObserver {

    public void voteReceived(Survey survey) {
        System.out.println("Backup: Yes=" + survey.getYesVotes() + ", No=" + survey.getNoVotes());
    }
}
