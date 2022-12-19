package com.example.demo.dto;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.util.utilities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO{

    private int id;
    private String name;
    private String surname;
    private String bdate;
    private String deptid;

    public Employee toEntity(Department department){
        Employee employee = new Employee();
        employee.setName(this.getName());
        employee.setSurname(this.getSurname());
        Date date = utilities.stringToDate(this.getBdate());
        employee.setBdate(date);
        employee.setDept(department);
        return employee;
    }
}
