package es.uniovi.ds.lab.form;

import java.io.*;

public class Field {

    private String label;
    private Validator validator;
    private String value;

    public Field(String label, Validator validator) {
        this.label = label;
        this.validator = validator;
    }

    public void requestInput() {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        do {
            try {
                System.out.print(label + ": ");
                value = console.readLine();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        } while (!validator.isValid(value));
    }

    public String getValue() {
        return value;
    }

}
