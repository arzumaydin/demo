package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.repo.AbstractDepartmentRepo;
import com.example.demo.repo.AbstractEmployeeRepo;
import com.example.demo.service.interfaces.AbstractEmployeeService;
import com.example.demo.util.utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService implements AbstractEmployeeService { // service uses the repository
    private final AbstractEmployeeRepo employeeRepo;

    private final AbstractDepartmentRepo departmentRepo;

    // inject repository
    @Autowired
    public EmployeeService(AbstractEmployeeRepo employeeRepo, AbstractDepartmentRepo departmentRepo)
    {
        this.employeeRepo = employeeRepo;
        this.departmentRepo = departmentRepo;
    }

    public List<EmployeeDTO> findEmployees()
    {
        List<Employee> employees = employeeRepo.findAll();
        List<EmployeeDTO> employeeDtos = new ArrayList<>();
        for(Employee e : employees)
        {
            EmployeeDTO employeeDto = toDTO(e);
            employeeDtos.add(employeeDto);
        }
        return employeeDtos;
    }

    public Employee addEmployee(EmployeeDTO employeeDto) {
        Employee employee = toEntity(employeeDto);
        return employeeRepo.save(employee);
    }

    public EmployeeDTO findEmployee(@PathVariable("id")  int id) {
        Employee employee = null;
        if(checkEmployeeExist(id)) {
            employee = employeeRepo.findById(id);
        }
        return toDTO(employee);
    }
    @Transactional
    public Employee updateEmployee(int id, EmployeeDTO employeeChanges) {
        Employee employee = null;
        if(checkEmployeeExist(id)) {
            employee = employeeRepo.findById(id);
        }
        employee.setName(employeeChanges.getName());
        Date date = utilities.stringToDate(employeeChanges.getBdate());
        employee.setDate(date);
        employee.setDept(departmentRepo.findById(employeeChanges.getDeptid()));
        employee.setSurname(employeeChanges.getSurname());
        return employee;
    }

    public void deleteEmployee(@PathVariable("id")  int id){
        if(checkEmployeeExist(id)) {
            employeeRepo.deleteById(id);
        }
    }

    @Transactional
    public Employee toEntity(EmployeeDTO employeeDto){
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());
        Date date = utilities.stringToDate(employeeDto.getBdate());
        employee.setDate(date);
        employee.setDept(departmentRepo.findById(employeeDto.getDeptid()));
        return employee;
    }
    @Transactional
    public EmployeeDTO toDTO(Employee employee){
        EmployeeDTO employeeDto = new EmployeeDTO();
        if(checkEmployeeExist(employee.getID()))
            employeeDto.setId(employee.getID());
        employeeDto.setName(employee.getName());
        employeeDto.setSurname(employee.getSurname());
        String date = utilities.dateToString(employee.getDate());
        employeeDto.setBdate(date);
        employeeDto.setDeptid(Integer.toString(employee.getDept().getID()));
        return employeeDto;
    }

    public boolean checkEmployeeExist(int id)
    {
        if(employeeRepo.existsById(id)) {
            return true;
        }
        else{
            throw new EntityNotFoundException("Employee does not exist.");
        }
    }
}
