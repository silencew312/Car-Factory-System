package com.example.car_manager.repository;

import com.example.car_manager.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
public interface OrderRepository extends JpaRepository<Order, Long>,
JpaSpecificationExecutor<Order>,Serializable{
    Order findOrderById(Long id);
    @Modifying
    @Query(value = "update t_order set name = :name where id = :id",nativeQuery = true)
    void updateNameById(@Param("id") Long id, @Param("name") String name);
    @Modifying
    @Query(value = "update t_order set phone = :phone where id = :id",nativeQuery = true)
    void updatePhoneById(@Param("id") Long id, @Param("phone") String phone);
    @Modifying
    @Query(value = "update t_order set adr = :adr where id = :id",nativeQuery = true)
    void updateAdrById(@Param("id") Long id, @Param("adr") String adr);
    @Modifying
    @Query(value = "update t_order set oversum = :oversum where id = :id",nativeQuery = true)
    void updateOversumById(@Param("id") Long id, @Param("oversum") int oversum);

}