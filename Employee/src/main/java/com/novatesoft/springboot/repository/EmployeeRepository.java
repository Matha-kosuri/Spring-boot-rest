package com.novatesoft.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.novatesoft.springboot.pojo.EmployeeEntity;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
	
	@Query(value = "SELECT e FROM EmployeeEntity e where e.salary > :salary")
	List<EmployeeEntity> findBySalarayGreater(@Param("salary") double salary);
	
	
	
	
	
}
