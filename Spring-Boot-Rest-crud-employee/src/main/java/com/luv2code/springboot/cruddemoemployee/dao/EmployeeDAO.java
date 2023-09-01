package com.luv2code.springboot.cruddemoemployee.dao;

import java.util.List;

import com.luv2code.springboot.cruddemoemployee.entity.Employee;

public interface EmployeeDAO {
	
		List<Employee> findAll();

	}



