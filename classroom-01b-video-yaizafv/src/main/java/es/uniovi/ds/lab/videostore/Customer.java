package es.uniovi.ds.lab.videostore;

import java.util.*;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public void printReport() {
        double totalPrice = 0;
        int totalPoints = 0;
        System.out.println("Rental report for: " + getName());

        for (Rental rental : rentals) {

            double rentalPrice = rental.getPrice();

            int rentalPoints = rental.getPoints();

            // 3) Accumulate totals
            totalPrice += rentalPrice;
            totalPoints += rentalPoints;

            // 4) Show the price of this rental
            System.out.println("\t- " + rental.getMovie().getTitle() + "\t" + rentalPrice);

        }

        System.out.println("The total debt is " + totalPrice);
        System.out.println("You have earned " + totalPoints + " points on your card.");
    }
}
