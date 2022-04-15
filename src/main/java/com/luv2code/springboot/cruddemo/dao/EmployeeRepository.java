package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // <Employee, Integer>  -> <Entity type, Primary Key>


    // that's it ... no need to write any code LOL!
    // No need of any implementation class
    // Magic of Spring Data JPA
}
