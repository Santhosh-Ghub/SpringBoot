package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pojo.Employee;
import com.example.repo.EmployeeRepository;
import com.example.startup.StartupService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class EmployeeService {
	 
	@Autowired
	EmployeeRepository employeeRepo;
	
	public Employee empCreation(Employee employer) {
		
		employeeRepo.save(employer);
		log.info("An Employee is created");
		return employer;
		
		
	}
	
	public Employee getEmployeeDetails(String name) {  
		Employee empFromDB = employeeRepo.getByName(name);
		System.out.println(StartupService.companyInfo.get("Google"));
		System.out.println(System.getProperty("testData"));
		log.info("Employe details are viewed");
		return empFromDB;
		
		
	}
	
	
	public String updateEmployeeDetails(Employee employer) {
		Employee empFromDB = employeeRepo.getByName(employer.getName());
		String resp ="";
		if( empFromDB!=null && empFromDB.getName()!=null) {
			
			if(employer.getDept()!="")
			empFromDB.setDept((employer.getDept()!=empFromDB.getDept()?employer.getDept():empFromDB.getDept()));
			if(employer.getSalary()>0)
			empFromDB.setSalary((employer.getSalary()!=empFromDB.getSalary()?employer.getSalary():empFromDB.getSalary()));
		}
		
		int resut = employeeRepo.updateEmployeeByName(empFromDB.getId(),empFromDB.getName(),empFromDB.getDept(),empFromDB.getSalary());
		
		if(resut==1) 
			resp="Employee Details update success.";
			else
				resp="Employee Details update falied.";
		log.info("An employee is updated");
		
		return resp;
		
		
	}	
	public Object empDeletion(String name) {
		try {
			int result=employeeRepo.deleteByName(name);
			log.info("One employee is deleted");
			return result>0? "The record is  successfully deleted":"An Error occured in Deletion";
			
			
		}catch (Exception e) {
			return e;
			
		}
		
	}
	

}
