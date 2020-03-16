package com.example.car_manager.repository;

import com.example.car_manager.models.Order;
import com.example.car_manager.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long>,
        JpaSpecificationExecutor<Product>, Serializable {
       Product findProductById(Long id);
        @Modifying
        @Query(value = "update t_product set oversum = :oversum where id = :id",nativeQuery = true)
        void updateOversumById(@Param("id") Long id, @Param("oversum") int oversum);
        }
