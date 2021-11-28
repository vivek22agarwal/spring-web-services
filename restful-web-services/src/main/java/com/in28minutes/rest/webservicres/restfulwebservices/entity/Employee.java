package com.in28minutes.rest.webservicres.restfulwebservices.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.in28minutes.commonservicemodel.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1396197741537331509L;
	@Column(name = "employee_name")
	private String name;
	private Date dateOfBirth;
	private String gender;

}
