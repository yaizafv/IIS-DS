package es.uniovi.ds.lab.validations;

import es.uniovi.ds.lab.form.Validator;

public class CheckText implements Validator {

    public boolean isValid(String text) {

        for (char ch : text.toCharArray())
            if (!Character.isLetter(ch))
                return false;

        return true;
    }
}
