package com.example.demo.service.interfaces;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AbstractEmployeeService {
    ResponseEntity<List<EmployeeDTO>> findEmployees();
    ResponseEntity<EmployeeDTO> addEmployee(EmployeeDTO employee);
    ResponseEntity<EmployeeDTO> findEmployee(int id);

    ResponseEntity<EmployeeDTO> updateEmployee(int id, EmployeeDTO employee);
    ResponseEntity<String> deleteEmployee(int id);

    ResponseEntity<ResponseDTO> getAddress(int id);
}
