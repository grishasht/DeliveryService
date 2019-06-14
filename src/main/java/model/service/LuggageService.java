package model.service;

import model.dao.DaoFactory;
import model.dao.LuggageDao;
import model.entity.Luggage;

import java.util.List;
import java.util.stream.Collectors;

public class LuggageService {
    private static DaoFactory daoFactory = DaoFactory.getInstance();
    private static LuggageDao luggageDao = daoFactory.createLuggageDao();
    private static List<Luggage> luggage = luggageDao.readAll();

    public List<String> getLuggageType() {
        return luggage.stream()
                .map(Luggage::getType)
                .collect(Collectors.toList());
    }

    public static Float getLuggagePrice(String luggageType) {
        Float price = luggage.stream()
                .filter(luggage1 -> luggage1.getType().equals(luggageType))
                .findAny()
                .orElse(new Luggage())
                .getPrice();
        return price;
    }

    public static Float getTotalPrice(Float price, String weight, Float distanceCoef) {
        try {
            return price * Float.valueOf(weight) * distanceCoef;
        } catch (NumberFormatException e){
            return 0f;
        }
    }

    public static Integer getLuggageId(String type) {
        return luggage.stream()
                .filter(luggage1 -> luggage1.getType().equals(type))
                .findAny()
                .get()
                .getId();
    }
}
