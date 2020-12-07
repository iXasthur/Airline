package dao;

import entity.Airport;
import entity.City;
import entity.Country;

import java.util.List;

public interface CountryDAO {
    List<Country> getCountries() throws Exception;
    Country getCountryByID(int id) throws Exception;
}
