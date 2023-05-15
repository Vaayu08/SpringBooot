package com.soft.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soft.model.Employee;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

	
	
	@GetMapping("/msg")
	public String showMsg() {
		return "welcome to spring boot programming";
		
	}
	
	@GetMapping("/getEmp")
	public Employee getEmp() {
		
		Employee emp = new Employee();
		emp.setId(101);
		emp.setName("siddharth");
		emp.setSalary(123600);
		
		
		return emp;
		
	}
	@PostMapping("/readEmp")
	public String readEmp(@RequestBody Employee emp) {
		
		
		return "Id::"+emp.getId()+",Name::"+emp.getName()+",Salary::"+emp.getSalary()+"";
		
	}
}
