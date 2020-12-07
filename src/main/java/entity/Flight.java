package entity;

import java.time.LocalDateTime;
import java.util.Date;

public class Flight {
    public final int id;
    public final Airport departure;
    public final Airport arrival;
    public final Crew crew;
    public final LocalDateTime date;
    public final int seats;

    public Flight(int id, Airport departure, Airport arrival, Crew crew, LocalDateTime date, int seats) {
        this.id = id;
        this.departure = departure;
        this.arrival = arrival;
        this.crew = crew;
        this.date = date;
        this.seats = seats;
    }
}
