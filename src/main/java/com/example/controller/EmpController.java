package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.EmployeeDto;
import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin("http://localhost:3000")
public class EmpController {
	
	  
	@Autowired
	 public EmployeeService empService;
	
	@GetMapping("/{id}")
	 public ResponseEntity<Employee> getEmpById(@PathVariable Long id){
		 
		 
		  return new ResponseEntity(empService.getEmpById(id), HttpStatus.OK);
	 }  
	
	 @GetMapping
	 public ResponseEntity<List<Employee>> getAllEmps(){
		 
		 
		  return new ResponseEntity(empService.getAllEmps(), HttpStatus.OK);
	 }  
	 
	 @PostMapping()
	 public ResponseEntity<Employee> addEmps(@RequestBody EmployeeDto empDto){
		 
		    // employee service 
		      ;
		 
		  return new ResponseEntity(empService.addEmployee(empDto), HttpStatus.OK);
	 }  
	 
	 @PostMapping("/{id}")
	 public ResponseEntity<Employee> updateEmps(@PathVariable Long id,  @RequestBody EmployeeDto empDto){
		 
		    // employee service 
		      ;
		 
		  return new ResponseEntity(empService.udpateEmployee(id, empDto), HttpStatus.OK);
	 }  
	 
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Employee> deleteEmps(@PathVariable Long id){
		 
		    // employee service 
		      ;
		 
		  return new ResponseEntity(empService.deletedEmployee(id), HttpStatus.OK);
	 }  
	 
	 
	 
	 

}
