package com.example.demo.controller.interfaces;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.entity.Department;
import org.springframework.http.ResponseEntity;

public interface AbstractDepartmentController {
    public ResponseEntity<DepartmentDTO> addDept(DepartmentDTO deptDto);
    public ResponseEntity<String> deleteDept(int id);
    public ResponseEntity<DepartmentDTO> findDeptById(int id);

    public Department updateDept(int id, DepartmentDTO deptDTO);
}
