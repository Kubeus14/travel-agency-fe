package com.kodilla.travelagencyfrontend.domain;

import java.util.Objects;

public class Travel {

    private String travelId;
    private String name;
    private TravelType type;
    private String description;
    private String startDate;
    private String endDate;
    private String price;

    public Travel() {
    }

    public Travel(String travelId,String name, TravelType type, String description, String startDate, String endDate, String price) {
        this.travelId=travelId;
        this.name = name;
        this.type = type;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public String getTravelId() {
        return travelId;
    }

    public String getName() {
        return name;
    }

    public TravelType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Travel travel = (Travel) o;
        if (!startDate.equals(travel.startDate)) return false;
        if (!endDate.equals(travel.endDate)) return false;
        if (!Objects.equals(name, travel.name)) return false;
        if (!Objects.equals(description, travel.description)) return false;
        if (!Objects.equals(price, travel.price)) return false;
        return Objects.equals(type, travel.type);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    public void setTravelId(String travelId) {
        this.travelId = travelId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(TravelType type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
