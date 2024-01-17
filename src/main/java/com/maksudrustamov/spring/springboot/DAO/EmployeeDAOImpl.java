package com.maksudrustamov.spring.springboot.DAO;


import com.maksudrustamov.spring.springboot.entity.Employee;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        Session session = entityManager.unwrap(Session.class); // entityManager это обертка сессии, нужно развернуть обертку
        List<Employee> employeeList = session.createQuery("from Employee ", Employee.class).getResultList();
        return employeeList;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee employee =  session.get(Employee.class,id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);

        // Retrieve the employee by ID first
        Employee employeeToDelete = session.get(Employee.class, id);

        // Check if the employee exists
        if (employeeToDelete != null) {
            // If the employee exists, delete it
            session.delete(employeeToDelete);
        }
    }
}
// hello

















