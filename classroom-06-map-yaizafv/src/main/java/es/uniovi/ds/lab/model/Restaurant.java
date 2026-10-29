package es.uniovi.ds.lab.model;

public class Restaurant {

    private String name;
    private String address;
    private String contactNumber;

    public Restaurant(String name, String address, String contactNumber) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    // Dials the restaurant's phone number to make a reservation
    public void callRestaurant() {
        System.out.println("Calling " + contactNumber);
    }
}
