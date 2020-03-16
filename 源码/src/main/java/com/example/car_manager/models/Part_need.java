package com.example.car_manager.models;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name= "t_part_need")
public class Part_need {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name="pid")
    private String pid;
    @Column(name="sum")
    private int sum;
    @Column(name="date")
    private Date date;

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Date getDate() {
        return date;
    }

    public int getSum() {
        return sum;
    }

    public String getPid() {
        return pid;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
