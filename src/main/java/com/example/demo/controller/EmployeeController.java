package com.example.demo.controller;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.service.interfaces.AbstractEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController{

    private final AbstractEmployeeService employeeService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<EmployeeDTO>> findAllEmployees() {

        return employeeService.findEmployees();
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDto) {
        return employeeService.addEmployee(employeeDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> findEmployee(@PathVariable("id")  int id) {
        return employeeService.findEmployee(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id")  int id, @RequestBody EmployeeDTO employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id)
    {
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/{id}/address")
    public ResponseEntity<ResponseDTO> getAddress(@PathVariable("id")  int id){

        return employeeService.getAddress(id);
    }

}
