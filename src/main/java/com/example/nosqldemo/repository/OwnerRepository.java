package com.example.nosqldemo.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import com.example.nosqldemo.domain.MobilePhone;
import com.example.nosqldemo.domain.Owner;

public interface OwnerRepository extends CrudRepository<Owner, ObjectId> {
	
	List<Owner> findByName(String name);
	
	Owner findById(ObjectId id);
	
}
