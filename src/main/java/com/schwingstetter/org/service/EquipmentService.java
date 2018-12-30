package com.schwingstetter.org.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schwingstetter.org.model.Equipment;
import com.schwingstetter.org.repository.ProductRepository;

@Service
public class EquipmentService {

	@Autowired
	private ProductRepository productRepo;
	
	public Optional<Equipment> getEquipmentById(String equipmentId)
	{
		
		return productRepo.findById(equipmentId);
		
		
	}
	
}
