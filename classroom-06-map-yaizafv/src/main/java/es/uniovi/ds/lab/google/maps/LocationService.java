package es.uniovi.ds.lab.google.maps;

public class LocationService {

    // Given an address, returns its coordinates
    public Coordinates convertAddressToCoordinates(String address) {
        // Placeholder implementation
        double number = (address.toLowerCase().charAt(0) - 'a') * 10 + 10;
        return new Coordinates(number, number);
    }

    // Given coordinates, returns the corresponding address
    public String convertCoordinatesToAddress(Coordinates coordinates) {
        // Placeholder implementation
        return coordinates.toString();
    }

    // Method that, given an address, starts the process of navigating to it
    public void openGpsNavigator(String address) {
        // Placeholder implementation
        System.out.println("GPS: Turn right. You have arrived at '" + address + "'");
    }
}
