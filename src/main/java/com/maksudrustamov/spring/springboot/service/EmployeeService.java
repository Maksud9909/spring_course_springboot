package com.maksudrustamov.spring.springboot.service;



import com.maksudrustamov.spring.springboot.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

   public void deleteEmployee(int id);
}
