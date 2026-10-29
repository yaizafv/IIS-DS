package es.uniovi.ds.lab.form.adapters;

import es.uniovi.ds.lab.form.Editable;
import es.uniovi.ds.lab.model.Monument;

public class EditableMonument implements Editable {

    private Monument monument;

    public EditableMonument(Monument monument) {
        this.monument = monument;
    }

    @Override
    public String getElementType() {
        return "Monument";
    }

    @Override
    public String getFirstLabel() {
        return "Author";
    }

    @Override
    public String getFirstValue() {
        return monument.getAuthor();
    }

    @Override
    public void setFirstValue(String texto) {
        monument.setAuthor(texto);
    }

    @Override
    public String getSecondLabel() {
        return "Address";
    }

    @Override
    public String getSecondValue() {
        return monument.getAddress();
    }

    @Override
    public void setSecondValue(String texto) {
        monument.setAddress(texto);
    }

}
