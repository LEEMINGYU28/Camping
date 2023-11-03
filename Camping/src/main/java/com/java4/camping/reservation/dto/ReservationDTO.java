package com.java4.camping.reservation.dto;

public class ReservationDTO {
    private Long id;
    private String date;
    private String campground;
    private String availability;
    private int price;


    public ReservationDTO() {
       
    }

    public ReservationDTO(Long id, String date, String campground, String availability, int price) {
        this.id = id;
        this.date = date;
        this.campground = campground;
        this.availability = availability;
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCampground() {
        return campground;
    }

    public void setCampground(String campground) {
        this.campground = campground;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
