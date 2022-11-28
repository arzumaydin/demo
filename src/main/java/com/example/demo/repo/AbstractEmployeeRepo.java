package com.example.demo.repo;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AbstractEmployeeRepo extends JpaRepository<Employee, Integer> {

    Employee findById(int id);
    @Query("SELECT s FROM Employee s WHERE s.dept.id = :deptId")
    Set<Employee> findByDept(@Param("deptId") int deptId);
}
