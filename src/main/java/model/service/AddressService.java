package model.service;

import model.dao.AddressDao;
import model.dao.DaoFactory;
import model.entity.Address;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddressService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private AddressDao addressDao = daoFactory.createAddressDao();
    private List<Address> addresses = addressDao.readAll();


    public Set<String> getCountries() {
        Set<String> countries = new HashSet<>();
        addresses.stream()
                .forEach((address) -> countries.add(address.getCountry()));
        return countries;
    }

    public Set<String> getCities(String country) {
        Set<String> cities = new HashSet<>();
        addresses.stream()
                .forEach((address) -> {
                    if (address.getCountry().equals(country))
                        cities.add(address.getCity());
                });
        return cities;
    }

    public Set<String> getStreets(String city) {
        Set<String> streets = new HashSet<>();
        addresses.stream()
                .forEach((address) -> {
                    if (address.getCity().equals(city))
                    streets.add(address.getStreet());
                });
        return streets;
    }

    public Float getCoefficient(String street){
        return addresses.stream()
                .filter(address -> address.getStreet().equals(street))
                .findAny()
                .get()
                .getCoefficient();
    }

}
