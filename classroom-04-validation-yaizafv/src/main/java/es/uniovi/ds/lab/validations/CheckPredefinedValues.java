package es.uniovi.ds.lab.validations;

import es.uniovi.ds.lab.form.Validator;

public class CheckPredefinedValues implements Validator {

    private String[] values;

    public CheckPredefinedValues(String... values) {
        this.values = values;
    }

    public boolean isValid(String text) {

        for (String value : values)
            if (text.equalsIgnoreCase(value))
                return true;

        return false;
    }

}
