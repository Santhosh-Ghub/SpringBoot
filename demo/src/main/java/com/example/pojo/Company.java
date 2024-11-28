package com.example.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name="companyInfo")
public class Company {
	@Id
	private int id;
	@Column(name="companyName")
	private String companyName;
	@Column(name="companyDomain")
	private String companyDomain;
	
	

}
