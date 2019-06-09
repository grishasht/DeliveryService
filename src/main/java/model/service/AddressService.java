package model.service;

import model.dao.AddressDao;
import model.dao.DaoFactory;
import model.entity.Address;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AddressService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private AddressDao addressDao = daoFactory.createAddressDao();
    private List<Address> addresses = addressDao.readAll();


    public Set<String> getCountries(){
        Set<String> countries = new HashSet<>();
        addresses.stream()
                .forEach((address)->countries.add(address.getCountry()));
        return countries;
    }

    public Set<String> getCities(){
        Set<String> cities = new HashSet<>();
        addresses.stream()
                .forEach((address)->cities.add(address.getCity()));
        return cities;
    }

    public Set<String> getStreets(){
        Set<String> streets = new HashSet<>();
        addresses.stream()
                .forEach((address)->streets.add(address.getStreet()));
        return streets;
    }

}
