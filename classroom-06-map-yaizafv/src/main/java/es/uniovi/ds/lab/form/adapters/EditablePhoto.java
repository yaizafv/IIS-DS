package es.uniovi.ds.lab.form.adapters;

import es.uniovi.ds.lab.form.Editable;
import es.uniovi.ds.lab.model.Photo;

public class EditablePhoto implements Editable {

    private Photo photo;

    public EditablePhoto(Photo photo) {
        this.photo = photo;
    }

    @Override
    public String getElementType() {
        return "Photo";
    }

    @Override
    public String getFirstLabel() {
        return "User name";
    }

    @Override
    public String getFirstValue() {
        return photo.getUserName();
    }

    @Override
    public void setFirstValue(String texto) {
        photo.setUserName(texto);
    }

    @Override
    public String getSecondLabel() {
        return "Description";
    }

    @Override
    public String getSecondValue() {
        return photo.getDescription();
    }

    @Override
    public void setSecondValue(String texto) {
        photo.setDescription(texto);
    }

}
