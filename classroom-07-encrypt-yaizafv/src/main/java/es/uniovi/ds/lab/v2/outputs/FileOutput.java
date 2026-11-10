package es.uniovi.ds.lab.v2.outputs;

import java.io.*;

import es.uniovi.ds.lab.v2.files.Output;

public class FileOutput implements Output {

    public FileOutput(String fileName) throws IOException {
        file = new FileWriter(fileName);
    }

    public void send(char c) throws IOException {
        file.append(c);
    }

    public void close() throws IOException {
        file.close();
    }

    private FileWriter file;
}
