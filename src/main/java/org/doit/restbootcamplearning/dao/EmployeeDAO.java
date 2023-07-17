package org.doit.restbootcamplearning.dao;

import jakarta.persistence.EntityManager;
import org.doit.restbootcamplearning.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDAO {

    private EntityManager entityManager;
    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Employee> getList(){
        return entityManager.createQuery("from Employee", Employee.class).getResultList();
    }

    public Employee getById(int id){
        Employee employee = entityManager.find(Employee.class, id);

        if (employee == null){
            throw new RuntimeException("Employee id not found - " + id);
        }

        return employee;
    }

    public void add(Employee employee){
        entityManager.persist(employee);
    }

    public Employee update(Employee employee){
        Employee dbEmployee = entityManager.merge(employee);
        return  dbEmployee;
    }

    public void deleteById(int id){
        Employee currentEmployee = getById(id);
        entityManager.remove(currentEmployee);
    }


}
