package com.example.demo.service.interfaces;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;

import java.util.List;

public interface AbstractEmployeeService {
    public List<EmployeeDTO> findEmployees();
    public Employee addEmployee(EmployeeDTO employee);
    public EmployeeDTO findEmployee(int id);

    public Employee updateEmployee(int id, EmployeeDTO employee);
    public void deleteEmployee(int id);
    public Employee toEntity(EmployeeDTO employeeDto);
    public EmployeeDTO toDTO(Employee employee);
}
