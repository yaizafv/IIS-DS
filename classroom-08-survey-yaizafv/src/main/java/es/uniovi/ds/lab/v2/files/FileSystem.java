package es.uniovi.ds.lab.v2.files;

import java.io.*;

public class FileSystem {

    public void copy(String name, Output output) {

        try (FileReader reader = new FileReader(name)) {

            int c;
            while ((c = reader.read()) != -1)
                output.send((char) c);

            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
