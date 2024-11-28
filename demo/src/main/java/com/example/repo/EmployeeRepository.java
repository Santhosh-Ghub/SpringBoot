package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.pojo.Employee;

import jakarta.transaction.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	public Employee getByName(String Name);
	@Modifying
	@Transactional
	@Query("UPDATE employeeInfo e SET e.name = :name, e.dept = :dept, e.salary = :salary WHERE e.id = :id")
	public int updateEmployeeByName(@Param("id")int id, @Param("name")String name, @Param("dept")String dept, @Param("salary")int salary);
	
	@Modifying
	@Transactional
	@Query("DELETE from employeeInfo  e WHERE e.name =:name")
	public int deleteByName(@Param("name") String name);

}
