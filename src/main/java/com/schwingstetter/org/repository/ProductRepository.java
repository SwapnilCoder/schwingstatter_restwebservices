package com.schwingstetter.org.repository;

import org.springframework.data.repository.CrudRepository;

import com.schwingstetter.org.model.Equipment;

public interface ProductRepository extends CrudRepository<Equipment, String> {

}
