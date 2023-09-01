package com.luv2code.springboot.cruddemoemployee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemoemployee.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
  
	//define feild for EntityManager
	
	private EntityManager entityManager;
	
	//set up constructor for injection
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	@Override
	public List<Employee> findAll() {
		// Create a query
		TypedQuery<Employee> theQuery= entityManager.createQuery("from Employee",Employee.class);
		
		//execute a query and get result list
		List<Employee> employees = theQuery.getResultList();		
		//return the results
		return employees;
	}

}
