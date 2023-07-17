package org.doit.restbootcamplearning.service;

import org.doit.restbootcamplearning.dao.EmployeeDAO;
import org.doit.restbootcamplearning.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    private EmployeeDAO employeeDAO;
    @Autowired
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    public List<Employee> getList(){
        return employeeDAO.getList();
    }

    public Employee getById(int id){
        return employeeDAO.getById(id);
    }

    public void add(Employee employee){
        employeeDAO.add(employee);
    }

    public Employee update(Employee employee){
        return employeeDAO.update(employee);
    }

    public void deleteById(int id){
        employeeDAO.deleteById(id);
    }
}
