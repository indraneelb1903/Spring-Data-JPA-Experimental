package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.model.EmployeeDeptDTO;
import com.example.service.EmployeeService;
import com.example.utility.RandomDateGenerator;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/insert")
	public void insertEmployees() {
		employeeService.insertEmployee(new Employee("john", "doe", RandomDateGenerator.getRandomDate(), 1l));
		employeeService.insertEmployee(new Employee("james", "cannon", RandomDateGenerator.getRandomDate(), 2l));
		employeeService.insertEmployee(new Employee("alan", "dorset", RandomDateGenerator.getRandomDate(), 3l));
		employeeService.insertEmployee(new Employee("michael", "watson", RandomDateGenerator.getRandomDate(), 4l));
		employeeService.insertEmployee(new Employee("jamie", "horn", RandomDateGenerator.getRandomDate(), 1l));
		employeeService.insertEmployee(new Employee("david", "mason", RandomDateGenerator.getRandomDate(), 2l));
		employeeService.insertEmployee(new Employee("ryan", "harvey", RandomDateGenerator.getRandomDate(), 3l));
		employeeService.insertEmployee(new Employee("ian", "benson", RandomDateGenerator.getRandomDate(), 4l));
		employeeService.insertEmployee(new Employee("darren", "jackson", RandomDateGenerator.getRandomDate(), 1l));
		employeeService.insertEmployee(new Employee("carter", "hughes", RandomDateGenerator.getRandomDate(), 2l));
		employeeService.insertEmployee(new Employee("travis", "donchester", RandomDateGenerator.getRandomDate(), 3l));
		employeeService.insertEmployee(new Employee("sam", "mount", RandomDateGenerator.getRandomDate(), 4l));
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		Optional<Employee> employeeOptional = employeeService.findEmployeeById(id);
		if(employeeOptional.isPresent()) {
			return employeeOptional.get();
		}
		else {
			return null;
		}
	}
	
	@GetMapping("/department/{id}")
	public List<Employee> getEmployeesByDepartmentId(@PathVariable("id") Long id){
		Optional<List<Employee>> employeeListOptional = employeeService.findEmployeesByDeptId(id);
		if(employeeListOptional.isPresent()) {
			return employeeListOptional.get();
		}
		else {
			return null;
		}
	}
	
	@GetMapping("/department/join/{id}")
	public List<EmployeeDeptDTO> getEmployeesByDepartmentJoinId(@PathVariable("id") Long id){
		return  employeeService.findJoinDTO(id);
	
		
	}
	

}
