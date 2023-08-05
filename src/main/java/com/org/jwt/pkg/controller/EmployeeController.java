package com.org.jwt.pkg.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.jwt.pkg.model.Employee;
import com.org.jwt.pkg.services.EmployeeService;

@RestController
public class EmployeeController {
	
    @Autowired
	private EmployeeService empService;

	@GetMapping("getemployeedetails")
	public List<Employee> getEmployeeDatils() {		
		Employee emp=new Employee();
		emp.setId(1234);		
		return empService.getEmployee();		
	}
	
	@GetMapping("getLoggedInUser")
	public Principal getLoggedInUser(Principal principal) {
		return principal;		
	}
}
