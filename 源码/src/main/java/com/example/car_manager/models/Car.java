package com.example.car_manager.models;

import javax.persistence.*;

@Entity
@Table(name= "t_car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="model")
    private String model;
    @Column(name = "sum")
    private int sum;


    public void setModel(String model) {
        this.model = model;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getModel() {
        return model;
    }

    public int getSum() {
        return sum;
    }
}
