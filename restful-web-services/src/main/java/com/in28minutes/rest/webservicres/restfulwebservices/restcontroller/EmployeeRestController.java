package com.in28minutes.rest.webservicres.restfulwebservices.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.commonservicemodel.restcontroller.RESTController;
import com.in28minutes.rest.webservicres.restfulwebservices.entity.Employee;
import com.in28minutes.rest.webservicres.restfulwebservices.service.EmployeeService;
import com.in28minutes.rest.webservicres.restfulwebservices.specification.EmployeeSpec;
import com.in28minutes.rest.webservicres.restfulwebservices.vo.EmployeeVO;
import com.in28minutes.rest.webservicres.restfulwebservices.vo.filter.EmployeeFilterVO;

@RestController
public class EmployeeRestController extends RESTController<EmployeeVO, EmployeeFilterVO, EmployeeSpec, Employee, String>{

	public static final String CONTROLLER_URL = "/v1/1000";
	
	@Autowired
	private EmployeeService employeeService;
}
