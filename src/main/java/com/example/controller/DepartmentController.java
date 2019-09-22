package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Department;
import com.example.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService DepartmentService;
	
	@GetMapping("/insert")
	public void insertDepartments() {
		DepartmentService.saveDepartment(new Department("IT", "Information Technology"));
		DepartmentService.saveDepartment(new Department("TelCom", "Telecommunication"));
		DepartmentService.saveDepartment(new Department("Ins", "Insurance"));
		DepartmentService.saveDepartment(new Department("HR", "Human Resources"));
	}
	
	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable("id") Long id) {
		Optional<Department> department = DepartmentService.findDepartmentById(id);
		if(department.isPresent()) {
			return department.get();
		}
		else {
			return null;
		}
	}
}
