package com.example.demo.dto;

public class DepartmentDTO{
    private int id;

    private String name;
    public DepartmentDTO(){}

    public DepartmentDTO(int id, String name){
        super();
        this.id = id;
        this.name = name;
    }

    // getters and setters
    public int getID() { return id; }
    public void setID(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
