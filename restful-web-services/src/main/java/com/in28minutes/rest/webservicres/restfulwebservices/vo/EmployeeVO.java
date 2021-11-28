package com.in28minutes.rest.webservicres.restfulwebservices.vo;

import java.io.Serializable;

import com.in28minutes.commonservicemodel.vo.BaseVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeVO extends BaseVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7037604768951840230L;
	private String name;
	private String dateOfBirth;
	private String gender;

}
