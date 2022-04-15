package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    // set up constructor injection to connect with EmployeeDAO class
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }

    // Note:
    // Here, Spring doesn't know which DAO Impl to use... so here we defined Qualifier with bean id(employeeDaoJpaImpl)


    @Override
    public List<Employee> findAll() {

        // simply delegate the calls to the DAO
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if (result.isPresent()){
            theEmployee = result.get();
        }
        else {
            // we didn't find a employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {

        employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {

        employeeRepository.deleteById(theId);
    }
}
