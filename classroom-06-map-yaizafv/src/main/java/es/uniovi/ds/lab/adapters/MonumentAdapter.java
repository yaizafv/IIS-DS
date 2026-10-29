package es.uniovi.ds.lab.adapters;

import es.uniovi.ds.lab.google.maps.*;
import es.uniovi.ds.lab.model.Monument;

public class MonumentAdapter implements Marker {

    private Monument monument;
    private LocationService navigator = new LocationService();

    public MonumentAdapter(Monument monument) {
        this.monument = monument;
    }

    @Override
    public Coordinates getCoordinates() {
        return navigator.convertAddressToCoordinates(monument.getAddress());
    }

    @Override
    public String getInfo() {
        return monument.getName() + ". Built by " + monument.getAuthor();
    }

    @Override
    public void open() {
        navigator.openGpsNavigator(monument.getAddress());
    }

}
