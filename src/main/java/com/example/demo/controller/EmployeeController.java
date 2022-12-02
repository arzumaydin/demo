package com.example.demo.controller;

import com.example.demo.controller.interfaces.AbstractEmployeeController;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController implements AbstractEmployeeController {


    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }


    // get all employees - get mapping
    @GetMapping(value = "/all")
    public ResponseEntity<List<EmployeeDTO>> findAllEmployees() {

        List<EmployeeDTO> employees = employeeService.findEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // create employee - post mapping
    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDto) {
        Employee employee = employeeService.addEmployee(employeeDto);
        EmployeeDTO responseDto = employeeService.toDTO(employee);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    // get employee by id - get mapping
    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> findEmployee(@PathVariable("id")  int id) {
        EmployeeDTO employeeDTO = employeeService.findEmployee(id);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    // update employee - put mapping
    @PutMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id")  int id, @RequestBody EmployeeDTO employee) {
        Employee changedEmployee = employeeService.updateEmployee(id, employee);
        EmployeeDTO employeeDTO = employeeService.toDTO(changedEmployee);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    // delete employee - delete mapping
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id)
    {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok( String.format("Employee %d deleted successfully.", id) );
    }

}
