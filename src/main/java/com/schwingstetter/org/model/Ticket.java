package com.schwingstetter.org.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ticket {

	@Id
	String ticketId;	
	String customer_id;	
	String custmer_name;	
	String site_id;	
	String site_name;
	String problem_desc;
	String contact_person;
	String contact_number;
	String status;
	String remark;
	
	Date ticket_date;
	
	Date visit_date;

	public Ticket(String ticketId, String customer_id, String custmer_name, String site_id, String site_name,
			Date ticket_date, Date visit_date) {
		super();
		this.ticketId = ticketId;
		this.customer_id = customer_id;
		this.custmer_name = custmer_name;
		this.site_id = site_id;
		this.site_name = site_name;
		this.ticket_date = ticket_date;
		this.visit_date = visit_date;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustmer_name() {
		return custmer_name;
	}

	public void setCustmer_name(String custmer_name) {
		this.custmer_name = custmer_name;
	}

	public String getSite_id() {
		return site_id;
	}

	public void setSite_id(String site_id) {
		this.site_id = site_id;
	}

	public String getSite_name() {
		return site_name;
	}

	public void setSite_name(String site_name) {
		this.site_name = site_name;
	}

	public Date getTicket_date() {
		return ticket_date;
	}

	public void setTicket_date(Date ticket_date) {
		this.ticket_date = ticket_date;
	}

	public Date getVisit_date() {
		return visit_date;
	}

	public void setVisit_date(Date visit_date) {
		this.visit_date = visit_date;
	}
	
	
	
}
