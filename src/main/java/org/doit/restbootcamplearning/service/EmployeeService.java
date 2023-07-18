package org.doit.restbootcamplearning.service;

import org.doit.restbootcamplearning.dao.EmployeeDAO;
import org.doit.restbootcamplearning.model.Employee;
import org.doit.restbootcamplearning.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }



    public List<Employee> getList(){
        return employeeRepository.findAll();
    }

    public Employee getById(int id){
        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee = null;

        if(result.isPresent()){
            employee = result.get();
        }else {
            throw new RuntimeException("Employee id not found - " + id);
        }

        return employee;
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteById(int id){
        employeeRepository.deleteById(id);
    }
}
