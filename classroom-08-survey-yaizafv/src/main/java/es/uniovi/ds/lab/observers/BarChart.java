package es.uniovi.ds.lab.observers;

import es.uniovi.ds.lab.survey.*;

public class BarChart implements VoteObserver {

    public void voteReceived(Survey survey) {
        System.out.println("BarChart: Yes=" + survey.getYesVotes() + ", No=" + survey.getNoVotes());
    }
}
