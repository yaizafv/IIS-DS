package es.uniovi.ds.lab.main.basic;

import static es.uniovi.ds.lab.operations.Disk.*;

import es.uniovi.ds.lab.model.*;

public class Exercise4 {

    public static void main(String[] args) throws Exception {

        Team homeTeam = new Team("Lucareños", fileIterator("Home team substitutes.txt"));
        Team awayTeam = new Team("Negreira Boys", fileIterator("Away team substitutes.txt"));

        Match match = new Match(homeTeam, awayTeam);
        match.play();

        /*
        Follow these steps:
        
        1. Read the Team and Match classes.
        
        2. Modify Team so that it stores the "players" in a MyVector instead of a MyLinkedList.
           - Considering the changes required, do you think the design was adequate? Why or why not?
           - Improve the design if you consider it necessary.
        
        3. Change Team again so that the "players" are now stored in a MyDoubleList instead of a MyVector.
           - Did you need to modify the Match class for this?
        
        4. Finally, update the code at the beginning of this method to load the player names from "Home team substitutes.txt" and "Away team substitutes.txt" respectively.
        
           Team homeTeam = new Team("Lucareños", ... "Home team substitutes.txt"...);
           Team awayTeam = new Team("Negreira Boys", ... "Away team substitutes.txt"...);
           ...
        */
    }
}
