package com.example.demo.repo;

import com.example.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbstractDepartmentRepo extends JpaRepository<Department, Integer> {
    Department findById(int id);
}
