package com.example.demo.entity;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.util.utilities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_table")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "date_of_birth", nullable = false)
    private Date bdate;

    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Department dept;

    public EmployeeDTO toDTO(){
        EmployeeDTO employeeDto = new EmployeeDTO();
        employeeDto.setId(this.getId());
        employeeDto.setName(this.getName());
        employeeDto.setSurname(this.getSurname());
        String date = utilities.dateToString(this.getBdate());
        employeeDto.setBdate(date);
        employeeDto.setDeptid(Integer.toString(this.getDept().getId()));
        return employeeDto;
    }
}
