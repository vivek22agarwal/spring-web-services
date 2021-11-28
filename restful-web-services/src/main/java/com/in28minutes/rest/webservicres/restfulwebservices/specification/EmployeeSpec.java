package com.in28minutes.rest.webservicres.restfulwebservices.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.util.StreamUtils;

import com.in28minutes.commonservicemodel.specification.BaseSpec;
import com.in28minutes.rest.webservicres.restfulwebservices.entity.Employee;
import com.in28minutes.rest.webservicres.restfulwebservices.vo.EmployeeVO;
import com.in28minutes.rest.webservicres.restfulwebservices.vo.filter.EmployeeFilterVO;

public class EmployeeSpec extends BaseSpec<Employee, EmployeeFilterVO, EmployeeVO>{

	@Override
	public Specification<Employee> filter(EmployeeFilterVO f, Sort sort) {
		return (root, query, builder)->{
			handleSort(root,query,builder,sort);
			List<Predicate> predicates = new ArrayList<>();
			if(f!=null) {
				if(f.getId()!=null && !f.getId().isEmpty()) {
					predicates.add(builder.equal(root.<String>get("id"), f.getId()));
				}
				if(f.getCreatedBy()!=null && !f.getCreatedBy().isEmpty()) {
					predicates.add(builder.equal(root.<String>get("createdBy"), f.getCreatedBy()));
				}
				if(f.getCreatedOn()!=null && !f.getCreatedOn().isEmpty()) {
					predicates.add(builder.equal(root.<String>get("createdOn"), f.getCreatedOn()));
				}
				if(f.getDateOfBirth()!=null && !f.getDateOfBirth().isEmpty()) {
					predicates.add(builder.equal(root.<String>get("dateOfBirth"), f.getDateOfBirth()));
				}
				if(f.getGender()!=null && !f.getGender().isEmpty()) {
					predicates.add(builder.equal(root.<String>get("gender"), f.getGender()));
				}
				if(f.getName()!=null && !f.getName().isEmpty()) {
					predicates.add(builder.equal(root.<String>get("name"), f.getName()));
				}
				if(f.getModifiedBy()!=null && !f.getModifiedBy().isEmpty()) {
					predicates.add(builder.equal(root.<String>get("modifiedBy"), f.getModifiedBy()));
				}
				if(f.getModifiedOn()!=null && !f.getModifiedOn().isEmpty()) {
					predicates.add(builder.equal(root.<String>get("modifiedOn"), f.getModifiedOn()));
				}
			}
			return builder.and(predicates.toArray(new Predicate[predicates.size()]));
		};
	}

	private void handleSort(Root root, CriteriaQuery query, CriteriaBuilder builder, Sort sort) {
		List<Order> orderList = new ArrayList<>();
		if(sort != null && !sort.isUnsorted()) {
			List<Sort.Order> orders = StreamUtils.createStreamFromIterator(sort.iterator()).collect(Collectors.toList());
			for(Sort.Order order : orders) {
				switch(order.getProperty()) {
				case "modifiedBy":
					orderList.add(orderBy(root, builder, order.isAscending(), "modifiedBy"));
					break;
				case "createdBy":
					orderList.add(orderBy(root, builder, order.isAscending(), "createdBy"));
					break;
				case "modifiedOn":
					orderList.add(orderBy(root, builder, order.isAscending(), "modifiedOn"));
					break;
				case "createdOn":
					orderList.add(orderBy(root, builder, order.isAscending(), "createdOn"));
					break;
				case "name":
					orderList.add(orderBy(root, builder, order.isAscending(), "name"));
					break;
				case "gender":
					orderList.add(orderBy(root, builder, order.isAscending(), "gender"));
					break;
				case "dateOfBirth":
					orderList.add(orderBy(root, builder, order.isAscending(), "dateOfBirth"));
					break;
				default:
					orderList.add(orderBy(root, builder, order.isAscending(), "modifiedOn"));
					break;
				}
				query.groupBy(root.<Long>get("id"));
				
			}
		}else {
			query.groupBy(root.<Long>get("id"));
			orderList.add(orderBy(root, builder, false, "modifiedOn"));
		}
		query.orderBy(orderList);
		
	}

}
