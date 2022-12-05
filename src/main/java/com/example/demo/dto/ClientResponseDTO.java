package com.example.demo.dto;

import java.util.List;

public class ClientResponseDTO {

    private EmployeeDTO employee;
    private String status;
    private String code;
    private String total;
    private List<AddressDTO> data;

    ClientResponseDTO(){}

    ClientResponseDTO(EmployeeDTO employeeDTO, String status, String code, String total, List<AddressDTO> data){
        this.employee = employeeDTO;
        this.status = status;
        this.code = code;
        this.total = total;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<AddressDTO> getData() {
        return data;
    }

    public void setData(List<AddressDTO> data) {
        this.data = data;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }
}
