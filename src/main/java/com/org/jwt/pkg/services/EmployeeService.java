package com.org.jwt.pkg.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.org.jwt.pkg.model.Employee;

@Service   //so we can autowired in other class
public class EmployeeService {
	
	private List<Employee> store=new ArrayList<Employee>();
	public EmployeeService() {
		store.addAll(Arrays.asList(new Employee(1234,"ashuctosh","IT"),new Employee(1235,"deepak","cse")));
	}
	
	public List<Employee> getEmployee(){
		return store;
		
	}	

}
