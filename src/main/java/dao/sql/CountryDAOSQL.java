package dao.sql;

import dao.CountryDAO;
import entity.Airport;
import entity.Country;
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

public class CountryDAOSQL implements CountryDAO {
    @Override
    public List<Country> getCountries() throws Exception {
        Connection connection = DBConnection.connect();

        try {
            List<Country> countries = new ArrayList<>();

            PreparedStatement query = connection.prepareStatement("SELECT * FROM country");
            ResultSet result = query.executeQuery();
            while (result.next()) {
                int _id = result.getInt(1);
                String _name = result.getString(2);
                countries.add(new Country(_id, _name));
            }

            return countries;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Country getCountryByID(int id) throws Exception {
        List<Country> countries = getCountries();
        countries.removeIf(country -> country.id != id);
        return countries.get(0);
    }
}
