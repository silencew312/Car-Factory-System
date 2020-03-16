package com.example.car_manager.repository;

import com.example.car_manager.models.Part_need;
import com.example.car_manager.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface Part_needRepository  extends JpaRepository<Part_need, Long>,
        JpaSpecificationExecutor<Part_need>, Serializable {

}
