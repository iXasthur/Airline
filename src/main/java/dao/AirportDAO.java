package dao;

import entity.Airport;
import entity.Crew;

import java.util.List;

public interface AirportDAO {
    List<Airport> getAirports() throws Exception;
    Airport getAirportByID(int id) throws Exception;
}
