# Código Refactorizado (para Vs Code)

Solution to problem 3:

1. In `Rental.java`, add the following methods:

    ```java
    public class Rental {

        ...

        // Add these two methods

        double getPrice() {
            return movie.getPrice(this);
        }

        int getPoints() {
            return movie.getPoints(this);
        }

    ```

2. In `Customer.java`, modify these two statements to remove the `getMovie()` invocation:

    ```java
    public void printReport() {

        ...
        for (Rental rental : rentals) {

            // 1) Calculate the price of each rental
            double rentalPrice = rental.getPrice();

            // 2) Each rental gives 1 point. Extra point for new releases rented for 2 or more days
            int rentalPoints = rental.getPoints();

            ...

        }
    }
    ```
