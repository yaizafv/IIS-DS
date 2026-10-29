package es.uniovi.ds.lab.google.maps;

public interface Marker {

    // Returns the position of the marker in the map
    Coordinates getCoordinates();

    // Returns the information to be shown in the tooltip
    String getInfo();

    // Opens the marker (marker-specific action)
    void open();
}
