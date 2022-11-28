package com.example.demo.service.interfaces;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.entity.Department;
public interface AbstractDepartmentService {

    public Department addDept(DepartmentDTO deptDto);
    public void deleteDept(int id);
    public DepartmentDTO findById(int id);

    public Department toEntity(DepartmentDTO deptDto);

    public DepartmentDTO toDTO(Department dept);
    public Department updateDept(int id, DepartmentDTO deptChanges);
}
