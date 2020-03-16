package com.example.car_manager.repository;

import com.example.car_manager.models.Product;
import com.example.car_manager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Transactional
public interface UserRepository extends JpaRepository<User, String>,
        JpaSpecificationExecutor<User>, Serializable {
User findUserById(String id);
}
