package com.example.demo.controller;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.interfaces.AbstractDepartmentService;
import com.example.demo.service.interfaces.AbstractEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/department")
public class DepartmentController{

    private final AbstractDepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDTO> addDept(@RequestBody DepartmentDTO deptDto)
    {
        return departmentService.addDept(deptDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> updateDept(@PathVariable("id")  int id, @RequestBody DepartmentDTO deptDTO) {
        return departmentService.updateDept(id, deptDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteDept(@PathVariable("id") int id)
    {
        return departmentService.deleteDept(id);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> findDeptById(@PathVariable("id") int id)
    {
        return departmentService.findById(id);
    }

    @GetMapping(value = "/{id}/employees")
    public ResponseEntity<Set<EmployeeDTO>> getEmployees(@PathVariable("id") int id)
    {
        return departmentService.getEmployees(id);
    }
}
