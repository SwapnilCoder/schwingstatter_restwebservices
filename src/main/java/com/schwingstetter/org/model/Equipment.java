package com.schwingstetter.org.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Equipment {

	@Id
	String equipment_id;
	String model_number;
	String equipment_name;
	String equipment_type;
	String equipment_seven_digit_code;
	String sold_to_party;	
	String date_of_purchase;
		
		
	public Equipment() {}
	
	public Equipment(String equipment_id, String model_number, String equipment_name, String equipment_type,
			String equipment_seven_digit_code, String sold_to_party, String date_of_purchase) {
		super();
		this.equipment_id = equipment_id;
		this.model_number = model_number;
		this.equipment_name = equipment_name;
		this.equipment_type = equipment_type;
		this.equipment_seven_digit_code = equipment_seven_digit_code;
		this.sold_to_party = sold_to_party;
		this.date_of_purchase = date_of_purchase;
	}
	public String getEquipment_id() {
		return equipment_id;
	}
	public void setEquipment_id(String equipment_id) {
		this.equipment_id = equipment_id;
	}
	public String getModel_number() {
		return model_number;
	}
	public void setModel_number(String model_number) {
		this.model_number = model_number;
	}
	public String getEquipment_name() {
		return equipment_name;
	}
	public void setEquipment_name(String equipment_name) {
		this.equipment_name = equipment_name;
	}
	public String getEquipment_type() {
		return equipment_type;
	}
	public void setEquipment_type(String equipment_type) {
		this.equipment_type = equipment_type;
	}
	public String getEquipment_seven_digit_code() {
		return equipment_seven_digit_code;
	}
	public void setEquipment_seven_digit_code(String equipment_seven_digit_code) {
		this.equipment_seven_digit_code = equipment_seven_digit_code;
	}
	public String getSold_to_party() {
		return sold_to_party;
	}
	public void setSold_to_party(String sold_to_party) {
		this.sold_to_party = sold_to_party;
	}
	public String getDate_of_purchase() {
		return date_of_purchase;
	}
	public void setDate_of_purchase(String date_of_purchase) {
		this.date_of_purchase = date_of_purchase;
	}
	
	
	
	
}
