package com.example.car_manager.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name= "t_product")
public class Product {
    @Id

    @Column(name="id")
    private Long id;
    @Column(name="model")
    private String model;
    @Column(name="sum")
    private int sum;
    @Column(name="oversum")
    private int oversum;
    @Column(name="date")
    public Date date;
    public void setOversum(int oversum) {
        this.oversum = oversum;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getOversum() {
        return oversum;
    }

    public Long getId() {
        return id;
    }

    public int getSum() {
        return sum;
    }

    public String getModel() {
        return model;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
