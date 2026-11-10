package es.uniovi.ds.lab.v1.files;

import java.io.*;

public class FileSystem {

    public void copyFile(String name, String newName) throws IOException {
        try (FileWriter writer = new FileWriter(newName);
                FileReader reader = new FileReader(name)) {

            int c;
            while ((c = reader.read()) != -1)
                writer.append((char) c);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendToInternet(String name, String url) {
        try {
            StringWriter stringWriter = new StringWriter();
            stringWriter.append("\n--- START. Connecting to the Internet[" + url + "]\n");

            try (FileReader reader = new FileReader(name)) {
                int c;
                while ((c = reader.read()) != -1)
                    stringWriter.append((char) c);
            }

            System.out.print(stringWriter.toString());
            System.out.println("--- END. Closing Internet connection");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendWithBluetooth(String name, String device) {
        try {
            StringWriter stringWriter = new StringWriter();
            stringWriter.append("\n--- START. Connecting with Bluetooth[" + device + "]\n");

            try (FileReader reader = new FileReader(name)) {
                int c;
                while ((c = reader.read()) != -1)
                    stringWriter.append((char) c);
            }

            System.out.print(stringWriter.toString());
            System.out.println("--- END. Closing Bluetooth connection");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
