package com.example.model;

import java.util.Date;

public class EmployeeDeptDTO {

	private String firstName;
	
	private String lastName;
	
	private Date dateOfBirth;
	
	private String deptName;
	
	private String deptDescription;

	public EmployeeDeptDTO(String firstName, String lastName, Date dateOfBirth,
			String deptName, String deptDescription) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.deptName = deptName;
		this.deptDescription = deptDescription;
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

	public String getDeptName() {
		return deptName;
	}

	public String getDeptDescription() {
		return deptDescription;
	}
	
}
