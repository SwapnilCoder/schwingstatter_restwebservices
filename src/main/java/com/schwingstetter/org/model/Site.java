package com.schwingstetter.org.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Site {

	@Id
	String site_id;
	String name;
	String address;
	String contact_person;
	String contact_number;
	
	@OneToMany(targetEntity=Equipment.class)
	List<Equipment> products;
		
	public Site() {	}
		
	public Site(String site_id, String name, String address, String contact_person, String contact_number,
			List<Equipment> products) {
		super();
		this.site_id = site_id;
		this.name = name;
		this.address = address;
		this.contact_person = contact_person;
		this.contact_number = contact_number;
		this.products = products;
	}
	public String getSite_id() {
		return site_id;
	}
	public void setSite_id(String site_id) {
		this.site_id = site_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public List<Equipment> getProducts() {
		return products;
	}
	public void setProducts(List<Equipment> products) {
		this.products = products;
	}
	
	
	
}

