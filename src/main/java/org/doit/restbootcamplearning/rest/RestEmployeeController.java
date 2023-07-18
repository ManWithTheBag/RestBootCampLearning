package org.doit.restbootcamplearning.rest;

import org.doit.restbootcamplearning.model.Employee;
import org.doit.restbootcamplearning.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestEmployeeController {

    private EmployeeService employeeService;
    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String home(){
        return "Home";
    }

    @GetMapping("/employees")
    public List<Employee> getEmployeesList(){
        return employeeService.getList();
    }

    @GetMapping("/employees/{employeeid}")
    public Employee getEmployeeById(@PathVariable int employeeid){
        return employeeService.getById(employeeid);
    }

    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeid}")
    public String deleteEmployee(@PathVariable int employeeid){
        employeeService.deleteById(employeeid);

        return "Deleted employee with id - " + employeeid;
    }
}
