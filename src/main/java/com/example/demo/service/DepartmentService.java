package com.example.demo.service;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repo.AbstractDepartmentRepo;
import com.example.demo.repo.AbstractEmployeeRepo;
import com.example.demo.service.interfaces.AbstractDepartmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Set;

@Slf4j
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
    public ResponseEntity<String> deleteDept(int id) {
        Department department = departmentRepo.findById(id).
                orElseThrow( () -> new EntityNotFoundException("Department does not exist."));
        if(department != null)
        {
            departmentRepo.deleteById(id);
            return new ResponseEntity<>(String.format("Department %d deleted successfully.", id), HttpStatus.OK );
        }
        return new ResponseEntity<>(String.format("Department with id %d is not found.", id), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<DepartmentDTO> findById(int id) {
        Department dept = departmentRepo.findById(id).
                orElseThrow( () -> new EntityNotFoundException("Department does not exist."));
        return new ResponseEntity<>(dept.toDTO(), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<?> updateDept(int id, DepartmentDTO deptChanges) {
        try {
            Department dept = departmentRepo.findById(id).
                    orElseThrow(() -> new EntityNotFoundException("Department does not exist."));
            dept.setName(deptChanges.getName());
            departmentRepo.save(dept);
            return new ResponseEntity<>(dept.toDTO(), HttpStatus.OK);
        }
        catch(Exception exception){
            log.error("Something went wrong while updating the department with message \"{}\".", exception.getMessage());
        }
        return new ResponseEntity<>("FAILURE", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Set<EmployeeDTO>> getEmployees(int id){
        Set<EmployeeDTO> employeeDTOs = new HashSet<>();
        try {
            Department dept = departmentRepo.findById(id).
                    orElseThrow(() -> new EntityNotFoundException("Department does not exist."));
            if(dept != null) {
                Set<Employee> employees = employeeRepo.findByDept(id);
                for (Employee e : employees) {
                    employeeDTOs.add(e.toDTO());
                }
                return new ResponseEntity<>(employeeDTOs, HttpStatus.OK);
            }
        }
        catch (Exception exception){
            System.out.print("Something went wrong while getting employees from database.");
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
