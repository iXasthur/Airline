package entity;

public class Airport {
    private int id;
    private String name;
    private Country country;
    private City city;

    public Airport(int id, String name, Country country, City city) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
    }
}
