package com.example.demo.controller;

import com.example.demo.controller.interfaces.AbstractEmployeeController;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<EmployeeDTO> findAllEmployees() {

        return employeeService.findEmployees();
    }

    // create employee - post mapping
    @PostMapping
    public Employee addEmployee(@RequestBody EmployeeDTO employeeDto) {
        return employeeService.addEmployee(employeeDto);
    }

    // get employee by id - get mapping
    @GetMapping(value = "/{id}")
    public EmployeeDTO findEmployee(@PathVariable("id")  int id) {
        return employeeService.findEmployee(id);
    }

    // update employee - put mapping
    @PutMapping(value = "/{id}")
    public void updateEmployee(@PathVariable("id")  int id, @RequestBody EmployeeDTO employee) {
        employeeService.updateEmployee(id, employee);
    }

    // delete employee - delete mapping
    @DeleteMapping(value = "/{id}")
    public void deleteEmployee(@PathVariable("id") int id){
        employeeService.deleteEmployee(id);
    }

}
