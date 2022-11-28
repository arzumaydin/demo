package com.example.demo.entity.interfaces;

import java.io.Serializable;

public interface AbstractDepartment extends Serializable {
    public int getID();
    public String getName();
    public void setName(String name);
}
