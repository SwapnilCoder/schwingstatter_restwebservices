package com.schwingstetter.org.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	String cust_id;	
	String name;	
	long sold_to_party_code;
	long ship_to_party_code;
	String contact_person;
	String contact_number;

	@OneToMany(targetEntity=Site.class)
	List<Site> sites;
	
	public Customer(){}

	public Customer(String cust_id, String name, long sold_to_party_code, long ship_to_party_code,
			String contact_person, String contact_number, List<Site> sites) {
		super();
		this.cust_id = cust_id;
		this.name = name;
		this.sold_to_party_code = sold_to_party_code;
		this.ship_to_party_code = ship_to_party_code;
		this.contact_person = contact_person;
		this.contact_number = contact_number;
		this.sites = sites;
	}




	public List<Site> getSites() {
		return sites;
	}



	public void setSites(List<Site> sites) {
		this.sites = sites;
	}



	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public long getSold_to_party_code() {
		return sold_to_party_code;
	}

	public void setSold_to_party_code(long sold_to_party_code) {
		this.sold_to_party_code = sold_to_party_code;
	}

	public long getShip_to_party_code() {
		return ship_to_party_code;
	}

	public void setShip_to_party_code(long ship_to_party_code) {
		this.ship_to_party_code = ship_to_party_code;
	}

	public String getContact_person() {
		return contact_person;
	}

	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}	
}
