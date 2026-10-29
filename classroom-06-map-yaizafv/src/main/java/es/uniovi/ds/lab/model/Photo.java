package es.uniovi.ds.lab.model;

import es.uniovi.ds.lab.google.maps.Coordinates;

public class Photo {

    private String userName; // User who uploaded the photo
    private String description;
    private Coordinates coordinates; // GPS coordinates where the photo was taken

    public Photo(String userName, String description, Coordinates coordinates) {
        this.userName = userName;
        this.description = description;
        this.coordinates = coordinates;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void download() {
        System.out.println("Downloading photo: " + description);
    }

}
