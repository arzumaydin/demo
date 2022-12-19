package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseDTO {

    private EmployeeDTO employee;
    private AddressDTO address;

    public ResponseDTO(EmployeeDTO employeeDTO, List<AddressDTO> data){
        this.employee = employeeDTO;
        this.address = data.get(0);
    }
}
