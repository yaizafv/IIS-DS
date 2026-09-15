package es.uniovi.ds.lab.videostore;

public class Children implements PriceStrategy {

	@Override
	public double getPrice(Rental rental) {
		double rentalPrice = 0;
		rentalPrice += 1.5;
        if (rental.getDays() > 3)
            rentalPrice += (rental.getDays() - 3) * 1.5;
        return rentalPrice;
	}

	@Override
	public int getPoints(Rental rental) {
		int rentalPoints = 1;
        return rentalPoints;
	}

	
	

}
