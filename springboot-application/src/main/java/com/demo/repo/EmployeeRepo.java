package com.demo.repo;

import com.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    //custom method

    public List<Employee> findByEmpFirstName(String empFirstName);

    public List<Employee> findByEmpFirstNameAndEmpLastName(String empFirstName, String empLastName);

    public Employee findByEmpEmailIdAndEmpPassword(String empEmailId, String empPassword);

    public Employee findByEmpContactNumber(long empContactNumber);
}
