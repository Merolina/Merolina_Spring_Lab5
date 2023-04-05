package com.gl.employeeManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.employeeManagementSystem.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

}
