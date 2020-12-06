package entity;

import java.util.ArrayList;

public class Country {
    private int id;
    private String name;
    private ArrayList<City> cities;

    public Country(int id, String name, ArrayList<City> cities) {
        this.id = id;
        this.name = name;
        this.cities = cities;
    }
}
