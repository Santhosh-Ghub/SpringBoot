package com.example.startup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pojo.Company;
import com.example.repo.CompanyRepository;

import jakarta.annotation.PostConstruct;


@Service
public class StartupService {
	public static Map<String, String>companyInfo=new HashMap<>();
	@Autowired
	CompanyRepository companyRepo;
	
	

	@PostConstruct
	public void init() {
		List<Company>entries=companyRepo.findAll();
		for(Company a:entries) {
			companyInfo.put(a.getCompanyName(), a.getCompanyDomain());
			
		}
		System.out.println(companyInfo.toString());
	}
}
