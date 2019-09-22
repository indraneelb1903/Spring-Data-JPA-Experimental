package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Employee;
import com.example.model.EmployeeDeptDTO;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {

	public Optional<List<Employee>> findByDeptId(Long deptId);
	
	@Query("Select NEW com.example.model.EmployeeDeptDTO(e.firstName,e.lastName,e.dateOfBirth,d.deptName,d.deptDescription) from Employee e inner join fetch Department d on e.deptId=d.id where e.deptId=?1")
	public List<EmployeeDeptDTO> findAllByDepartmentId(Long id);
}
