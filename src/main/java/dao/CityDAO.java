package dao;

import entity.Airport;
import entity.City;

import java.util.List;

public interface CityDAO {
    City getCityByID(int id) throws Exception;
}
