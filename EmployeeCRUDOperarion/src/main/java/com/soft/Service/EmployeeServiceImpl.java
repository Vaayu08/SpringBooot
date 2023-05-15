package com.soft.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.Entity.Employee;

import com.soft.Repo.EmployeeRepo;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Employee saveEmployeeDetails(Employee emp) {
		Employee saveEmpFromService =  employeeRepo.save(emp);
		
		return saveEmpFromService;
	}

	@Override
	public List<Employee> getAllEmpByService() {
		
		List<Employee> empListByRepo = employeeRepo.findAll();
		
		return empListByRepo;
	}

	@Override
	public Employee findEmpByIdService(int empId) {
		// TODO Auto-generated method stub
		Employee emp = null;
		Optional<Employee> checkEmpById = null;
		try {
			checkEmpById = employeeRepo.findById(empId);
			if (checkEmpById.isPresent()) {
				emp = checkEmpById.get();
			}else {
				System.out.println("employee not found by this id");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public  void deleteEmpByIdService(int empId) {
		// TODO Auto-generated method stub
		Employee emp = null;
		Optional<Employee> checkEmpById = null;

		try {
			checkEmpById = employeeRepo.findById(empId);
			if (checkEmpById.isPresent()) {
				emp = checkEmpById.get();
				employeeRepo.deleteById(empId);
			}else {
				System.out.println("employee not found by this id");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public Employee updateEmpByIdService(int empId,Employee emp) {
		Employee updateemp = null;
		Optional<Employee> checkEmpById = null;

		try {
			checkEmpById = employeeRepo.findById(empId);
			if (checkEmpById.isPresent()) {
				updateemp = checkEmpById.get();
				updateemp.setEmpName(emp.getEmpName());
				updateemp.setEmpAddress(emp.getEmpAddress());
				updateemp.setEmpSalary(emp.getEmpSalary());
				updateemp.setEmpId(empId);
				employeeRepo.save(updateemp);
			}else {
				System.out.println("employee not found by this id");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return updateemp;
	}

	@Override
	public List<Employee> findByNameService(String empName) {
		// TODO Auto-generated method stub
		List<Employee> findByNamex = employeeRepo.findByNameRepo(empName);
		return findByNamex;
	}

	@Override
	public List<Employee> findByEmpSalaryService(float empSalary) {
		// TODO Auto-generated method stub
		
		return employeeRepo.findByEmpSalary(empSalary);
	}

	@Override
	public void deleteEmpByNameService(String empName) {
		// TODO Auto-generated method stub
		
		String emp = null;
		List<Employee> checkEmpByName = null;

		try {
			checkEmpByName = employeeRepo.findByNameRepo(empName);
			if (checkEmpByName!=null) {
				emp = checkEmpByName.toString();
				System.out.println("employee not found by this name");
				employeeRepo.deleteEmpByName(empName);
			}else {
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public int findMaxSalaryService() {
		// TODO Auto-generated method stub
		return employeeRepo.findMaxSalary();
	}

	@Override
	public float findMinSalaryService() {
		// TODO Auto-generated method stub
		return employeeRepo.findMinSalary();
	}

	@Override
	public int getCountEmpService() {
		// TODO Auto-generated method stub
		return employeeRepo.getCountEmp();
	}

	@Override
	public List<Employee> getSalaryservice() {
		// TODO Auto-generated method stub
		return employeeRepo.getsalaryGreater();
	}

	@Override
	public Employee salaryService() {
		// TODO Auto-generated method stub
		return employeeRepo.secondHighestSalary();
	}

}
