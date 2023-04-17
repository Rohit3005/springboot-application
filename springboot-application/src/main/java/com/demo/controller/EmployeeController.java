package com.demo.controller;

import com.demo.constant.EndPointConstants;
import com.demo.exception.RecordNotFoundException;
import com.demo.model.Employee;
import com.demo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping(EndPointConstants.SIGN_UP)
    public ResponseEntity<Employee> signUp(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeServiceImpl.signUp(employee), HttpStatus.CREATED);
    }

    @GetMapping(EndPointConstants.SIGN_IN)
    public ResponseEntity<Boolean> signIn(@PathVariable String empEmailId, @PathVariable String emPassword) {
        return ResponseEntity.ok(employeeServiceImpl.signIn(empEmailId, emPassword));
    }

    @GetMapping(EndPointConstants.GET_DATA_BY_ID)
    public ResponseEntity<Optional<Employee>> getDataById(@PathVariable int empId) {
        return ResponseEntity.ok(employeeServiceImpl.getDataById(empId));
    }

    @GetMapping(EndPointConstants.GET_ALL_DATA)
    public ResponseEntity<List<Employee>> getAllData() {
        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }

    @GetMapping(EndPointConstants.GET_DATA_BY_FIRSTNAME)
    public ResponseEntity<List<Employee>> getDataByFirstName(@PathVariable String empFirstName) {
        return ResponseEntity.ok(employeeServiceImpl.getDataFirstName(empFirstName));
    }

    @GetMapping(EndPointConstants.GET_DATA_BY_FULL_NAME)
    public ResponseEntity<List<Employee>> getDataByFullName(@PathVariable String empFirstName, @PathVariable String empLastName) {
        return ResponseEntity.ok(employeeServiceImpl.getDataByFullName(empFirstName, empLastName));
    }

    @GetMapping(EndPointConstants.GET_DATA_BY_CONTACT_NUMBER)
    public ResponseEntity<Employee> getDatByContactNumber(@PathVariable long empContactNUmber) {
        return ResponseEntity.ok(employeeServiceImpl.getDataByContactNumber(empContactNUmber));
    }

    @GetMapping(EndPointConstants.GET_DATA_EMAIL_ID)
    public ResponseEntity<Employee> getDataByEmailId(@PathVariable String empEmailId) {
        return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().filter(e -> e.getEmpEmailId().equals(empEmailId)).collect(Collectors.toList()).get(0));
    }

    @GetMapping(EndPointConstants.GET_DATA_BY_ANY_INPUT)
    public ResponseEntity<List<Employee>> getDataByAnyInput(@PathVariable String input) {
        return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().filter(e -> String.valueOf(e.getEmpId()).equals(input) || e.getEmpFirstName().equals(input) || e.getEmpLastName().equals(input)
                || String.valueOf(e.getEmpContactNumber()).equals(input) || e.getEmpEmailId().equals(input)).collect(Collectors.toList()));
    }

    @PutMapping(EndPointConstants.UPDATE_DATA)
    public ResponseEntity<Employee> updateData(@PathVariable int empId, @RequestBody Employee employee) {
        Employee employee1 = employeeServiceImpl.getDataById(empId).orElseThrow(() -> new RecordNotFoundException("Employee ID Does NOT EXIST"));

        employee1.setEmpEmailId(employee.getEmpEmailId());
        employee1.setEmpAge(employee.getEmpAge());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpFirstName(employee.getEmpFirstName());
        employee1.setEmpPassword(employee.getEmpPassword());
        employee1.setEmpLastName(employee.getEmpLastName());

        return new ResponseEntity<>(employeeServiceImpl.updateData(employee1), HttpStatus.CREATED);
    }

    @GetMapping(EndPointConstants.SORT_BY_FIRST_NAME)
    public ResponseEntity<List<Employee>> sortDataByFirstName() {
        return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().sorted(Comparator.comparing(Employee::getEmpFirstName)).collect(Collectors.toList()));
    }

    @GetMapping(EndPointConstants.SORT_DATA_BY_ID)
    public ResponseEntity<List<Employee>> sortDataById() {
        return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().sorted(Comparator.comparingInt(Employee::getEmpId)).collect(Collectors.toList()));
    }

    @GetMapping(EndPointConstants.SORT_DATA_BY_AGE)
    public ResponseEntity<List<Employee>> sortDataByAge() {
        return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().sorted(Comparator.comparingLong(Employee::getEmpAge)).collect(Collectors.toList()));
    }

    @GetMapping(EndPointConstants.SORT_DATA_BY_SALARY)
    public ResponseEntity<List<Employee>> sortDataBySalary() {
        return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().sorted(Comparator.comparingDouble(Employee::getEmpSalary)).collect(Collectors.toList()));
    }

    @GetMapping(EndPointConstants.FILTER_DATA_BY_SALARY)
    public ResponseEntity<List<Employee>> filterDataBySalary(@PathVariable double empSalary) {
        return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().filter(e -> e.getEmpSalary() >= empSalary).collect(Collectors.toList()));
    }

    @DeleteMapping(EndPointConstants.DELETE_DATA_BY_ID)
    public ResponseEntity<String> deleteDataById(@PathVariable int empId) {
        employeeServiceImpl.deleteDataById(empId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }

    @DeleteMapping(EndPointConstants.DELETE_ALL_DATA)
    public ResponseEntity<String> deleteAllData() {
        employeeServiceImpl.deleteAllData();
        return ResponseEntity.ok("All Data Deleted");
    }

}
