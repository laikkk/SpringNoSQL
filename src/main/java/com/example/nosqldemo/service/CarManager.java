package com.example.nosqldemo.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.nosqldemo.domain.Car;
import com.example.nosqldemo.repository.CarRepository;

@Component
public class CarManager {

	@Autowired
	private  CarRepository carRepository;
	
	public void addNewCar(Car car){
		carRepository.save(car);
	}
	
	public List<Car> getCars(String make){
		return carRepository.findByMake(make);
	}
	
	public List<Car> getCars(String make, String model){
		return carRepository.znajdzAuto(make, model);
	}
	
	public Car getCar(ObjectId id){
		return carRepository.findById(id);
	}
	
	
	
}
