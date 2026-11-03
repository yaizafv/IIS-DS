package es.uniovi.ds.lab.v2.main;

/**
 * # IMPORTANT: The code provided for this exercise is the minimum necessary to understand
 * the task and should NEVER be taken as an example of proper use of exceptions,
 * assertions, and tests. All of the above, which should be done in a real program, has been
 * intentionally omitted to simplify the exercise.
 */

import java.io.IOException;

import es.uniovi.ds.lab.v2.files.FileSystem;
import es.uniovi.ds.lab.v2.outputs.*;
import es.uniovi.ds.lab.v2.outputs.filters.*;

public class Main {

    public static void main(String[] args) throws IOException {

        FileSystem system = new FileSystem();

        system.copy("private.txt", new FileOutput("copy.txt"));
        system.copy("private.txt", new InternetOutput("1.1.1.1"));
        system.copy("private.txt", new BluetoothOutput("iPhone"));

        // ------------------------------------------------
        // Base Design
        system.copy("private.txt", new NewLineFormatter(new FileOutput("private2.txt")));
        system.copy("private.txt", new Encryptor(new InternetOutput("1.1.1.1")));
        system.copy("private.txt", new Encryptor(new SpaceRemover(new BluetoothOutput("iPhone"))));

        // ------------------------------------------------
        // Extension 1: allow encryption when writing to file.
        // Changes: None.
        system.copy("private.txt", new NewLineFormatter(new FileOutput("a.txt")));
        system.copy("private.txt", new NewLineFormatter(new Encryptor(new FileOutput("b.txt"))));

        // ------------------------------------------------
        // Extension 2: on Internet, allow normalization and/or space removal.
        // Changes: None.
        system.copy("private.txt", new NewLineFormatter(new InternetOutput("1.1.1.1")));
        system.copy("private.txt", new SpaceRemover(new InternetOutput("1.1.1.1")));
        system.copy("private.txt", new SpaceRemover(new NewLineFormatter(new InternetOutput("1.1.1.1"))));

        // ------------------------------------------------
        // Extension 3: Count written characters.
        // Changes: Add Counter class.
        Counter counter = new Counter(new InternetOutput("1.1.1.1"));
        system.copy("private.txt", new NewLineFormatter(counter));
        System.out.println("Extension 3a: " + counter.getCount());

        // Another way to do it:
        system.copy("private.txt", new NewLineFormatter(counter = new Counter(new InternetOutput("1.1.1.1"))));
        System.out.println("Extension 3b: " + counter.getCount());

        // ------------------------------------------------
        // Extension 4: Allow counting characters also before normalizing.
        // Changes: None.
        Counter after = new Counter((new InternetOutput("1.1.1.1")));
        Counter before = new Counter(new NewLineFormatter(after));
        system.copy("private.txt", before);
        System.out.println("Extension 4a: " + before.getCount() + " -> " + after.getCount());

        // Another way to do it:
        system.copy("private.txt",
                before = new Counter(
                        new NewLineFormatter(after = new Counter((new InternetOutput("1.1.1.1"))))));
        System.out.println("Extension 4b: " + before.getCount() + " -> " + after.getCount());

        // ------------------------------------------------
        // Extension 5: A file should be encrypted only once even if sent to more than one destination.
        // Changes: Add Distributor class.
        system.copy("private.txt",
                new Encryptor(new Duplicator(new InternetOutput("1.1.1.1"), new BluetoothOutput("iPhone"))));

    }
}
