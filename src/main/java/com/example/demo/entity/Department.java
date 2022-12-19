package com.example.demo.entity;

import com.example.demo.dto.DepartmentDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department_table")
public class Department{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "dept", cascade = CascadeType.ALL)
    private Set<Employee> employees;

    public DepartmentDTO toDTO(){
        DepartmentDTO deptDTO = new DepartmentDTO();
        deptDTO.setName(this.getName());
        deptDTO.setId(this.getId());
        return deptDTO;
    }
}
