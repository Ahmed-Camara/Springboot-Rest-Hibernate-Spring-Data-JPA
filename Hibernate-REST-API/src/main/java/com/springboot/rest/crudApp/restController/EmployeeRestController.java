package com.springboot.rest.crudApp.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.crudApp.entity.Employee;
import com.springboot.rest.crudApp.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
			
			return employeeService.findAll();
	}	
	
	@GetMapping("/employees/{employeeID}")
	public Employee getEmployee(@PathVariable int employeeID) {
		
		Employee employee = employeeService.findById(employeeID);
		
		if(employee == null) {
			
			throw new RuntimeException("Employee with id : "+employeeID+", not found");
		}
				
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee SaveEmployee(@RequestBody Employee employee) {
		
		employee.setId(0);
		employeeService.save(employee);
		
		return employee;
	}
	
	@DeleteMapping("/employees/{employeeID}")
	public String deleteEmployee(@PathVariable int employeeID) {
		
		Employee employee = employeeService.findById(employeeID);
		
		if(employee == null) {
			
			throw new RuntimeException("Employee with id : "+employeeID+", not found");
		}
		
		employeeService.deleteById(employeeID);
		
		return "Employee with id : "+employeeID+", deleted";
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		employeeService.save(employee);
		
		return employee;
	}
}
