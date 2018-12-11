package com.schwingstetter.org.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.schwingstetter.org.model.Customer;
import com.schwingstetter.org.model.Equipment;
import com.schwingstetter.org.model.Site;
import com.schwingstetter.org.repository.CustomerRepository;
import com.schwingstetter.org.repository.ProductRepository;
import com.schwingstetter.org.repository.SiteRepository;



/**
 * @author skadam
 *
 */
@Service
public class CustomerService {

	/*
	 * Get All Customer details
	 * Get All Sites of Customer
	 * Get All Site wise Products of Customer
	 * 
	 *  	
	*/
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private SiteRepository siteRepo;
	
	@Autowired
	private ProductRepository prodRepo;

	
	/**
	 * @return All Customers Details 
	 */
	public List<Customer> getAllCustomers()
	{
		List<Customer> customers=new ArrayList<>();
		
		customerRepo.findAll()
		.forEach(customers::add);
		System.out.println(customers.size());	
		return customers;		
	}
		
	/**
	 * @param customer id
	 * @return Individual Customer Details
	 */
	public Customer getById(String id)
	{
		System.out.println("Finding for "+id);
	 return customerRepo.findById(id).get();		 	
	}	
	
	/**
	 * @return Add New Customer 
	 */
	public String addCustomer(Customer customer)
	{
	 List<Site> sites=new ArrayList<>();
	 List<Equipment> prods=new ArrayList<>();
	 
	 sites=customer.getSites();
	 for(Site s:sites)
	 {
		 prods=s.getProducts();
		 
		 for(Equipment e:prods)
			 prodRepo.save(e);
		 
		 siteRepo.save(s);
	 }
		customerRepo.save(customer);
		return "added";
	}
	
	
	public String updateCustomerbySite(String id,Site site)
	{
		Customer customer=getById(id);
		
		List<Site> sites=customer.getSites();
		siteRepo.save(site);
		
		sites.add(site);		
		customer.setSites(sites);
		customerRepo.save(customer);
		return "success";
	}	
}
