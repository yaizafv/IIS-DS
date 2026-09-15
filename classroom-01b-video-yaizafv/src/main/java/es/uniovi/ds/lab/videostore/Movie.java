package es.uniovi.ds.lab.videostore;

public class Movie {
    private String title;
    private PriceStrategy priceStrategy; // Usamos la interfaz

    public Movie(String title, PriceStrategy priceStrategy) {
        this.title = title;
        this.priceStrategy = priceStrategy;
    }

    public PriceStrategy getPriceStrategy() {
        return priceStrategy;
    }

    public void setPriceStrategy(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public String getTitle() {
        return title;
    }

    double getPrice(Rental rental) {
        return priceStrategy.getPrice(rental);
    }

    int getPoints(Rental rental) {
        return priceStrategy.getPoints(rental);
    }
}
