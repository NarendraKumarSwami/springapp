package com.example.service;

import java.util.List;

import com.example.dto.EmployeeDto;
import com.example.model.Employee;

public interface EmployeeService {

	   public Employee getEmpById(Long id);
	
	    public List<Employee> getAllEmps();
	    
	    
	    public Employee addEmployee(EmployeeDto emp);
	    
	    
	    public Employee udpateEmployee(Long empId, EmployeeDto emp);
	    
	    
	    public Employee deletedEmployee(Long empId);
	    
	    
	    
}
