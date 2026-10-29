package es.uniovi.ds.lab.form.adapters;

import es.uniovi.ds.lab.form.Editable;
import es.uniovi.ds.lab.model.Restaurant;

public class EditableRestaurant implements Editable {

    private Restaurant restaurant;

    public EditableRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String getElementType() {
        return "Restaurant";
    }

    @Override
    public String getFirstLabel() {
        return "Name";
    }

    @Override
    public String getFirstValue() {
        return restaurant.getName();
    }

    @Override
    public void setFirstValue(String texto) {
        restaurant.setName(texto);
    }

    @Override
    public String getSecondLabel() {
        return "Address";
    }

    @Override
    public String getSecondValue() {
        return restaurant.getAddress();
    }

    @Override
    public void setSecondValue(String texto) {
        restaurant.setAddress(texto);
    }

}
