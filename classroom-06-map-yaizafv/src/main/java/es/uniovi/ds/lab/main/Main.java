/**
 * # IMPORTANT: The code provided for this exercise is the minimum necessary to understand
 * the exercise and should NEVER be taken as an example of proper use of exceptions, assertions,
 * and tests. All of the above, which should be done in a real program, has been intentionally omitted
 * to simplify the exercise.
 */

package es.uniovi.ds.lab.main;

import es.uniovi.ds.lab.adapters.*;
import es.uniovi.ds.lab.database.Database;
import es.uniovi.ds.lab.google.maps.GoogleMap;
import es.uniovi.ds.lab.model.*;

public class Main {

    public static void main(String[] args) {

        Database database = new Database();
        GoogleMap map = new GoogleMap();

        // 1. Add elements to the map
        System.out.println("\n 1. Adding markers to the map");

        for (Monument monument : database.selectMonuments()) {
            map.add(new MonumentAdapter(monument));
        }

        for (Photo photo : database.selectPhotos()) {
            map.add(new PhotoAdapter(photo));
        }

        for (Restaurant restaurant : database.selectRestaurants()) {
            map.add(new RestaurantAdapter(restaurant));
        }

        // 2. Draw the map with the markers for the added elements
        System.out.println("\n 2. Drawing the map with markers");
        map.draw();

        // 3. User briefly presses the screen to receive information about each element
        System.out.println("\n 3. Short press on each element: information in tooltip");
        map.handleShortPress(11, 11); // (Monument) Tooltip: <name>. Built by <author>
        map.handleShortPress(21, 21); // (Photo) Tooltip: <description>. Photo uploaded by <userName>
        map.handleShortPress(31, 31); // (Restaurant) Tooltip: Restaurant '<name>'. Phone: <contactNumber>

        // Actual output:
        // Tooltip: Coliseo. Built by Vespasiano
        // Tooltip: The Coliseum at night. Photo uploaded by Raúl
        // Tooltip: Restaurant 'The Fat Gladiator'. Phone: 555 123 456

        // 4. User long presses a marker to open an element
        System.out.println("\n 4. Long press on each element: open the element");
        map.handleLongPress(11, 11); // (Monument) GPS: Turn right. You have arrived at '<address>''
        map.handleLongPress(21, 21); // (Photo) Downloading photo: <description>
        map.handleLongPress(31, 31); // (Restaurant) Calling <phone_number>

        // Actual output:
        // GPS: Turn right. You have arrived at 'Avenida del Coliseo 1'
        // Downloading photo: The Coliseum at night
        // Calling 555 123 456
    }

}
