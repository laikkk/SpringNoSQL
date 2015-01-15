package com.example.nosqldemo.domain;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.example.nosqldemo.domain.MobilePhone;

public class Owner {

	private ObjectId id;
	private String Name;
	private String Surname;
	private int Age;
	private String City;	
	private List<MobilePhone> mobilephones = new ArrayList<MobilePhone>();
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSurname() {
		return Surname;
	}
	public void setSurname(String surname) {
		Surname = surname;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public List<MobilePhone> getMobilephones() {
		return mobilephones;
	}
	public void setMobilephones(List<MobilePhone> mobilephones) {
		this.mobilephones = mobilephones;
	}
	
	
}
