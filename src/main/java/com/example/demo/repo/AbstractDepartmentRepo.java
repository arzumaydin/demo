package com.example.demo.repo;

import com.example.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AbstractDepartmentRepo extends JpaRepository<Department, Integer> {

    Optional<Department> findById(int id);
    Optional<Department> findByName(String name);
}
