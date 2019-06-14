package model.entity;

import java.sql.Date;
import java.util.Objects;

public class Account {
    private Integer id;
    private Integer requestId;
    private Float amount;
    private Date date;
    private Boolean isPaid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
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
                Objects.equals(requestId, account.requestId) &&
                Objects.equals(amount, account.amount) &&
                Objects.equals(date, account.date) &&
                Objects.equals(isPaid, account.isPaid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, requestId, amount, date, isPaid);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", requestId=" + requestId +
                ", amount=" + amount +
                ", date=" + date +
                ", isPaid=" + isPaid +
                '}';
    }
}
