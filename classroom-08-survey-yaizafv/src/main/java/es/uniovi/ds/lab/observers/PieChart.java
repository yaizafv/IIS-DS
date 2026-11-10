package es.uniovi.ds.lab.observers;

import es.uniovi.ds.lab.survey.*;

public class PieChart implements VoteObserver {

    public void voteReceived(Survey survey) {
        System.out.println("PieChart: Yes=" + survey.getYesVotes() + ", No=" + survey.getNoVotes());
    }
}
