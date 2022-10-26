package com.novatesoft.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.novatesoft.springboot.pojo.Employee;
import com.novatesoft.springboot.pojo.EmployeeEntity;
import com.novatesoft.springboot.service.EmployeeService;
import com.novatesoft.springboot.service.EmployeeServiceImp;

@RestController

public class EmployeeController {
	
@Autowired	
private  EmployeeService employeeService;

    @GetMapping("/all")
   public List<EmployeeEntity>  getEmployees(){
         System.out.println("controllee getEmployee method");
		List<EmployeeEntity> empList = new ArrayList<>();
		empList=employeeService.getAllEmployees();
		return empList;
	}
	
	@PostMapping("/createEmployee/")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeEntity employee){
		boolean created = true;
		System.out.println(employee.toString());
		employeeService.createEmployee(employee);
		
		return new ResponseEntity<>(employee, HttpStatus.CREATED);
    	
    }
	
	@PutMapping("/updateEmployee/{empid}")
	public ResponseEntity<?>  updateEmployee(@RequestBody EmployeeEntity employee,
			                                 @PathVariable("empid") String empID){
		System.out.println("the id is"+empID);
		boolean updated= employeeService.updateEmployee(employee,Long.parseLong(empID));
		 if(updated) {
			 return new ResponseEntity<>("employee record updated",HttpStatus.FOUND);
		 }else {
			 return new ResponseEntity<>("employee record not found ",HttpStatus.NOT_FOUND);
		 }
		
	    }
	
	
	@DeleteMapping("/delete/{empid}")
	public String deleteEmployee(@PathVariable("empid") String empID) {
		employeeService.deleteEmployee(Long.parseLong(empID));
		
		return"Employee with "+empID+"is deleted";
	}
	
      @GetMapping("getAllEmp/salary-stats")
	   public List<EmployeeEntity> getEmployeeSalary(@RequestParam ("salary-greater-than") String salary) {
    	 List<EmployeeEntity> empSalaryList = new ArrayList<>();
	      try {
		   empSalaryList= employeeService.findBySalaryGreaterThan(Double.parseDouble(salary));
	   } catch (NumberFormatException e) {
		e.printStackTrace();
	    } catch (Exception e) {
		  e.printStackTrace();
	    }
	   
	   	return empSalaryList;
	   
	   
   }
	
	
}
