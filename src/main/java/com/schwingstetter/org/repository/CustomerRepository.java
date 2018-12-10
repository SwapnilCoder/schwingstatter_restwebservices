package com.schwingstetter.org.repository;

import org.springframework.data.repository.CrudRepository;

import com.schwingstetter.org.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {

}
