package com.example.car_manager.repository;

import com.example.car_manager.models.Car;
import com.example.car_manager.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
@Transactional
public interface CarRepository extends JpaRepository<Car, String>,
        JpaSpecificationExecutor<Car>, Serializable {
    Car findCarByModel(String model);
    @Modifying
    @Query(value = "update t_car set sum = :sum where model = :model",nativeQuery = true)
    void updateSumByModel(@Param("model") String model, @Param("sum") int sum);


}