package es.uniovi.ds.lab.adapters;

import es.uniovi.ds.lab.google.maps.*;
import es.uniovi.ds.lab.model.Photo;

public class PhotoAdapter implements Marker {

    private Photo photo;

    public PhotoAdapter(Photo photo) {
        this.photo = photo;
    }

    @Override
    public Coordinates getCoordinates() {
        return photo.getCoordinates();
    }

    @Override
    public String getInfo() {
        return photo.getDescription() + ". Photo uploaded by " + photo.getUserName();
    }

    @Override
    public void open() {
        photo.download();
    }

}
