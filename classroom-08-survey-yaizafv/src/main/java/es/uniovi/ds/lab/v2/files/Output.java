package es.uniovi.ds.lab.v2.files;

import java.io.IOException;

public interface Output {
    void send(char c) throws IOException;

    void close() throws IOException;
}
