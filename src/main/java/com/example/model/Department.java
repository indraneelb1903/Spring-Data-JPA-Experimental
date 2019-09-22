package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "dept_name")
	private String deptName;
	
	@Column(name = "dept_description")
	private String deptDescription;
	
	protected Department() {
		
	}

	public Department(String deptName, String deptDescription) {
		this.deptName = deptName;
		this.deptDescription = deptDescription;
	}

	public Long getId() {
		return id;
	}

	public String getDeptName() {
		return deptName;
	}

	public String getDeptDescription() {
		return deptDescription;
	}
	
}
