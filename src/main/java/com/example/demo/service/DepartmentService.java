package com.example.demo.service;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repo.AbstractDepartmentRepo;
import com.example.demo.repo.AbstractEmployeeRepo;
import com.example.demo.service.interfaces.AbstractDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Set;

@Service
public class DepartmentService implements AbstractDepartmentService {
    private final AbstractDepartmentRepo departmentRepo;
    private final AbstractEmployeeRepo employeeRepo;
    private final EmployeeService employeeService;

    @Autowired
    public DepartmentService(AbstractDepartmentRepo departmentRepo, AbstractEmployeeRepo employeeRepo, EmployeeService employeeService)
    {
        this.employeeRepo = employeeRepo;
        this.departmentRepo = departmentRepo;
        this.employeeService = employeeService;
    }

    public Department addDept(DepartmentDTO deptDto) {
        Department dept = toEntity(deptDto);
        departmentRepo.save(dept);
        return dept;
    }
    public void deleteDept(int id) {
        if(checkDeptExists(id)) {
            departmentRepo.deleteById(id);
        }
    }

    public DepartmentDTO findById(int id) {
        Department dept = new Department();
        if(checkDeptExists(id)) {
            dept = departmentRepo.findById(id);
        }
        return toDTO(dept);
    }

    public Department toEntity(DepartmentDTO deptDto){
        Department dept = new Department();
        dept.setName(deptDto.getName());
        return dept;
    }
    public DepartmentDTO toDTO(Department dept){
        DepartmentDTO deptDTO = new DepartmentDTO();
        deptDTO.setName(dept.getName());
        deptDTO.setID(dept.getID());
        return deptDTO;
    }

    @Transactional
    public Department updateDept(int id, DepartmentDTO deptChanges) {
        Department dept = new Department();
        if(checkDeptExists(id)) {
            dept = departmentRepo.findById(id);
        }
        dept.setName(deptChanges.getName());
        return dept;
    }

    public Set<EmployeeDTO> getEmployees(int id){
        Set<EmployeeDTO> employeeDtos = new HashSet<>();

        if(checkDeptExists(id)) {
            Set<Employee> employees = employeeRepo.findByDept(id);
            for(Employee e : employees)
            {
                employeeDtos.add(employeeService.toDTO(e));
            }
        }
        return employeeDtos;
    }

    public boolean checkDeptExists(int id){
        if(departmentRepo.existsById(id)) {
            return true;
        }
        else{
            throw new EntityNotFoundException("Department does not exist.");
        }
    }
}
