package com.example.demo.dto;

import java.util.Date;

public class EmployeeDTO{

    private int id;
    private String name;
    private String surname;
    private String bdate;
    private String deptid;


    public EmployeeDTO(){}

    public EmployeeDTO(int id, String name, String surname, String date, String deptId) {
        super();
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.bdate = date;
        this.deptid = deptId;
    }

    public int getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getBdate(){
        return bdate;
    }
    public int getDeptid(){
        return Integer.parseInt(deptid);
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setBdate(String date){
        this.bdate = date;
    }
    public void setDeptid(String deptid){
        this.deptid = deptid;
    }

}
