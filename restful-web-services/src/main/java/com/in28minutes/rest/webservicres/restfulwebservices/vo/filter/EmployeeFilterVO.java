package com.in28minutes.rest.webservicres.restfulwebservices.vo.filter;

import com.in28minutes.commonservicemodel.filter.BaseFilter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeFilterVO extends BaseFilter{
	
	private String name;
	private String dateOfBirth;
	private String gender;

}
