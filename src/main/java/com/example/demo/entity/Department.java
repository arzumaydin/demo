package com.example.demo.entity;

import com.example.demo.entity.interfaces.AbstractDepartment;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "department_table")
public class Department implements AbstractDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "dept", cascade = CascadeType.ALL)
    private Set<Employee> employees;

    //constructor
    public Department(){}

    public Department(String name){
        super();
        this.name = name;
    }

    // getters and setters
    public int getID() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
