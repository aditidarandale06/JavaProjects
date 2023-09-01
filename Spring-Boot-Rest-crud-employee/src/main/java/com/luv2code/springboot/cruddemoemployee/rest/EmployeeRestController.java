package com.luv2code.springboot.cruddemoemployee.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemoemployee.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemoemployee.entity.Employee;
import com.luv2code.springboot.cruddemoemployee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
 //quick and dirty :inject employee dao(use constructor injection)
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	//expose "/employees" and return list of employees
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();		
		
	}
	
	
	
	
	}
