package com.springboot.rest.crudApp.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.rest.crudApp.dao.EmployeeRepository;
import com.springboot.rest.crudApp.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee employee = null;
		
		if(result.isPresent()) {
			
			employee = result.get();
		}else {
			
			throw new RuntimeException("Did not find employee id -"+id);
		}
		return employee;
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
		
	}

}
