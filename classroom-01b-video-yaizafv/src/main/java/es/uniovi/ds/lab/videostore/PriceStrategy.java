package es.uniovi.ds.lab.videostore;

public interface PriceStrategy {
	double getPrice(Rental rental);
    int getPoints(Rental rental);
}
