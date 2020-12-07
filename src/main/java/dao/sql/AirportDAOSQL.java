package dao.sql;

import dao.AirportDAO;
import entity.Airport;
import entity.City;
import entity.Country;
import entity.Member;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirportDAOSQL implements AirportDAO {
    @Override
    public List<Airport> getAirports() throws Exception {
        Connection connection = DBConnection.connect();

        try {
            List<Airport> airports = new ArrayList<>();

            PreparedStatement query = connection.prepareStatement("SELECT * FROM airport");
            ResultSet result = query.executeQuery();
            while (result.next()) {
                int _id = result.getInt(1);
                String _name = result.getString(2);
                Country _country = new CountryDAOSQL().getCountryByID(result.getInt(3));
                City _city = new CityDAOSQL().getCityByID(result.getInt(4));
                airports.add(new Airport(_id, _name, _country, _city));
            }

            return airports;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Airport getAirportByID(int id) throws Exception {
        // Inefficient
        List<Airport> airports = getAirports();
        airports.removeIf(airport -> airport.id != id);
        return airports.get(0);
    }
}
