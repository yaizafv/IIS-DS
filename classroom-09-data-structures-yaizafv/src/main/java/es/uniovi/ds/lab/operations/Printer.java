package es.uniovi.ds.lab.operations;

import es.uniovi.ds.lab.structures.MyIterator;

public class Printer {
    public static void sendToPrinter(MyIterator iterator) {

        System.out.println("------------------------------------------------");
        System.out.println("Loading sheet...");

        String line;
        while ((line = iterator.next()) != null)
            System.out.println("Printing line: " + line);

        System.out.println("Ejecting page");
    }
}
