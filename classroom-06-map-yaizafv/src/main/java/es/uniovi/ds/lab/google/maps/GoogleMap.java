package es.uniovi.ds.lab.google.maps;

import java.awt.Rectangle;
import java.util.*;

public class GoogleMap {
    private List<Marker> markers = new ArrayList<>();

    public void add(Marker element) {
        markers.add(element);
    }

    public void draw() {
        // 1. Here the map will be drawn
        // Optional exercise for home :)

        // 2. And now the markers will be drawn on top
        for (Marker marker : markers)
            System.out.println("Marker at " + marker.getCoordinates());
    }

    public void handleShortPress(int x, int y) {
        Marker marker = findMarker(x, y);
        if (marker != null)
            System.out.println("Tooltip: " + marker.getInfo());
    }

    public void handleLongPress(int x, int y) {
        Marker marker = findMarker(x, y);
        if (marker != null)
            marker.open();
    }

    // Private helper method ----------------------
    private Marker findMarker(int x, int y) {
        for (Marker marker : markers) {
            Coordinates coordinates = marker.getCoordinates();
            var elementArea = new Rectangle((int) coordinates.getLongitude(), (int) coordinates.getLatitude(), 9, 9);
            if (elementArea.contains(x, y))
                return marker;
        }
        return null;
    }

}
