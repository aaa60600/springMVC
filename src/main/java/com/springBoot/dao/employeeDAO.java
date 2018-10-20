package com.springBoot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.springBoot.employee;
import com.springBoot.repository.employeeRespository;

//import antlr.collections.List;

@Service
public class employeeDAO {
	
	@Autowired
	employeeRespository employeeRespository;

	/*to save an employee*/
	public employee save(employee emp) {
		return employeeRespository.save(emp);
	}
	
	/* search all employees*/
	public List<employee> findAll(){
		return employeeRespository.findAll();
	}
	
	/*get an employee*/
	
	public employee findOne(Long empid) {
		return employeeRespository.findOne(empid);
	}
	
	
	/*delete an employee*/
	public void delete(employee emp) {
		employeeRespository.delete(emp);
	}
	
}
