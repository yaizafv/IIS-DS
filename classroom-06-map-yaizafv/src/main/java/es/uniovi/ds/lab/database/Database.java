package es.uniovi.ds.lab.database;

import java.util.*;

import es.uniovi.ds.lab.google.maps.Coordinates;
import es.uniovi.ds.lab.model.*;

// Class that simulates access to the Database
public class Database {

    public Collection<Monument> selectMonuments() {
        var monuments = new ArrayList<Monument>();
        monuments.add(new Monument("Coliseo", "Vespasiano", "Avenida del Coliseo 1"));
        monuments.add(new Monument("Fontana di Trevi", "Niccolo Salvi", "Piazza di Trevi"));
        return monuments;
    }

    public Collection<Photo> selectPhotos() {
        var photos = new ArrayList<Photo>();
        photos.add(new Photo("Raúl", "The Coliseum at night", new Coordinates(20, 20)));
        photos.add(new Photo("Raúl", "Un perro mordiendo a un turista", new Coordinates(40, 40)));
        return photos;
    }

    public Collection<Restaurant> selectRestaurants() {
        var restaurants = new ArrayList<Restaurant>();
        restaurants.add(new Restaurant("The Fat Gladiator", "Coliseo arriba", "555 123 456"));
        restaurants.add(new Restaurant("Mario Gross", "Via della Dataria", "555 123 457"));
        return restaurants;
    }
}
