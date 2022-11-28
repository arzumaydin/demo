package com.example.demo.entity;

import com.example.demo.entity.interfaces.AbstractEmployee;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee_table")
public class Employee implements AbstractEmployee {
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

    //constructor
    public Employee(){}

    public Employee(String name, String surname, Date date, Department dept) {
        super();
        this.name = name;
        this.surname = surname;
        this.bdate = date;
        this.dept = dept;
    }

    // getters and setters

    public int getID()
    {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }

    public Date getDate() {
        return bdate;
    }
    public Department getDept() {
        return dept;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setDate(Date bdate) {
        this.bdate = bdate;
    }
    public void setDept(Department dept) {
        this.dept = dept;
    }
}
