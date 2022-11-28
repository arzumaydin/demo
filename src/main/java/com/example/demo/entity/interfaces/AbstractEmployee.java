package com.example.demo.entity.interfaces;

import com.example.demo.entity.Department;

import java.io.Serializable;
import java.util.Date;

public interface AbstractEmployee extends Serializable {
    public int getID();
    public String getName();
    public String getSurname();
    public Department getDept();
    public Date getDate();

    public void setName(String name);
    public void setSurname(String surname);
    public void setDept(Department dept);
    public void setDate(Date date);
}
