package com.example.nosqldemo.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import com.example.nosqldemo.domain.Person;

public interface PersonRepository extends CrudRepository<Person, ObjectId> {
	
	List<Person> findByName(String name);
	
	Person findById(ObjectId id);

}
