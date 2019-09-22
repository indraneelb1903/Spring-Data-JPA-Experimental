package com.example.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
     
     @Column(name = "first_name")
     private String firstName;
     
     @Column(name = "last_name")
     private String lastName;
     
     @Column(name = "dob")
     private Date dateOfBirth;
	
     @Column(name = "dept_id")
     private Long deptId;
     
     protected Employee() {
    	 
     }

	public Employee(String firstName, String lastName, Date dateOfBirth, Long deptId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.deptId = deptId;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public Long getDeptId() {
		return deptId;
	}
     
}
