package com.novatesoft.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novatesoft.springboot.pojo.Employee;
import com.novatesoft.springboot.pojo.EmployeeEntity;
import com.novatesoft.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
     @Override
	public List<EmployeeEntity> getAllEmployees() {
    	 System.out.println("employee service method");
    	 return employeeRepository.findAll();
		
	}

	@Override
	public void deleteEmployee(Long empid) {
		employeeRepository.deleteById(empid);
	}

	@Override
	public boolean updateEmployee(EmployeeEntity emp,Long id) {
		boolean recordExists;
		Optional<EmployeeEntity> optEmp= employeeRepository.findById(id);
		if(optEmp.isPresent()) {
			EmployeeEntity optEmployeeEntity =optEmp.get();
			optEmployeeEntity.setEmp_Id(id);
			optEmployeeEntity.setEmpName(emp.getName());
			optEmployeeEntity.setSalary(emp.getSalary());
			optEmployeeEntity.setTitle(emp.getTitle());
			 employeeRepository.save(optEmployeeEntity);
			 recordExists =true;
			}else {
				recordExists =false;
		}
		
		return recordExists;
	}

	@Override
	public EmployeeEntity createEmployee(EmployeeEntity emp) {
		System.out.println("employee service method");
		return employeeRepository.save(emp);
		
		
     }
	
	
	public List<EmployeeEntity> findBySalaryGreaterThan(double salary){
		List<EmployeeEntity> employeeSalary = new ArrayList<>();
		try {  
			 employeeSalary=employeeRepository.findBySalarayGreater(salary);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return employeeSalary;
	}

}
