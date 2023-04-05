package com.gl.employeeManagementSystem.service;

import java.util.List;

import com.gl.employeeManagementSystem.model.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();

	public Employee getEmployee(int id);

	public Employee updateEmployee(Employee employee);

	public Employee saveEmployee(Employee employee);

	public void deleteEmployee(int id);

}
