package com.example.demo.repo;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface AbstractEmployeeRepo extends JpaRepository<Employee, Integer> {

    Optional<Employee> findById(int id);

    @Query("SELECT employee FROM Employee employee WHERE employee.dept.id = :deptId")
    Set<Employee> findByDept(@Param("deptId") int deptId);
}
