package com.example.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
@Entity(name="employeeInfo")
public class Employee { 
	@Id 
	private int id;
	@NotNull(message="Name cannot be null")
	private String name;
	private int salary;
	private String dept;
	
	
	
}
