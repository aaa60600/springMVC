package com.springBoot.controller;

import javax.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.employee;
import com.springBoot.dao.employeeDAO;

//import antlr.collections.List;

@RestController
@RequestMapping("/company")
public class employeeController {
	@Autowired
	employeeDAO employeeDAO;
	
	/*to save an employee*/
	@PostMapping("/employees")
	public employee creatEmployee(@Valid @RequestBody employee emp) {
		return employeeDAO.save(emp);
	}
	
	/*get all employees*/
	@GetMapping("/employees")
	public List<employee> getAllEmployees(){
		return employeeDAO.findAll();
	}
	
	/*get employee by empid*/
	@GetMapping("/notes/{id}")
	public ResponseEntity<employee> getEmployeeById(@PathVariable(value="id") Long empid){
		employee emp = employeeDAO.findOne(empid);
		
		if (emp == null ) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}
	
	/*update an employee by empid*/
	@PutMapping("/employee/{id}")
	public ResponseEntity<employee> updateEmployee(@PathVariable(value="id") Long empid,@Valid @RequestBody employee empDetails){
		
		employee emp=employeeDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		
		emp.setName(empDetails.getName());
		emp.setDescription(empDetails.getDescription());
		emp.setExpertise(empDetails.getExpertise());
		
		employee updateEmployee=employeeDAO.save(emp);
		return ResponseEntity.ok().body(updateEmployee);
		
	}
	
	/*Delete an employee*/
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<employee> deleteEmployee(@PathVariable(value="id") Long empid){
		
		employee emp=employeeDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		employeeDAO.delete(emp);
		
		return ResponseEntity.ok().build();
		
		
	}
	
}
