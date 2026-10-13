package es.uniovi.ds.lab.validations;

import es.uniovi.ds.lab.form.Validator;

public class CheckLess implements Validator {

    private int limit;

    public CheckLess(int limit) {
        this.limit = limit;
    }

    public boolean isValid(String text) {
        return Integer.parseInt(text) < limit;
    }

}
