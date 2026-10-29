package es.uniovi.ds.lab.adapters;

import es.uniovi.ds.lab.google.maps.*;
import es.uniovi.ds.lab.model.Restaurant;

public class RestaurantAdapter implements Marker {

    private Restaurant restaurant;
    private LocationService navigator = new LocationService();

    public RestaurantAdapter(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public Coordinates getCoordinates() {
        return navigator.convertAddressToCoordinates(restaurant.getAddress());
    }

    @Override
    public String getInfo() {
        return "Restaurant '" + restaurant.getName() + "'. Phone: " + restaurant.getContactNumber();
    }

    @Override
    public void open() {
        restaurant.callRestaurant();
    }

}
