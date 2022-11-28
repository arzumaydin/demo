package com.example.demo.controller;

import com.example.demo.controller.interfaces.AbstractDepartmentController;
import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/department")
public class DepartmentController implements AbstractDepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService)
    {

        this.departmentService = departmentService;
    }

    @PostMapping
    public Department addDept(@RequestBody DepartmentDTO deptDto)
    {
        return departmentService.addDept(deptDto);
    }

    @PutMapping(value = "/{id}")
    public Department updateDept(@PathVariable("id")  int id, @RequestBody DepartmentDTO deptDTO) {
        return departmentService.updateDept(id, deptDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteDept(@PathVariable("id") int id)
    {
        departmentService.deleteDept(id);
    }

    @GetMapping(value = "/{id}")
    public DepartmentDTO findDeptById(@PathVariable("id") int id)
    {
        return departmentService.findById(id);
    }

    @GetMapping(value = "/{id}/employees")
    public Set<Employee> getEmployees(@PathVariable("id") int id)
    {
        return departmentService.getEmployees(id);
    }
}
