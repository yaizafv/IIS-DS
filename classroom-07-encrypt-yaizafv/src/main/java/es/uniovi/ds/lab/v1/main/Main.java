package es.uniovi.ds.lab.v1.main;

/**
 * # IMPORTANT: The code provided for this exercise is the minimum necessary to understand
 * the task and should NEVER be taken as an example of proper use of exceptions,
 * assertions, and tests. All of the above, which should be done in a real program, has been
 * intentionally omitted to simplify the exercise.
 */

import java.io.IOException;

import es.uniovi.ds.lab.v1.files.FileSystem;

public class Main {

    public static void main(String[] args) throws IOException {

        FileSystem system = new FileSystem();

        system.copyFile("private.txt", "copia.txt");
        system.sendToInternet("private.txt", "156.17.11.196");
        system.sendWithBluetooth("private.txt", "Galaxy de Raúl");
    }
}
