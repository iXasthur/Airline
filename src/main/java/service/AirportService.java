package service;

import dao.sql.AirportDAOSQL;
import dao.sql.CrewDAOSQL;
import entity.Airport;
import entity.Crew;

import java.util.List;

public class AirportService {
    public static List<Airport> getAll() {
        try {
            return new AirportDAOSQL().getAirports();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
