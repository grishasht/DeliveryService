package model.entity;

import java.util.Objects;

public class Luggage {
    private Integer id;
    private String type;
    private Float weight;
    private Float price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Luggage luggage = (Luggage) o;
        return Objects.equals(id, luggage.id) &&
                Objects.equals(type, luggage.type) &&
                Objects.equals(weight, luggage.weight) &&
                Objects.equals(price, luggage.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, weight, price);
    }

    @Override
    public String toString() {
        return "Luggage{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
