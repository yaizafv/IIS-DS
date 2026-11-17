package es.uniovi.ds.lab.model;

import es.uniovi.ds.lab.structures.*;

public class Match {
    private Team homeTeam;
    private Team awayTeam;

    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public Team homeTeam() {
        return homeTeam;
    }

    public Team awayTeam() {
        return awayTeam;
    }

    public void play() {

        System.out.println(
                "Match between '" + homeTeam.getName() + "' and '" + awayTeam.getName() + "' is being played.");

        String player;

        System.out.println("Home Team Players:");
        MyIterator homePlayers = homeTeam.players();
        while ((player = homePlayers.next()) != null)
            System.out.println("- " + player);

        System.out.println("Away Team Players:");
        MyIterator awayPlayers = awayTeam.players();
        while ((player = awayPlayers.next()) != null)
            System.out.println("- " + player);
    }
}
