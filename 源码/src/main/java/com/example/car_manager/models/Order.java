package com.example.car_manager.models;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name= "t_order")
public class Order {
    @Id

    @Column(name="id")
   private   Long id;
    @Column(name="name")
   private String c_name;
    @Column(name="phone")
   private String c_phone;
    @Column(name="adr")
   private String c_adr;
    @Column(name="model")
    private String car_model;
    @Column(name="sum")
    private int car_sum;
    @Column(name="date")
    private Date date;
    @Column(name="oversum")
    private int oversum;

    public void setId(Long id) {
        this.id = id;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public void setC_phone(String c_phone) {
        this.c_phone = c_phone;
    }

    public void setC_adr(String c_adr) {
        this.c_adr = c_adr;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public void setCar_sum(int car_sum) {
        this.car_sum = car_sum;
    }





    public Long getId() {
        return id;
    }


    public int getCar_sum() {
        return car_sum;
    }



    public String getC_adr() {
        return c_adr;
    }

    public String getC_name() {
        return c_name;
    }

    public String getC_phone() {
        return c_phone;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setOversum(int oversum) {
        this.oversum = oversum;
    }

    public int getOversum() {
        return oversum;
    }
}
