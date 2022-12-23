package com.example.demo.service.interfaces;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.EmployeeDTO;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface AbstractDepartmentService {

     ResponseEntity<DepartmentDTO> addDept(DepartmentDTO deptDto);
     ResponseEntity<String> deleteDept(int id);
     ResponseEntity<DepartmentDTO> findById(int id);
     ResponseEntity<?> updateDept(int id, DepartmentDTO deptChanges);
     ResponseEntity<Set<EmployeeDTO>> getEmployees(int id);
}
