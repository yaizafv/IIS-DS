package es.uniovi.ds.lab.v2.outputs.filters;

import java.io.IOException;

import es.uniovi.ds.lab.v2.files.Output;

public class Counter implements Output {

    private Output output;
    private int characterCounter;

    public Counter(Output output) {
        this.output = output;
    }

    public void send(char c) throws IOException {
        output.send(c);
        characterCounter++;
    }

    public int getCount() {
        return characterCounter;
    }

    public void close() throws IOException {
        output.close();
    }
}
