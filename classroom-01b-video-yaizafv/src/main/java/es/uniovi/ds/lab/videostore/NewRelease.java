package es.uniovi.ds.lab.videostore;

public class NewRelease implements PriceStrategy {

	@Override
	public double getPrice(Rental rental) {
		double rentalPrice = 0;
		rentalPrice += rental.getDays() * 3;
		return rentalPrice;
	}

	@Override
	public int getPoints(Rental rental) {
		int rentalPoints = 1;
        if (rental.getDays() > 1)
            rentalPoints = 2;
        return rentalPoints;
	}
	
	
}
