package com.schwingstetter.org.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.schwingstetter.org.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String>,CustomerRepositoryCustom {

	//@Query(value="select c.cust_id,c.name from Customer c", nativeQuery = true)
	//public List<Object> getAllCustomerNames();
	
}
