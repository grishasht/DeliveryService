package model.entity;

import java.sql.Date;
import java.util.Objects;

public class Request {
    private Integer id;
    private Integer userId;
    private Integer luggageId;
    private Integer addressId;
    private Date sendDate;
    private Date receiveDate;
    private Float weight;
    private Integer houseNum;
    private Float price;
    private String country;
    private String city;
    private String street;
    private Float totalPrice;
    private String luggage;

    public String getLuggage() {
        return luggage;
    }

    public void setLuggage(String luggage) {
        this.luggage = luggage;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLuggageId() {
        return luggageId;
    }

    public void setLuggageId(Integer luggageId) {
        this.luggageId = luggageId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(Integer houseNum) {
        this.houseNum = houseNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(id, request.id) &&
                Objects.equals(userId, request.userId) &&
                Objects.equals(luggageId, request.luggageId) &&
                Objects.equals(addressId, request.addressId) &&
                Objects.equals(sendDate, request.sendDate) &&
                Objects.equals(receiveDate, request.receiveDate) &&
                Objects.equals(weight, request.weight) &&
                Objects.equals(houseNum, request.houseNum) &&
                Objects.equals(price, request.price) &&
                Objects.equals(country, request.country) &&
                Objects.equals(city, request.city) &&
                Objects.equals(street, request.street) &&
                Objects.equals(totalPrice, request.totalPrice) &&
                Objects.equals(luggage, request.luggage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, luggageId, addressId, sendDate, receiveDate, weight, houseNum, price, country, city, street, totalPrice, luggage);
    }
}
