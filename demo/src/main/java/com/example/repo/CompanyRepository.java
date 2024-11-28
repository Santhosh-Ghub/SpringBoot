package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.pojo.Company;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{
	
	
	@Query("SELECT c.companyName, c.companyDomain from companyInfo c")
	List<Company> findAllKeyValues();

}
