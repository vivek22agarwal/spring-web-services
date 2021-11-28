package com.in28minutes.rest.webservicres.restfulwebservices.repository;

import org.springframework.stereotype.Repository;

import com.in28minutes.commonservicemodel.repository.CustomRepo;
import com.in28minutes.rest.webservicres.restfulwebservices.entity.Employee;

@Repository
public interface EmployeeRepository extends CustomRepo<Employee, String>{

}
