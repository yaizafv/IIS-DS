package es.uniovi.ds.lab.main;

import es.uniovi.ds.lab.videostore.*;

public class Main {

    public static void main(String[] args) {

        Movie hotFuzz = new Movie("Hot Fuzz", new NewRelease());
        Movie toyStory = new Movie("Toy Story", new Children());
        Movie zombiesParty = new Movie("Zombies Party", new Standard());

        Customer raul = new Customer("Raúl");

        raul.addRental(new Rental(hotFuzz, 2));
        raul.addRental(new Rental(toyStory, 6));
        raul.addRental(new Rental(zombiesParty, 8));

        raul.printReport();
    }
}
