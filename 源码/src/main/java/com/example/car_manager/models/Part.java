package com.example.car_manager.models;

import javax.persistence.*;

@Entity
@Table(name= "t_part")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
@Column(name = "pname")
private String pname;
    @Column(name="pid")
    private String pid;
    @Column(name = "sum")
    private int sum;

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getPid() {
        return pid;
    }

    public int getSum() {
        return sum;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPname() {
        return pname;
    }
}
