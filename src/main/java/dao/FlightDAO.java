package dao;

import entity.Crew;
import entity.Flight;

import java.util.List;

public interface FlightDAO {
    List<Flight> getFlights() throws Exception;
    boolean addFlight(Flight flight) throws Exception;
}
