package com.example.car_manager.compare;

import com.example.car_manager.models.Product;

import java.util.Comparator;

public class Sort implements Comparator {
    public int compare(Object arg0,Object arg1){
        Product user0 = (Product) arg0;
        Product user1 = (Product)arg1;
        int flag = user0.getDate().compareTo(user1.getDate());
        return flag;
    }
}
