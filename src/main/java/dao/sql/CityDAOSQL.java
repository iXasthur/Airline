package dao.sql;

import dao.CityDAO;
import entity.City;
import entity.Country;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAOSQL implements CityDAO {
    @Override
    public List<City> getCities() throws Exception {
        Connection connection = DBConnection.connect();

        try {
            List<City> cities = new ArrayList<>();

            PreparedStatement query = connection.prepareStatement("SELECT * FROM city");
            ResultSet result = query.executeQuery();
            while (result.next()) {
                int _id = result.getInt(1);
                String _name = result.getString(2);
                cities.add(new City(_id, _name));
            }

            return cities;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public City getCityByID(int id) throws Exception {
        List<City> cities = getCities();
        cities.removeIf(city -> city.id != id);
        return cities.get(0);
    }
}
