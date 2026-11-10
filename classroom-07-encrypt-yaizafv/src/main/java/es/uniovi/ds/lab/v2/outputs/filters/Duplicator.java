package es.uniovi.ds.lab.v2.outputs.filters;

import java.io.IOException;

import es.uniovi.ds.lab.v2.files.Output;

public class Duplicator implements Output {

    private Output output1, output2;

    public Duplicator(Output output1, Output output2) {
        this.output1 = output1;
        this.output2 = output2;
    }

    public void send(char c) throws IOException {
        output1.send(c);
        output2.send(c);
    }

    public void close() throws IOException {
        output1.close();
        output2.close();
    }
}

// What pattern is this?
// How could it be generalized?
