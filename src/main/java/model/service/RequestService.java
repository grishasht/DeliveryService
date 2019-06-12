package model.service;

public class RequestService {

    public Boolean dataExistence(String country, String city, String street,
                                 String luggage, String weight){

        return country != null && city != null && street != null
                && luggage != null && weight != null;
    }

    public Boolean isNumeric(String house, String weight){
        try {
            Integer.parseInt(house);
            Double.parseDouble(weight);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
