package entity;

import java.util.Date;

public class Flight {
    private int id;
    private Airport departure;
    private Airport arrival;
    private Crew crew;
    private Date date;
    private int seats;

    public Flight(int id, Airport departure, Airport arrival, Crew crew, Date date, int seats) {
        this.id = id;
        this.departure = departure;
        this.arrival = arrival;
        this.crew = crew;
        this.date = date;
        this.seats = seats;
    }
}
