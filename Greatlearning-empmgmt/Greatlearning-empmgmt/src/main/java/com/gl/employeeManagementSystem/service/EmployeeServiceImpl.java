package com.gl.employeeManagementSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.employeeManagementSystem.dao.EmployeeDao;
import com.gl.employeeManagementSystem.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao empDao;

	public EmployeeServiceImpl(EmployeeDao empDao) {
		super();
		this.empDao = empDao;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empDao.findAll();
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return empDao.findById(id).get();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empDao.save(employee);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empDao.save(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		empDao.deleteById(id);

	}

}
