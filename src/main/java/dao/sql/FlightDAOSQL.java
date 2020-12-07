package dao.sql;

import dao.FlightDAO;
import entity.Airport;
import entity.Crew;
import entity.Flight;
import service.AirportService;
import service.CrewService;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightDAOSQL implements FlightDAO {
    @Override
    public List<Flight> getFlights() throws Exception {
        Connection connection = DBConnection.connect();

        try {
            List<Flight> flights = new ArrayList<>();

            PreparedStatement query = connection.prepareStatement("SELECT * FROM flight");
            ResultSet result = query.executeQuery();
            while (result.next()) {
                int _id = result.getInt(1);
                Airport _departure = AirportService.byID(Integer.parseInt(result.getString(2)));
                Airport _arrival = AirportService.byID(Integer.parseInt(result.getString(3)));
                Crew _crew = CrewService.byID(Integer.parseInt(result.getString(4)));
                LocalDateTime _date = LocalDateTime.parse(result.getString(5));
                int _seats = Integer.parseInt(result.getString(6));
                flights.add(new Flight(_id, _departure, _arrival, _crew, _date, _seats));
            }

            return flights;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean addFlight(Flight flight) throws Exception {
        Connection connection = DBConnection.connect();

        try {
            PreparedStatement addUserQuery = connection.prepareStatement("INSERT INTO flight (departure_airport_id, arrival_airport_id, crew_id, date, seats) VALUES (?, ?, ?, ?, ?)");
            addUserQuery.setInt(1, flight.departure.id);
            addUserQuery.setInt(2, flight.arrival.id);
            addUserQuery.setInt(3, flight.crew.id);
            addUserQuery.setString(4, flight.date.toString());
            addUserQuery.setInt(5, flight.seats);
            addUserQuery.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
