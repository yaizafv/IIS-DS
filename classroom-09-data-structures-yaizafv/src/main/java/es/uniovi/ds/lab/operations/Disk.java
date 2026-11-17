package es.uniovi.ds.lab.operations;

import java.io.*;
import java.util.Scanner;

import es.uniovi.ds.lab.structures.*;

public class Disk {

    public static void save(String fileName, MyIterator iterator) {

        System.out.println("------------------------------------------------");
        System.out.println("Creating file '" + fileName + "'");

        String line;
        while ((line = iterator.next()) != null)
            System.out.println(line);

        System.out.println("[Closing file]");
    }

    public static MyVector loadFile(String fileName) throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileReader(fileName));

        MyVector vector = new MyVector();
        while (scanner.hasNextLine())
            vector.add(scanner.nextLine());

        scanner.close();
        return vector;
    }

    public static MyIterator fileIterator(String fileName) throws FileNotFoundException {
        return new FileIterator(new FileReader(fileName));
    }
}

final class FileIterator implements MyIterator {

    private final Scanner scanner;

    FileIterator(Reader reader) {
        this.scanner = new Scanner(reader);
    }

    @Override
    public String next() {
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        } else {
            scanner.close();
            return null;
        }
    }
}
