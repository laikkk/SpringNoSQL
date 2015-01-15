package com.example.nosqldemo.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.nosqldemo.domain.MobilePhone;
import com.example.nosqldemo.domain.Owner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
public class OwnerManagerTest {
	
	@Autowired
	OwnerRepository ownerManager;
	@Autowired
	MobilePhoneRepository mobilePhoneRepository;
	
	private final String NAME_1 = "Krzysztof";
	private final String SURNAME_1 = "Nowak";
	private final int AGE_1 = 22;
	private final String CITY_1 = "Gdansk";
	
	private final String NAME_2 = "John";
	private final String SURNAME_2 = "Smith";
	private final int AGE_2 = 33;
	private final String CITY_2 = "Gdansk";
	
	private final String NAME_3 = "Mark";
	private final String SURNAME_3 = "Albert";
	private final int AGE_3 = 44;
	private final String CITY_3 = "Gdansk";

	private final String BRAND_1 = "Samsung";
	private final String MODEL_1 = "galaxy S5";
	private final Boolean HAS_CAMERA_1 = true;
	private final int BATTERY_LIFE_1 = 3;

	private final String BRAND_2 = "Nokia";
	private final String MODEL_2 = "3330";
	private final Boolean HAS_CAMERA_2 = false;
	private final int BATTERY_LIFE_2 = 10;

	private final String BRAND_3 = "Windows Lumia";
	private final String MODEL_3 = "735";
	private final Boolean HAS_CAMERA_3 = true;
	private final int BATTERY_LIFE_3 = 4;
	
	@Test
	public void checkAdding(){
		
		Owner p1 = new Owner();
		p1.setName("Gosia");
		
		MobilePhone c1 = new MobilePhone();
		c1.setBrand("Toyota");
		c1.setModel("Yaris");
		mobilePhoneRepository.save(c1);
		
		
		MobilePhone c2 = new MobilePhone();
		c2.setBrand("Honda");
		c2.setModel("Accord");
		mobilePhoneRepository.save(c2);
		
		List<MobilePhone> mobilePhones = new ArrayList<MobilePhone>();
		mobilePhones.add(c1);
		mobilePhones.add(c2);
		
		p1.setMobilephones(mobilePhones);
		
		
		ownerManager.save(p1);
		
		Owner aGirl = ownerManager.findById(p1.getId());
		
		assertEquals(2, aGirl.getMobilephones().size());
		
		
	}
	
//	@Test
//	public void check(){
//		
//		Owner p1 = new Owner();
//		p1.setName("Gosia");
//		
//		MobilePhone c1 = new MobilePhone();
//		c1.setBrand("Toyota");
//		c1.setModel("Yaris");
//		mobilePhoneRepository.save(c1);
//		
//		
//		MobilePhone c2 = new MobilePhone();
//		c2.setBrand("Honda");
//		c2.setModel("Accord");
//		mobilePhoneRepository.save(c2);
//		
//		List<MobilePhone> mobilePhones = new ArrayList<MobilePhone>();
//		mobilePhones.add(c1);
//		mobilePhones.add(c2);
//		
//		p1.setMobilephones(mobilePhones);
//		
//		
//		ownerManager.save(p1);
//		
//		List<MobilePhone> mobilePhonesFromOwner = ownerManager.findMobilePhonesById(p1.getId());
//		
//		assertEquals(2, mobilePhonesFromOwner.size());
//		
//		
//	}

}
