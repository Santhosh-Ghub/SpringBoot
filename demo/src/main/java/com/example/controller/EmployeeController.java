package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.Employee;
import com.example.services.CommunicationService;
import com.example.services.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("demo")
public class EmployeeController {
	
	@Autowired EmployeeService employeeService;
	@Autowired CommunicationService communicationService;
	
	@PostMapping("/employer" )
	public Employee salary(@RequestBody Employee employer) {
		 
		String response =communicationService.communicationGet(employer.getName());
		System.out.println("Response from external service :"+response);
		return  employeeService.empCreation(employer);
		
	}
	@GetMapping("/employer/{name}")
	public Employee getMethodName(@PathVariable String name) {
		return  employeeService.getEmployeeDetails(name);
	}
	
	@PostMapping("/employer/update" )
	public Object updateEmployee(@RequestBody Employee employer) {
		String response =communicationService.communicationPost(employer.getName(),employer.getDept());
		System.out.println("Response from external service :"+response);
		 
		return  employeeService.updateEmployeeDetails(employer);
		
	}
	@GetMapping("/employer/delete/{name}")
	public Object DeleteEmployee(@PathVariable String name) {
		return employeeService.empDeletion(name);
	}
	

}
