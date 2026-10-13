package es.uniovi.ds.lab.main;

import es.uniovi.ds.lab.form.*;
import es.uniovi.ds.lab.validations.*;
import es.uniovi.ds.lab.validations.composite.*;

/**
 * IMPORTANT: The code provided for this exercise is the minimum necessary to understand
 * the task and should NEVER be taken as an example of proper use of exceptions, assertions,
 * and tests. All of the above elements, which should be present in a real program, have been
 * intentionally omitted to simplify the exercise.
 */

public class Main {

    public static void main(String[] args) {

        Form form = new Form();

        form.addField(new Field("Name", new CheckText()));
        form.addField(new Field("Surname", new CheckText()));
        form.addField(new Field("Phone", new CheckNumber()));
        form.addField(new Field("City", new CheckPredefinedValues("Santander", "Valladolid", "Madrid")));

        // "Product Code". Length = 4
        form.addField(new Field("Product Code", new CheckLength(4)));

        form.addField(new Field("Product Code", text -> text.length() == 4));

        // "Postal Code". Digits and length = 5
        form.addField(new Field("Postal Code (a)",
                new CheckAll(new CheckNumber(), new CheckLength(5))));

        form.addField(new Field("Postal Code (b)",
                new CheckPostalCode()));

        // "Age". Digits and greater than 18
        form.addField(new Field("Age (a)",
                new CheckAll(new CheckNumber(), new CheckGreater(18))));

        form.addField(new Field("Age (b)",
                new CheckAll(new CheckNumber(), text -> Integer.parseInt(text) > 18)));

        // "Salary". Digits and greater than 800 and less than 1200
        form.addField(new Field("Salary",
                new CheckAll(new CheckNumber(), new CheckGreater(800), new CheckLess(1200))));

        // "Location". "Santander\Valladolid\Madrid" or Postal Code (see above)
        form.addField(new Field("Location",
                new CheckAny(
                        new CheckPredefinedValues("Santander", "Valladolid", "Madrid"),
                        new CheckPostalCode())));

        // "Promotion Code". Text (letters) or (digits and length 3)
        form.addField(new Field("Promotion Code",
                new CheckAny(
                        new CheckText(),
                        new CheckAll(new CheckNumber(), new CheckLength(3)))));

        form.requestInput();
    }
}
