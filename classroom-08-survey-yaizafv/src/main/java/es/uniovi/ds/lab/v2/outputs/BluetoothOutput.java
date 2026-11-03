package es.uniovi.ds.lab.v2.outputs;

import java.io.*;

import es.uniovi.ds.lab.v2.files.Output;

public class BluetoothOutput implements Output {

    public BluetoothOutput(String device) {
        stringWriter = new StringWriter();
        stringWriter.append("\n--- START. Connecting with Bluetooth[" + device + "]\n");
    }

    public void send(char c) throws IOException {
        stringWriter.append(c);
    }

    public void close() throws IOException {
        System.out.print(stringWriter.toString());
        System.out.println("--- END. Closing Bluetooth connection");
    }

    private StringWriter stringWriter;
}
