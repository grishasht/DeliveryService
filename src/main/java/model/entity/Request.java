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
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", userId=" + userId +
                ", luggageId=" + luggageId +
                ", addressId=" + addressId +
                ", sendDate=" + sendDate +
                ", receiveDate=" + receiveDate +
                ", weight=" + weight +
                ", houseNum=" + houseNum +
                ", price=" + price +
                '}';
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
                Objects.equals(price, request.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, luggageId, addressId, sendDate, receiveDate, weight, houseNum, price);
    }

}
