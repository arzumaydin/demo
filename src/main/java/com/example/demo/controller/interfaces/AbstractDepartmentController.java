package com.example.demo.controller.interfaces;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.entity.Department;

public interface AbstractDepartmentController {
    public Department addDept(DepartmentDTO deptDto);
    public void deleteDept(int id);
    public DepartmentDTO findDeptById(int id);

    public Department updateDept(int id, DepartmentDTO deptDTO);
}
