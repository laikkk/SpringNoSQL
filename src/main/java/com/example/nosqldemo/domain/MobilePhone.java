package com.example.nosqldemo.domain;

import org.bson.types.ObjectId;

public class MobilePhone {

	private ObjectId id;
	private String brand;
	private String model;
	private Boolean hasCamera = true;
	private int batteryLifes;
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Boolean getHasCamera() {
		return hasCamera;
	}
	public void setHasCamera(Boolean hasCamera) {
		this.hasCamera = hasCamera;
	}
	public int getBatteryLifes() {
		return batteryLifes;
	}
	public void setBatteryLifes(int batteryLifes) {
		this.batteryLifes = batteryLifes;
	}

	@Override
	public String toString()
	{
		return id+" "+brand+" "+model+" "+hasCamera+" "+batteryLifes;
	}
}
