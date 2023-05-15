package com.soft.Service;

import java.util.List;


import org.springframework.stereotype.Component;

import com.soft.Entity.Employee;


public interface EmployeeService {
	
	public Employee saveEmployeeDetails(Employee emp);
	public List<Employee> getAllEmpByService();
	public Employee findEmpByIdService(int empId);
	public void deleteEmpByIdService(int empId);
	public Employee updateEmpByIdService(int empId,Employee emp);
	public List<Employee> findByNameService(String empName);
	public List<Employee> findByEmpSalaryService(float empSalary);
	public void deleteEmpByNameService(String empName);
	public int findMaxSalaryService();
	public float findMinSalaryService();
	public int getCountEmpService();
	public List<Employee> getSalaryservice();
	public Employee salaryService();

}