package model.entity;

import java.util.Date;
import java.util.Objects;

public class Application {
    private Integer id;
    private Integer userId;
    private Integer luggageId;
    private Integer addressId;
    private Date sendDate;
    private Date receiveDate;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(luggageId, that.luggageId) &&
                Objects.equals(addressId, that.addressId) &&
                Objects.equals(sendDate, that.sendDate) &&
                Objects.equals(receiveDate, that.receiveDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, luggageId, addressId, sendDate, receiveDate);
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", userId=" + userId +
                ", luggageId=" + luggageId +
                ", addressId=" + addressId +
                ", sendDate=" + sendDate +
                ", receiveDate=" + receiveDate +
                '}';
    }
}
