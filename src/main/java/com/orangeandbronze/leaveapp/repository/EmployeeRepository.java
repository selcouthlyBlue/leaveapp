package com.orangeandbronze.leaveapp.repository;

import java.util.Collection;

import com.orangeandbronze.leaveapp.domain.Employee;

public interface EmployeeRepository {
	
	public Employee findBy(int employeeId);
	
	public Collection<Employee> findAll();
	
	public Collection<Employee> findAllSupervisors();
	
	public void update(Employee employee);
	
	public void create(Employee employee);
}
