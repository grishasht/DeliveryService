package model.entity;

import java.util.Date;
import java.util.Objects;

public class Account {
    private Integer id;
    private Integer applicationId;
    private Integer amount;
    private Date date;
    private Boolean isPaid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(applicationId, account.applicationId) &&
                Objects.equals(amount, account.amount) &&
                Objects.equals(date, account.date) &&
                Objects.equals(isPaid, account.isPaid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, applicationId, amount, date, isPaid);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", applicationId=" + applicationId +
                ", amount=" + amount +
                ", date=" + date +
                ", isPaid=" + isPaid +
                '}';
    }
}
