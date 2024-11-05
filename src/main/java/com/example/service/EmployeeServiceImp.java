package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.dto.EmployeeDto;
import com.example.model.Employee;
import com.example.repo.EmployeeRepo;

@Service
public class EmployeeServiceImp  implements EmployeeService {
   
	
	 @Autowired
	 public EmployeeRepo empRepo;
	 
	 
	
	@Cacheable("employees")
	@Override
	public List<Employee> getAllEmps() {
		// TODO Auto-generated method stub
		   System.out.println("get all employee method is called");
		return     empRepo.findAll();
		
	}

	@CacheEvict(value="employees", allEntries = true)
	@Override
	public Employee addEmployee(EmployeeDto emp) {
		// TODO Auto-generated method stub
		System.out.println("emp add method is called");
		return empRepo.save(Employee.builder()
				                    .name(emp.getName())
				                    .department(emp.getDepartment())
				                    .build()
				                    );
	}
     
	@CacheEvict(value="employees", allEntries = true)
	@Override
	public Employee udpateEmployee(Long empId, EmployeeDto emp) {
		// TODO Auto-generated method stub
		
		
		// find employee 
		   Employee empdb =   getEmpById(empId);
		       
		   // update the fields
		  empdb.setDepartment(emp.getDepartment());
		  empdb.setName(emp.getName());
		  
		  System.out.println("emp update method is called");
		  // save and return
		return  empRepo.save(empdb);
	}

	@CacheEvict(value="employees", allEntries = true)
	@Override
	public Employee deletedEmployee(Long empId) {
		// TODO Auto-generated method stub
		
		// find employee 
		   Employee empdb =   getEmpById(empId);
		   
		   System.out.println("Employee delete method is called ");
		      empRepo.delete(empdb);
		return   empdb;
	}
	
	
	@Override
	public Employee getEmpById(Long empId) {
		
		return  empRepo.findById(empId).orElseThrow(() -> new RuntimeException("There is not employee with this id " + empId));
	}

}
