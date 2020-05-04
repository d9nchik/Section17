package com.d9nich.exercise9;

public class ContactOfPerson {
    private final String name;
    private final String street;
    private final String city;
    private final String state;
    private final String zip;

    public ContactOfPerson(String name, String street, String city, String state, String zip) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public ContactOfPerson() {
        this("", "", "", "", "");
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }
}
