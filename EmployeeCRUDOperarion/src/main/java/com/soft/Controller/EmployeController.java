package com.soft.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soft.Entity.Employee;
import com.soft.Service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeController {
	
	@Autowired
	private EmployeeService employeeService;

	//save employee
	@PostMapping("/saveEmp")
	public Employee saveEmployee(@RequestBody Employee emp) {
		Employee savedEmp = employeeService.saveEmployeeDetails(emp);
		return emp;
	}
	// get all employee list
	@GetMapping("/getAllEmpList")
	public List<Employee> getAllEmp(){
		List<Employee> empList = employeeService.getAllEmpByService();
		return empList;
	}
	//employee find by id
	@GetMapping("/findEmpById")
	public Employee getEmpById(@RequestParam int id) {
		Employee emp = employeeService.findEmpByIdService(id);
		return emp;
	}
	//employee delete by id
	@GetMapping("/deleteEmpById/{id}")
	public  void deleteEmpById(@PathVariable int id) {
		 employeeService.deleteEmpByIdService(id);	
	}
	//employee update by id
	@PostMapping("/updatEmpById/{id}")
	public Employee updateEmpById(@RequestParam int id, @RequestBody Employee emp) {
		Employee updateEmp= employeeService.updateEmpByIdService(id, emp);
		return updateEmp;
	}
	//employee find by name
	@GetMapping("/findByEmpName")
	public List<Employee> getEmpByName(@RequestParam String empName) {
		
		List<Employee> getList = employeeService.findByNameService(empName);
		
		return getList;
		
	}
	//find by salary by name
	@GetMapping("/findByEmpSalary")
	public List<Employee> getEmpBySalary(@RequestParam float empSalary){
		
		List<Employee> salaryList = employeeService.findByEmpSalaryService(empSalary);
		
		return salaryList;
		
	}
	// delete employee by name
	@GetMapping("/deleteEmpBySQL/{name}")
	public void deleteEmpBySQL(@PathVariable String name) {
		
		employeeService.deleteEmpByNameService(name);	
		
	}
	//max salary
	@GetMapping("/findMaxSalary")
	public int  getMaxSalary() {	 
		
		return employeeService.findMaxSalaryService();
		
	}
	//minimum salary
	@GetMapping("/findMinSalary")
	public float getMinSalary() {
		
		return employeeService.findMinSalaryService();	
		
	}
	//second highest saalary
	@GetMapping("/secHighSal")
	public Employee secondHighestSal() {
		
		Employee seccondHigh = employeeService.salaryService();
		
		return seccondHigh;
		
	}
	
	//count for salary
    @GetMapping("/getCountEmp")
	public int getCountEmployee() {
    	
		return employeeService.getCountEmpService();	
	}
    //salary less than 50000
    @GetMapping("/getSalary")
    public List<Employee> getSalaryGreater() {
    
		return employeeService.getSalaryservice();
    	
    }
}
