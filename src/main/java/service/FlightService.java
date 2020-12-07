package service;

import dao.sql.AirportDAOSQL;
import dao.sql.FlightDAOSQL;
import entity.Airport;
import entity.Flight;

import java.util.List;

public class FlightService {
    public static List<Flight> getAll() {
        try {
            return new FlightDAOSQL().getFlights();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
