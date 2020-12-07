package dao;

import entity.Airport;
import entity.City;

import java.util.List;

public interface CityDAO {
    List<City> getCities() throws Exception;
    City getCityByID(int id) throws Exception;
}
