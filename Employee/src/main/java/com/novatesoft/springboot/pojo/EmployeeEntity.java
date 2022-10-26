package com.novatesoft.springboot.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.id.CompositeNestedGeneratedValueGenerator.GenerationContextLocator;

import lombok.Data;

@Entity
@Table(name="employee_info", schema="employees")
public class EmployeeEntity {
	@Id
	private Long emp_Id;
	private String name;
	private double salary;
	private String title;
	
	public Long getEmp_Id() {
		return emp_Id;
	}
	public void setEmp_Id(Long emp_Id) {
		this.emp_Id = emp_Id;
	}
	public String getName() {
		return name;
	}
	public void setEmpName(String empName) {
		this.name = empName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "EmployeeEntity [emp_Id=" + emp_Id + ", name=" + name + ", salary=" + salary + ", title=" + title + "]";
	}
	

}