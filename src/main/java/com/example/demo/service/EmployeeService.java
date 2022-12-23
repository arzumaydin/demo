package com.example.demo.service;

import com.example.demo.dto.ClientResponseDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.entity.Employee;
import com.example.demo.repo.AbstractDepartmentRepo;
import com.example.demo.repo.AbstractEmployeeRepo;
import com.example.demo.service.interfaces.AbstractEmployeeService;
import com.example.demo.util.utilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Slf4j
@Service
public class EmployeeService implements AbstractEmployeeService {

    private static final String sourceUrl = "https://fakerapi.it/api/v1/addresses?_quantity=1";
    private final AbstractEmployeeRepo employeeRepo;
    private final RestTemplate restTemplate;
    private final AbstractDepartmentRepo departmentRepo;

    public EmployeeService(AbstractEmployeeRepo employeeRepo, @Qualifier("default") RestTemplate restTemplate, AbstractDepartmentRepo departmentRepo) {
        this.employeeRepo = employeeRepo;
        this.restTemplate = restTemplate;
        this.departmentRepo = departmentRepo;
    }

    public ResponseEntity<List<EmployeeDTO>> findEmployees()
    {
        List<Employee> employees = employeeRepo.findAll();
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        for(Employee e : employees)
        {
            EmployeeDTO employeeDto = e.toDTO();
            employeeDTOs.add(employeeDto);
        }

        return new ResponseEntity<>(employeeDTOs, HttpStatus.OK);
    }

    public ResponseEntity<EmployeeDTO> addEmployee(EmployeeDTO employeeDto) {
        int departmentID = Integer.parseInt(employeeDto.getDeptid());
        Employee employee = employeeDto.toEntity(departmentRepo.findById(departmentID).
                orElseThrow(() -> new EntityNotFoundException("Department does not exist.")));
        employeeRepo.save(employee);
        EmployeeDTO responseDto = employee.toDTO();
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    public ResponseEntity<EmployeeDTO> findEmployee(@PathVariable("id")  int id) {
        try {
            Employee employee = employeeRepo.findById(id).
                    orElseThrow(() -> new EntityNotFoundException("Employee does not exist."));
            return new ResponseEntity<>(employee.toDTO(), HttpStatus.OK);
        }
        catch(Exception exception){
            System.out.printf("Employee with id %d is not found.", id);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @Transactional
    public ResponseEntity<EmployeeDTO> updateEmployee(int id, EmployeeDTO employeeChanges) {
        Employee employee = employeeRepo.findById(id).
                orElseThrow( () -> new EntityNotFoundException("Employee does not exist.") );
        employee.setName(employeeChanges.getName());
        Date date = utilities.stringToDate(employeeChanges.getBdate());
        employee.setBdate(date);
        employee.setDept(departmentRepo.findById(Integer.parseInt(employeeChanges.getDeptid())).
                orElseThrow(() -> new EntityNotFoundException("Department does not exist.")));
        employee.setSurname(employeeChanges.getSurname());
        employeeRepo.save(employee);
        return new ResponseEntity<>(employee.toDTO(), HttpStatus.OK);
    }

    public ResponseEntity<String> deleteEmployee(@PathVariable("id")  int id){

        employeeRepo.findById(id).
                orElseThrow( () -> new EntityNotFoundException("Employee does not exist.") );
        employeeRepo.deleteById(id);
        return ResponseEntity.ok( String.format("Employee %d deleted successfully.", id) );
    }

    public ResponseEntity<ResponseDTO> getAddress(int id){

        EmployeeDTO employeeDTO = this.findEmployee(id).getBody();
        ClientResponseDTO clientResponseDTO = restTemplate.getForObject(sourceUrl, ClientResponseDTO.class);
        clientResponseDTO.setEmployee(employeeDTO);

        ResponseDTO responseDTO = new ResponseDTO(clientResponseDTO.getEmployee(), clientResponseDTO.getData());

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
