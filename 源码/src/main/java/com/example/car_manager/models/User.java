package com.example.car_manager.models;

import javax.persistence.*;

@Entity
@Table(name= "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="fid")
    private   int fid;
    @Column(name = "id")
    private String id;
    @Column(name = "password")
  private String password;
    @Column(name = "role")
    private int role;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getRole() {
        return role;
    }
}
