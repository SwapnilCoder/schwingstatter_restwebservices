package com.schwingstetter.org.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schwingstetter.org.model.Customer;
import com.schwingstetter.org.model.Equipment;
import com.schwingstetter.org.model.Site;
import com.schwingstetter.org.repository.CustomerRepository;
import com.schwingstetter.org.repository.ProductRepository;
import com.schwingstetter.org.repository.SiteRepository;
import com.schwingstetter.org.service.CustomerService;


@RestController
@RequestMapping("/customer")
public class MainApplicationController implements InitializingBean 
{
	@Autowired
	private CustomerRepository customer_repo;
	@Autowired
	private SiteRepository site_repo;
	@Autowired
	private ProductRepository product_repo;
	
	@Autowired
	private CustomerService customerService;
		
	@RequestMapping("/getall")
	public List<Customer> getAllCustomer()
	{
		return customerService.getAllCustomers();
	}
	
	@RequestMapping("/get")
	public Customer getCustomerById()
	{
		return customerService.getById("C001");
	}
	
	@PostMapping	
	@RequestMapping("/add")
	public String addCustomer(@RequestBody Customer customer)
	{
		System.out.println();
		return customerService.addCustomer(customer);
	}
	
	@PutMapping
	@RequestMapping("/updateSite/{customerId}")
	public String updateCustomerbySite(@PathVariable String customerId,@RequestBody Site site)
	{
		return customerService.updateCustomerbySite(customerId, site);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
	
		List<Equipment> equipments=new ArrayList<>(Arrays.asList(new Equipment("P001","FGV - BP 350","Trailer Pumps","Ty-321","9383723","Y","2018-10-12"),
																new Equipment("P002","NIMO","Truck Mixer","Ty-301","9392724","Y","2016-10-12"),
																new Equipment("P003","SLM-2200","Self Loading Mixer","Ty-421","8380823","Y","2017-10-12")));
	
		List<Site> sites=new ArrayList<>(Arrays.asList(new Site("S001", "Site Location01", "Mumbai", "Site_CP01", "9362539483", equipments)));
		/*product_repo.save(new Equipment("P001","FGV - BP 350","Trailer Pumps","Ty-321","9383723","Y","2018-10-12"));
		product_repo.save(new Equipment("P002","NIMO","Truck Mixer","Ty-301","9392724","Y","2016-10-12"));
		product_repo.save(new Equipment("P003","SLM-2200","Self Loading Mixer","Ty-421","8380823","Y","2017-10-12"));*/
		
		for(Equipment e:equipments)		
			product_repo.save(e);
				
		for(Site s:sites)
			site_repo.save(s);
		
		customer_repo.save(new Customer("C001","CustomerName01",823876,765342,"ContactPerson01","9876539273",sites));
	}	

}
