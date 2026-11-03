package es.uniovi.ds.lab.v2.outputs.filters;

import java.io.IOException;

import es.uniovi.ds.lab.v2.files.Output;

public class SpaceRemover implements Output {

    private Output output;
    private char lastChar = 0;

    public SpaceRemover(Output output) {
        this.output = output;
    }

    public void send(char c) throws IOException {
        if (c == ' ' && lastChar == ' ')
            return;

        output.send(c);
        lastChar = c;
    }

    public void close() throws IOException {
        output.close();
    }
}
