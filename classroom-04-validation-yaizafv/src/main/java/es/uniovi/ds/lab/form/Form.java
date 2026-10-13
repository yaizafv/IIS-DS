package es.uniovi.ds.lab.form;

import java.util.*;

public class Form {

    private List<Field> fields = new ArrayList<>();

    public void addField(Field field) {
        fields.add(field);
    }

    public void requestInput() {
        for (Field field : fields) {
            field.requestInput();
            System.out.println(field.getValue());
        }
    }

}
