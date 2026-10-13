package es.uniovi.ds.lab.main;

import es.uniovi.ds.lab.form.*;
import es.uniovi.ds.lab.validations.*;

/**
 * IMPORTANT: The code provided for this exercise is the minimum necessary to understand
 * the task and should NEVER be taken as an example of proper use of exceptions, assertions,
 * and tests. All of the above elements, which should be present in a real program, have been
 * intentionally omitted to simplify the exercise.
 */

public class InitialMain {

    public static void main(String[] args) {

        Form form = new Form();

        form.addField(new Field("Name", new CheckText()));
        form.addField(new Field("Surname", new CheckText()));
        form.addField(new Field("Phone", new CheckNumber()));
        form.addField(new Field("City", new CheckPredefinedValues("Santander", "Valladolid", "Madrid")));

        form.requestInput();
    }
}
