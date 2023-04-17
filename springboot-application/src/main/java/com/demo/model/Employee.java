package com.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private int empId;

    @Size(min = 4, message ="First Name Should contain at least 4 character")
    private String empFirstName;

    @Pattern(regexp = "[a-zA-Z]*",message = "Last Name Should not contain any special character")
    private String empLastName;


    private long empContactNumber;

    private double empSalary;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date empDOB;

    private int empAge;

    @Email(message = "Email Id must be valid")
    private String empEmailId;

    @Size(min = 4 , message = "Password contain at 4 character")
    private String empPassword;
}
