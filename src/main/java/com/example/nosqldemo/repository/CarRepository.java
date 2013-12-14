package com.example.nosqldemo.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.nosqldemo.domain.Car;

public interface CarRepository extends CrudRepository<Car, ObjectId>{
	
	List<Car> findByMake(String make);
	
	List<Car> findByYop(int yop);
	
	@Query(value = "{ 'make' : ?0, 'model' : ?1 }" )
	List<Car> znajdzAuto(String make, String model);
	
	Car findById(ObjectId id);

}
