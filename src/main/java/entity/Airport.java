package entity;

public class Airport {
    public final int id;
    public final String name;
    public final Country country;
    public final City city;

    public Airport(int id, String name, Country country, City city) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
    }
}
