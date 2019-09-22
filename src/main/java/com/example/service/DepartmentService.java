package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Department;
import com.example.model.EmployeeDeptDTO;
import com.example.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	public void saveDepartment(Department department) {
	  departmentRepository.save(department);	
	}
	
	public Optional<Department> findDepartmentById(Long id) {
		return departmentRepository.findById(id);
	}
	
	
	
}
