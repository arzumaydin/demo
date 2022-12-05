package com.example.demo.dto;

import java.util.List;

public class ResponseDTO {

    private EmployeeDTO employee;
    private AddressDTO address;

    public ResponseDTO(){}

    public ResponseDTO(EmployeeDTO employeeDTO, List<AddressDTO> data){
        this.employee = employeeDTO;
        this.address = data.get(0);
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO data) {
        this.address = data;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }
}
