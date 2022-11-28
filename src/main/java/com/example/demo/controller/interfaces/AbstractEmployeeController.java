package com.example.demo.controller.interfaces;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AbstractEmployeeController {
    public List<EmployeeDTO> findAllEmployees();
    public Employee addEmployee(EmployeeDTO employeeDto);
    public EmployeeDTO findEmployee(@PathVariable("id")  int id);
    public void updateEmployee(@PathVariable("id")  int id, EmployeeDTO employeeDto);
    public void deleteEmployee(int id);
}
