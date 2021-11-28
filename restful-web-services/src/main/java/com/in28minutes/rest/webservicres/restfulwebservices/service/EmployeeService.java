package com.in28minutes.rest.webservicres.restfulwebservices.service;

import com.in28minutes.commonservicemodel.service.GenericService;
import com.in28minutes.rest.webservicres.restfulwebservices.entity.Employee;
import com.in28minutes.rest.webservicres.restfulwebservices.specification.EmployeeSpec;
import com.in28minutes.rest.webservicres.restfulwebservices.vo.EmployeeVO;
import com.in28minutes.rest.webservicres.restfulwebservices.vo.filter.EmployeeFilterVO;

public interface EmployeeService extends GenericService<EmployeeVO, EmployeeFilterVO, EmployeeSpec, Employee, String>{

}
