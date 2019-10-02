package com.example.demo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Flight {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Size(min=2)
    private String airline;

    @NotNull
    @Size(min=3)
    private String start_loc;

    @NotNull
    @Size(min=3)
    private String end_loc;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date start_date;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date end_date;

    @NotNull
    private double price;

    public Flight() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getStart_loc() {
        return start_loc;
    }

    public void setStart_loc(String start_loc) {
        this.start_loc = start_loc;
    }

    public String getEnd_loc() {
        return end_loc;
    }

    public void setEnd_loc(String end_loc) {
        this.end_loc = end_loc;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
