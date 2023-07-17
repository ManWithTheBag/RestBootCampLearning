package org.doit.restbootcamplearning;

import org.doit.restbootcamplearning.dao.EmployeeDAO;
import org.doit.restbootcamplearning.model.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"org.doit"})
public class RestBootCampLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestBootCampLearningApplication.class, args);

    }

//    @Bean
//    public CommandLineRunner printStudentById(EmployeeDAO employeeDAO){
//        return  runner -> {readStudentsList(employeeDAO);};
//    }
//
//    public void readStudentsList(EmployeeDAO employeeDAO){
//        List<Employee> studentList =  employeeDAO.getEmployeeList();
//
//        for (int i = 0; i < studentList.size(); i++){
//            System.out.println(studentList.get(i).toString());
//        }
//    }
}
