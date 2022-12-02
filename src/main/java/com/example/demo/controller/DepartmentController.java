package com.example.demo.controller;

import com.example.demo.controller.interfaces.AbstractDepartmentController;
import com.example.demo.dto.DepartmentDTO;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/department")
public class DepartmentController implements AbstractDepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService)
    {

        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> addDept(@RequestBody DepartmentDTO deptDto)
    {
        Department dept = departmentService.addDept(deptDto);
        DepartmentDTO deptResponse = departmentService.toDTO(dept);
        return new ResponseEntity<>(deptResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public Department updateDept(@PathVariable("id")  int id, @RequestBody DepartmentDTO deptDTO) {
        return departmentService.updateDept(id, deptDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteDept(@PathVariable("id") int id)
    {
        departmentService.deleteDept(id);
        return ResponseEntity.ok(String.format("Department %d deleted successfully.", id));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> findDeptById(@PathVariable("id") int id)
    {
        DepartmentDTO deptDto = departmentService.findById(id);
        return new ResponseEntity<>(deptDto, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/employees")
    public Set<Employee> getEmployees(@PathVariable("id") int id)
    {
        return departmentService.getEmployees(id);
    }
}
