package com.novatesoft.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
private String empId;
public String getEmpId() {
	return empId;
}
public void setEmpId(String empId) {
	this.empId = empId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
private String name;
private String salary;
private String title;


public Employee(String empId, String name, String salary, String title) {
	super();
	this.empId = empId;
	this.name = name;
	this.salary = salary;
	this.title = title;
}



}
