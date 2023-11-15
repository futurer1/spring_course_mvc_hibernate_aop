package com.mikhail.spring.mvc_hibernate_aop.service;

import com.mikhail.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public void delEmployee(int empId);

    public Employee getEmployee(int empId);
}
