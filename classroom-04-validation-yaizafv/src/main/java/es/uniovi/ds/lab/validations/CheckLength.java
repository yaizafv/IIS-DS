package es.uniovi.ds.lab.validations;

import es.uniovi.ds.lab.form.Validator;

public class CheckLength implements Validator {

    private int length;

    public CheckLength(int length) {
        this.length = length;
    }

    public boolean isValid(String text) {
        return text.length() == length;
    }

}
