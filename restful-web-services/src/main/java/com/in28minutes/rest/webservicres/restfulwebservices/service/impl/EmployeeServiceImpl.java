package com.in28minutes.rest.webservicres.restfulwebservices.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.commonservicemodel.service.AbstractService;
import com.in28minutes.commonservicemodel.util.DateUtility;
import com.in28minutes.rest.webservicres.restfulwebservices.entity.Employee;
import com.in28minutes.rest.webservicres.restfulwebservices.repository.EmployeeRepository;
import com.in28minutes.rest.webservicres.restfulwebservices.service.EmployeeService;
import com.in28minutes.rest.webservicres.restfulwebservices.specification.EmployeeSpec;
import com.in28minutes.rest.webservicres.restfulwebservices.vo.EmployeeVO;
import com.in28minutes.rest.webservicres.restfulwebservices.vo.filter.EmployeeFilterVO;

@Service
public class EmployeeServiceImpl extends AbstractService<EmployeeVO, EmployeeFilterVO, EmployeeSpec, Employee, String>
		implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeVO applyV(Employee t) {
		EmployeeVO v = new EmployeeVO();
		v.setCreatedBy(t.getCreatedBy());
		v.setActive(t.isActive());
		v.setCreatedOn(t.getCreatedOn().toString());
		v.setDateOfBirth(t.getDateOfBirth().toString());
		v.setGender(t.getGender());
		v.setId(t.getId());
		v.setModifiedBy(t.getModifiedBy());
		v.setModifiedOn(t.getModifiedOn().toString());
		v.setName(t.getName());
		return v;
	}

	@Override
	public Employee apply(EmployeeVO v) {
		Employee t = null;
		if (v.getId() != null) {
			t = this.getTById(v.getId());
		} else {
			t = new Employee();
			t.setCreatedOn(new Date());
			t.setCreatedBy(UUID.randomUUID().toString());
		}
		t.setDateOfBirth(DateUtility.fromStringToDate(v.getDateOfBirth()));
		t.setGender(v.getGender());
//		t.setModifiedBy(t.getModifiedBy());
		t.setModifiedOn(new Date());
		t.setName(v.getName());

		return t;
	}
}
