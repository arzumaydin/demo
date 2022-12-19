package com.example.demo.dto;

import com.example.demo.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO{
    private int id;

    private String name;

    public Department toEntity(){
        Department dept = new Department();
        dept.setName(this.getName());
        return dept;
    }
}
