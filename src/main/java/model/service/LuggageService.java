package model.service;

import model.dao.DaoFactory;
import model.dao.LuggageDao;
import model.entity.Luggage;

import java.util.List;
import java.util.stream.Collectors;

public class LuggageService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private LuggageDao luggageDao = daoFactory.createLuggageDao();
    private List<Luggage> luggage = luggageDao.readAll();

    public List<String> getLuggageType(){
        return luggage.stream()
                .map(Luggage::getType)
                .collect(Collectors.toList());
    }

    public Float getLuggagePrice(String luggageType){
        Float price = luggage.stream()
                .filter(luggage1 -> luggage1.getType().equals(luggageType))
                .findAny()
                .orElse(new Luggage())
                .getPrice();
        return price;
    }
}
