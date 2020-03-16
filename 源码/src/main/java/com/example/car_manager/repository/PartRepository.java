package com.example.car_manager.repository;

import com.example.car_manager.models.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
@Transactional
public interface PartRepository extends JpaRepository<Part, String>,
        JpaSpecificationExecutor<Part>, Serializable {
        Part findPartByPid(String pid);
@Modifying
@Query(value = "update t_part set sum = :sum where pid = :pid",nativeQuery = true)
    void updateSumByPid(@Param("pid") String pid, @Param("sum") int sum);


}
