package com.example.car_manager.compare;

import com.example.car_manager.models.Part_need;
import com.example.car_manager.models.Product;

import java.util.Comparator;

public class Sort2 implements Comparator {
    public int compare(Object arg0,Object arg1){
        Part_need user0 = (Part_need) arg0;
        Part_need user1 = (Part_need) arg1;
        int flag = user0.getDate().compareTo(user1.getDate());
        return flag;
    }
}
