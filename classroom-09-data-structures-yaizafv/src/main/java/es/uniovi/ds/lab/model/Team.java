package es.uniovi.ds.lab.model;

import es.uniovi.ds.lab.structures.*;

public class Team {
    private String name;
    private MyLinkedList players;

    public Team(String name, MyIterator players) {
        this.name = name;
        this.players = new MyLinkedList(players);
    }

    public String getName() {
        return name;
    }

    public MyIterator players() {
        return players.iterator();
    }

    // public void addPlayer(String name) {
    //     players.add(name);
    // }

}
