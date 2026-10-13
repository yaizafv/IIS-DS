package es.uniovi.ds.lab.validations.composite;

import java.util.*;

import es.uniovi.ds.lab.form.Validator;

public class CheckAny implements Validator {

    private List<Validator> validations;

    public CheckAny(Validator... validations) {
        this.validations = Arrays.asList(validations);
    }

    public boolean isValid(String text) {
        for (Validator validacion : validations)
            if (validacion.isValid(text))
                return true;
        return false;
    }
}
