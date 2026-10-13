package es.uniovi.ds.lab.validations;

import es.uniovi.ds.lab.validations.composite.CheckAll;

public class CheckPostalCode extends CheckAll {

    public CheckPostalCode() {
        super(new CheckNumber(), new CheckLength(5));
    }
}
