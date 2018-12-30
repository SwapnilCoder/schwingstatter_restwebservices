package com.schwingstetter.org.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import com.schwingstetter.org.service.EquipmentService;


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
	
	@Autowired
	private EquipmentService equipmentService;
		
	@RequestMapping("/getall")
	public List<Customer> getAllCustomer()
	{
		return customerService.getAllCustomers();
	}
	
	@RequestMapping("/getnames")
	public Map<String,String> getName()
	{
		return customerService.getAllCustomerNames();
	}
	
	@RequestMapping("/get/{customerId}")
	public Customer getCustomerById(@PathVariable String customerId)
	{
		return customerService.getById(customerId);
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

	
	//****************Equipment Related Calls ******************
	
	@RequestMapping("/equipment/{equipmentId}")
	public Optional<Equipment> getEquipmentById(@PathVariable String equipmentId)
	{
		return equipmentService.getEquipmentById(equipmentId);
	}
	
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
	
		List<Equipment> equipments=new ArrayList<>(Arrays.asList(new Equipment("P111","FGV - BP 350","Trailer Pumps","Ty-321","9383723","Y","2018-10-12"),
																new Equipment("P112","NIMO","Truck Mixer","Ty-301","9392724","Y","2016-10-12"),
																new Equipment("P113","SLM-2200","Self Loading Mixer","Ty-421","8380823","Y","2017-10-12")));
		List<Equipment> equipments01_2=new ArrayList<>(Arrays.asList(new Equipment("P121","FGV - BP 350","Trailer Pumps","Ty-321","9383723","Y","2018-10-12"),
				new Equipment("P122","NIMO","Truck Mixer","Ty-301","9392724","Y","2016-10-12")));
		
		List<Site> sites=new ArrayList<>(Arrays.asList(new Site("S110", "Waghale Estate", "Thane", "Digender Mahara", "9362539483", equipments),
														new Site("S120", "Andheri West", "Mumbai", "Swapnil Kadam", "9762539483", equipments01_2)));
				
		for(Equipment e:equipments)		
			product_repo.save(e);
				
		for(Equipment e:equipments01_2)		
			product_repo.save(e);
		
		for(Site s:sites)
			site_repo.save(s);
		
		customer_repo.save(new Customer("C100","L&T Infra Ltd",823876,765342,"Digender Mahara","9876539273",sites));
		
		
		//Second Customer Details
		
		List<Equipment> equipments_02=new ArrayList<>(Arrays.asList(new Equipment("P211","FGV - BP 350","Trailer Pumps","Ty-321","9383723","Y","2018-10-12"),
				new Equipment("P212","NIMO","Truck Mixer","Ty-301","9392724","Y","2016-10-12")));

List<Site> sites_02=new ArrayList<>(Arrays.asList(new Site("S210", "Kharadi Bypass", "Pune", "Swapnil Kadam", "9362539483", equipments_02)));

for(Equipment e:equipments_02)		
product_repo.save(e);

for(Site s:sites_02)
site_repo.save(s);

customer_repo.save(new Customer("C200","Godrej Infra Ltd",823876,765342,"Swapnil Kadam","9876539273",sites_02));

		
	}	

}
