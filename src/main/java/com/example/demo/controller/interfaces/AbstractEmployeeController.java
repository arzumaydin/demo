package com.example.demo.controller.interfaces;

import com.example.demo.dto.EmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AbstractEmployeeController {
    public ResponseEntity<List<EmployeeDTO>> findAllEmployees();
    public ResponseEntity<EmployeeDTO> addEmployee(EmployeeDTO employeeDto);
    public ResponseEntity<EmployeeDTO> findEmployee(@PathVariable("id")  int id);
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id")  int id, EmployeeDTO employeeDto);
    public ResponseEntity<String> deleteEmployee(int id);
}
