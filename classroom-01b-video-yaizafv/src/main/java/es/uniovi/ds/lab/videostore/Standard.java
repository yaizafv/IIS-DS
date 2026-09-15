package es.uniovi.ds.lab.videostore;

public class Standard implements PriceStrategy {

	@Override
	public double getPrice(Rental rental) {
		double rentalPrice = 0;
		rentalPrice += 2;
		if (rental.getDays() > 2)
			rentalPrice += (rental.getDays() - 2) * 1.5;
		return rentalPrice;
	}

	@Override
	public int getPoints(Rental rental) {
		int rentalPoints = 1;
        return rentalPoints;
	}


}
