package com.helpdesk.backend.apirest.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private com.helpdesk.backend.apirest.models.services.IEmployeeService employeeService;

	@GetMapping("/employees")
	public List<com.helpdesk.backend.apirest.models.entity.Employee> index() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{id}")
	public com.helpdesk.backend.apirest.models.entity.Employee show(@PathVariable Long id) {
		return this.employeeService.findById(id);
	}

	@PostMapping("/employees")
	@ResponseStatus(HttpStatus.CREATED)
	public com.helpdesk.backend.apirest.models.entity.Employee create(@RequestBody com.helpdesk.backend.apirest.models.entity.Employee employee) {
		employee.setCreateAt(new Date());
		this.employeeService.save(employee);
		return employee;
	}

	@PutMapping("/employees/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public com.helpdesk.backend.apirest.models.entity.Employee update(@RequestBody com.helpdesk.backend.apirest.models.entity.Employee employee, @PathVariable Long id) {
		com.helpdesk.backend.apirest.models.entity.Employee currentEmployee = this.employeeService.findById(id);
		currentEmployee.setFname(employee.getFname());
		currentEmployee.setLname(employee.getLname());
		currentEmployee.setEmail(employee.getEmail());
		this.employeeService.save(currentEmployee);
		return currentEmployee;
	}

	@DeleteMapping("/employees/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		com.helpdesk.backend.apirest.models.entity.Employee currentEmployee = this.employeeService.findById(id);
		this.employeeService.delete(currentEmployee);
	}
}
