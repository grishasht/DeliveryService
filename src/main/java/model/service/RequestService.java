package model.service;

import model.dao.DaoFactory;
import model.dao.RequestDao;
import model.entity.Request;
import model.entity.User;
import model.util.Constants;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class RequestService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private RequestDao requestDao = daoFactory.createRequestDao();

    public void createRequest(HttpServletRequest request, User user){

        String street = (String) request.getSession().getAttribute(Constants.STREET_NAME);
        String house = (String) request.getSession().getAttribute(Constants.HOUSE_NUM);
        String luggage = (String) request.getSession().getAttribute(Constants.LUG_TYPE);
        String weight = (String) request.getSession().getAttribute(Constants.LUG_WEIGHT);
        Calendar calendar = Calendar.getInstance();
        java.util.Date sendDate = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        java.util.Date receiveDate = calendar.getTime();

        Request createdReq = new Request();
        createdReq.setWeight(Float.valueOf(weight));
        createdReq.setSendDate(new Date(sendDate.getTime()));
        createdReq.setReceiveDate(new Date(receiveDate.getTime()));
        createdReq.setAddressId(AddressService.getAddressId(street));
        createdReq.setHouseNum(Integer.valueOf(house));
        createdReq.setUserId(UserService.getUserId(user.getLogin()));
        createdReq.setLuggageId(LuggageService.getLuggageId(luggage));

        try {
            requestDao.create(createdReq);
        } catch (Exception e) {
            System.out.println("Error while insert into requests");
        }
    }

    public Boolean dataExistence(String country, String city, String street,
                                 String luggage, String weight){

        return country != null && city != null && street != null
                && luggage != null && weight != null;
    }

    public Boolean isNumeric(String house, String weight){
        try {
            if (house == null) return true;
            Integer.parseInt(house);
            Double.parseDouble(weight);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public List<Request> getUserRequests(Integer id){
        return requestDao.read(id);
    }
}
