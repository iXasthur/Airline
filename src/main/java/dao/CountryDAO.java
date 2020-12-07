package dao;

import entity.Airport;
import entity.Country;

import java.util.List;

public interface CountryDAO {
    Country getCountryByID(int id) throws Exception;
}
