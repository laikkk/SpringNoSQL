package com.example.nosqldemo.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.nosqldemo.domain.MobilePhone;

public interface MobilePhoneRepository extends CrudRepository<MobilePhone, ObjectId>{
	
	List<MobilePhone> findByModel(String model);
	
	List<MobilePhone> findBybatteryLifes(int batteryLifes);
	
	@Query(value = "{ 'brand' : ?0, 'model' : ?1 }" )
	List<MobilePhone> znajdzTelefon(String brand, String model);
	
	MobilePhone findById(ObjectId id);

}
