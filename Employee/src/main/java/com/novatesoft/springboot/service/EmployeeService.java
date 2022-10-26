package com.novatesoft.springboot.service;

import java.util.List;

import com.novatesoft.springboot.pojo.Employee;
import com.novatesoft.springboot.pojo.EmployeeEntity;

public interface EmployeeService {
	
	List<EmployeeEntity> getAllEmployees();
	void  deleteEmployee(Long empid);
	boolean updateEmployee(EmployeeEntity e,Long empid);
	EmployeeEntity createEmployee(EmployeeEntity emp);
	List<EmployeeEntity>findBySalaryGreaterThan(double salary);
	
	

}
