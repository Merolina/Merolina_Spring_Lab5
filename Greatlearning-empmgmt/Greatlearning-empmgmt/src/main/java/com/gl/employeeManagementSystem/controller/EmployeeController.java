package com.gl.employeeManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.employeeManagementSystem.model.Employee;
import com.gl.employeeManagementSystem.service.EmployeeService;

@Controller
@RequestMapping("employees")
public class EmployeeController {
	EmployeeService empService;
	
	 
	public EmployeeController(EmployeeService empService) {
		super();
		this.empService = empService;
	}


	@GetMapping("/list")
	public String showEmpList(Model model) {
		model.addAttribute("emps", empService.getAllEmployees());
		return "employee-list";
	}

	@GetMapping("/create-emp")
	public String createEmp(Model model) {
		model.addAttribute("employee", new Employee());
		return "employee";
	}
	
	@PostMapping("/saveEmp")
	public String saveEmp(Model model,@ModelAttribute("employee") Employee employee ) {
	empService.saveEmployee(employee);	
	return "redirect:/employees/list"; 	
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(Model model, @PathVariable int id) {
		empService.deleteEmployee(id);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/update/{id}")
	public String editemployeeForm(@PathVariable int id, Model model) {
		model.addAttribute("employee", empService.getEmployee(id));
		return "edit_employee";
	}

	@PostMapping("/{id}")
	public String updateemployee(@PathVariable int id, @ModelAttribute("employee") Employee employee, Model model) {

		// get employee from database by id

		Employee existingEmployee = empService.getEmployee(id);
		existingEmployee.setId(id);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());

		// save updated employee object
		empService.updateEmployee(existingEmployee);

		return "redirect:/employees/list";
	}

}
