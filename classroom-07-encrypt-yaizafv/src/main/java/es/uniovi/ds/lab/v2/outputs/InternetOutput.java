package es.uniovi.ds.lab.v2.outputs;

import java.io.*;

import es.uniovi.ds.lab.v2.files.Output;

public class InternetOutput implements Output {

    public InternetOutput(String url) {
        stringWriter = new StringWriter();
        stringWriter.append("\n--- START. Connecting to the Internet[" + url + "]\n");
    }

    public void send(char c) throws IOException {
        stringWriter.append(c);
    }

    public void close() throws IOException {
        System.out.print(stringWriter.toString());
        System.out.println("--- END. Closing Internet connection");
    }

    private StringWriter stringWriter = new StringWriter();
}
