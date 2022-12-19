package com.example.demo.service;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repo.AbstractDepartmentRepo;
import com.example.demo.repo.AbstractEmployeeRepo;
import com.example.demo.service.interfaces.AbstractDepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
public class DepartmentService implements AbstractDepartmentService {
    private final AbstractDepartmentRepo departmentRepo;
    private final AbstractEmployeeRepo employeeRepo;

    public ResponseEntity<DepartmentDTO> addDept(DepartmentDTO departmentDto) {
        Department department = departmentDto.toEntity();
        departmentRepo.save(department);
        DepartmentDTO departmentDtoResponse = department.toDTO();
        return new ResponseEntity<>(departmentDtoResponse, HttpStatus.OK);
    }
    public ResponseEntity deleteDept(int id) {
        Department department = departmentRepo.findById(id).
                orElseThrow( () -> new EntityNotFoundException("Department does not exist."));
        departmentRepo.deleteById(id);
        return ResponseEntity.ok( String.format("Department %d deleted successfully.", id) );
    }

    public ResponseEntity<DepartmentDTO> findById(int id) {
        Department dept = departmentRepo.findById(id).
                orElseThrow( () -> new EntityNotFoundException("Department does not exist."));
        return new ResponseEntity<>(dept.toDTO(), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<DepartmentDTO> updateDept(int id, DepartmentDTO deptChanges) {
        Department dept = departmentRepo.findById(id).
                orElseThrow( () -> new EntityNotFoundException("Department does not exist."));
        dept.setName(deptChanges.getName());
        departmentRepo.save(dept);
        return new ResponseEntity<>(dept.toDTO(), HttpStatus.OK);
    }

    public ResponseEntity<Set<EmployeeDTO>> getEmployees(int id){
        Set<EmployeeDTO> employeeDtos = new HashSet<>();
        Department dept = departmentRepo.findById(id).
                orElseThrow( () -> new EntityNotFoundException("Department does not exist."));

        Set<Employee> employees = employeeRepo.findByDept(id);
        for(Employee e : employees)
        {
            employeeDtos.add(e.toDTO());
        }

        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }

}
