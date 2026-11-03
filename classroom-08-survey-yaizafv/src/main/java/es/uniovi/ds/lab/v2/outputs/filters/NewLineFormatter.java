package es.uniovi.ds.lab.v2.outputs.filters;

import java.io.IOException;

import es.uniovi.ds.lab.v2.files.Output;

public class NewLineFormatter implements Output {

    private Output output;

    public NewLineFormatter(Output output) {
        this.output = output;
    }

    public void send(char c) throws IOException {
        if (c != '\r')
            output.send(c);
    }

    public void close() throws IOException {
        output.close();
    }
}
