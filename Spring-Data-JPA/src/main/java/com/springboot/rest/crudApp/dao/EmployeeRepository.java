package com.springboot.rest.crudApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rest.crudApp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
