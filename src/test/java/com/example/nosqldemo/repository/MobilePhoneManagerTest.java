package com.example.nosqldemo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.nosqldemo.domain.MobilePhone;
import com.example.nosqldemo.domain.Owner;
import com.example.nosqldemo.service.OwnerMobilePhoneManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
public class MobilePhoneManagerTest {

	private final String NAME_1 = "Krzysztof";
	private final String SURNAME_1 = "Nowak";
	private final int AGE_1 = 22;
	private final String CITY_1 = "Gdansk";

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

	@Autowired
	OwnerMobilePhoneManager ownerMobilePhoneManager;
	@Autowired
	//OwnerRepository ownerManager;

	// START CRUD FOR MOBILEPHONE Entity
	@Test
	public void addMobilePhoneCheck() {
		MobilePhone mobilePhone = new MobilePhone();
		mobilePhone.setBrand(BRAND_1);
		mobilePhone.setModel(MODEL_1);
		mobilePhone.setHasCamera(HAS_CAMERA_1);
		mobilePhone.setBatteryLifes(BATTERY_LIFE_1);

		mobilePhone = ownerMobilePhoneManager.addMobilePhone(mobilePhone);

		MobilePhone retrievedMobilePhone = ownerMobilePhoneManager
				.getMobilePhoneById(mobilePhone.getId());

		assertEquals(BRAND_1, retrievedMobilePhone.getBrand());
		assertEquals(MODEL_1, retrievedMobilePhone.getModel());
		assertEquals(HAS_CAMERA_1, retrievedMobilePhone.getHasCamera());
		assertEquals(BATTERY_LIFE_1, retrievedMobilePhone.getBatteryLifes());
	}

	@Test
	public void getAllMobilePhonesCheck() {

		int iloscPrzedDodaniem = ownerMobilePhoneManager.getAllMobilePhones().size();
		MobilePhone mobilePhone = new MobilePhone();
		mobilePhone.setBrand(BRAND_1);
		mobilePhone.setModel(MODEL_1);
		mobilePhone.setHasCamera(HAS_CAMERA_1);
		mobilePhone.setBatteryLifes(BATTERY_LIFE_1);

		ownerMobilePhoneManager.addMobilePhone(mobilePhone);

		mobilePhone = new MobilePhone();
		mobilePhone.setBrand(BRAND_2);
		mobilePhone.setModel(MODEL_2);
		mobilePhone.setHasCamera(HAS_CAMERA_2);
		mobilePhone.setBatteryLifes(BATTERY_LIFE_2);

		ownerMobilePhoneManager.addMobilePhone(mobilePhone);

		mobilePhone = new MobilePhone();
		mobilePhone.setBrand(BRAND_3);
		mobilePhone.setModel(MODEL_3);
		mobilePhone.setHasCamera(HAS_CAMERA_3);
		mobilePhone.setBatteryLifes(BATTERY_LIFE_3);

		ownerMobilePhoneManager.addMobilePhone(mobilePhone);

		List<MobilePhone> retrievedMobilePhones = ownerMobilePhoneManager
				.getAllMobilePhones();

		assertEquals(iloscPrzedDodaniem + 3, retrievedMobilePhones.size());
	}

	@Test
	public void getMobilePhoneByIdCheck() {
		ownerMobilePhoneManager.deleteAllMobilePhones();

		MobilePhone mobilePhone = new MobilePhone();
		mobilePhone.setBrand(BRAND_1);
		mobilePhone.setModel(MODEL_1);
		mobilePhone.setHasCamera(HAS_CAMERA_1);
		mobilePhone.setBatteryLifes(BATTERY_LIFE_1);

		mobilePhone = ownerMobilePhoneManager.addMobilePhone(mobilePhone);

		MobilePhone mobilephones = ownerMobilePhoneManager.getMobilePhoneById(mobilePhone
				.getId());

		assertEquals(BRAND_1, mobilephones.getBrand());
		assertEquals(MODEL_1, mobilephones.getModel());
		assertEquals(HAS_CAMERA_1, mobilephones.getHasCamera());
		assertEquals(BATTERY_LIFE_1, mobilephones.getBatteryLifes());
	}

	@Test
	public void updateMobilePhoneCheck() {
		ownerMobilePhoneManager.deleteAllMobilePhones();

		MobilePhone mobilePhone = new MobilePhone();
		mobilePhone.setBrand(BRAND_1);
		mobilePhone.setModel(MODEL_1);
		mobilePhone.setHasCamera(HAS_CAMERA_1);
		mobilePhone.setBatteryLifes(BATTERY_LIFE_1);

		mobilePhone = ownerMobilePhoneManager.addMobilePhone(mobilePhone);

		MobilePhone newMobilePhone = new MobilePhone();
		newMobilePhone.setBrand(BRAND_2);
		newMobilePhone.setModel(MODEL_2);
		newMobilePhone.setHasCamera(HAS_CAMERA_2);
		newMobilePhone.setBatteryLifes(BATTERY_LIFE_2);

		ownerMobilePhoneManager.updateMobilePhone(mobilePhone, newMobilePhone);

		MobilePhone retrievedNewMobilePhone = ownerMobilePhoneManager
				.getMobilePhoneById(mobilePhone.getId());

		assertEquals(BRAND_2, retrievedNewMobilePhone.getBrand());
		assertEquals(MODEL_2, retrievedNewMobilePhone.getModel());
		assertEquals(HAS_CAMERA_2, retrievedNewMobilePhone.getHasCamera());
		assertEquals(BATTERY_LIFE_2, retrievedNewMobilePhone.getBatteryLifes());
	}

	@Test
	public void deleteAllMobilePhoneCheck() {
		ownerMobilePhoneManager.deleteAllMobilePhones();

		MobilePhone mobilePhone = new MobilePhone();
		mobilePhone.setBrand(BRAND_1);
		mobilePhone.setModel(MODEL_1);
		mobilePhone.setHasCamera(HAS_CAMERA_1);
		mobilePhone.setBatteryLifes(BATTERY_LIFE_1);

		mobilePhone = ownerMobilePhoneManager.addMobilePhone(mobilePhone);
		assertEquals(ownerMobilePhoneManager.getAllMobilePhones().size(), 1);
		ownerMobilePhoneManager.deleteMobilePhone(mobilePhone);

		assertEquals(ownerMobilePhoneManager.getAllMobilePhones().size(), 0);
	}

	@Test
	public void deleteMobilePhoneByObjectIdCheck() {
		ownerMobilePhoneManager.deleteAllMobilePhones();

		MobilePhone mobilePhone = new MobilePhone();
		mobilePhone.setBrand(BRAND_1);
		mobilePhone.setModel(MODEL_1);
		mobilePhone.setHasCamera(HAS_CAMERA_1);
		mobilePhone.setBatteryLifes(BATTERY_LIFE_1);

		mobilePhone = ownerMobilePhoneManager.addMobilePhone(mobilePhone);

		assertEquals(ownerMobilePhoneManager.getAllMobilePhones().size(), 1);

		ownerMobilePhoneManager.deleteMobilePhoneById(mobilePhone.getId());

		assertEquals(ownerMobilePhoneManager.getAllMobilePhones().size(), 0);
	}

	// END CRUD

	// Relations
	
	@Test
	public void getAllMobilePhonesFromOwnerByOwnerIdCheck() {
		ownerMobilePhoneManager.deleteAllMobilePhones();

		Owner owner = new Owner();
		owner.setName(NAME_1);
		owner.setSurname(SURNAME_1);
		owner.setAge(AGE_1);
		owner.setCity(CITY_1);
		
		MobilePhone mobilePhone = new MobilePhone();
		mobilePhone.setBrand(BRAND_1);
		mobilePhone.setModel(MODEL_1);
		mobilePhone.setHasCamera(HAS_CAMERA_1);
		mobilePhone.setBatteryLifes(BATTERY_LIFE_1);

		MobilePhone newMobilePhone = new MobilePhone();
		newMobilePhone.setBrand(BRAND_2);
		newMobilePhone.setModel(MODEL_2);
		newMobilePhone.setHasCamera(HAS_CAMERA_2);
		newMobilePhone.setBatteryLifes(BATTERY_LIFE_2);

		List<MobilePhone> mobilephones = new ArrayList<MobilePhone>();
		mobilephones.add(mobilePhone);
		mobilephones.add(newMobilePhone);
		
		owner.setMobilephones(mobilephones);
		owner = ownerMobilePhoneManager.AddOwner(owner);

		List<MobilePhone> fetchedmobilephones = ownerMobilePhoneManager.getAllMobilePhonesFromOwnerByOwnerId(owner.getId());

		assertEquals(fetchedmobilephones.size(), 2);
	}
	
	@Test
	public void deleteMobilePhoneByBrandFromOwner(){
		
	}

	@Test
	public void deleteMobilePhoneInOwnerCheck() {
		ownerMobilePhoneManager.deleteAllMobilePhones();
		ownerMobilePhoneManager.deleteAllOwners();

		Owner owner = new Owner();
		owner.setName("Gosia");

		MobilePhone mobilePhone = new MobilePhone();
		mobilePhone.setBrand(BRAND_1);
		mobilePhone.setModel(MODEL_1);
		mobilePhone.setHasCamera(HAS_CAMERA_1);
		mobilePhone.setBatteryLifes(BATTERY_LIFE_1);

		MobilePhone newMobilePhone = new MobilePhone();
		newMobilePhone.setBrand(BRAND_2);
		newMobilePhone.setModel(MODEL_2);
		newMobilePhone.setHasCamera(HAS_CAMERA_2);
		newMobilePhone.setBatteryLifes(BATTERY_LIFE_2);

		List<MobilePhone> mobilephones = new ArrayList<MobilePhone>();
		mobilephones.add(mobilePhone);
		mobilephones.add(newMobilePhone);

		owner.setMobilephones(mobilephones);
		
		owner = ownerMobilePhoneManager.AddOwner(owner);
		
		assertEquals(2, owner.getMobilephones().size());

		ownerMobilePhoneManager.deleteMobilePhoneByBrandFromOwner(BRAND_2, owner.getId());
		owner = ownerMobilePhoneManager.getByOwnerId(owner.getId());
		assertEquals(1, owner.getMobilephones().size());
	}
	
	@Test
	public void deleteMobilePhoneSInOwnerCheck() {
		ownerMobilePhoneManager.deleteAllMobilePhones();
		ownerMobilePhoneManager.deleteAllOwners();

		Owner owner = new Owner();
		owner.setName("Gosia");

		MobilePhone mobilePhone = new MobilePhone();
		mobilePhone.setBrand(BRAND_1);
		mobilePhone.setModel(MODEL_1);
		mobilePhone.setHasCamera(HAS_CAMERA_1);
		mobilePhone.setBatteryLifes(BATTERY_LIFE_1);

		MobilePhone newMobilePhone = new MobilePhone();
		newMobilePhone.setBrand(BRAND_2);
		newMobilePhone.setModel(MODEL_2);
		newMobilePhone.setHasCamera(HAS_CAMERA_2);
		newMobilePhone.setBatteryLifes(BATTERY_LIFE_2);
		
		MobilePhone thirdMobilePhone = new MobilePhone();
		thirdMobilePhone.setBrand(BRAND_3);
		thirdMobilePhone.setModel(MODEL_3);
		thirdMobilePhone.setHasCamera(HAS_CAMERA_3);
		thirdMobilePhone.setBatteryLifes(BATTERY_LIFE_3);

		List<MobilePhone> mobilephones = new ArrayList<MobilePhone>();
		mobilephones.add(mobilePhone);
		mobilephones.add(newMobilePhone);
		mobilephones.add(thirdMobilePhone);
		owner.setMobilephones(mobilephones);
		
		owner = ownerMobilePhoneManager.AddOwner(owner);
		
		
		assertEquals(3, owner.getMobilephones().size());
		List<MobilePhone> mobilephonesToREMOVE = new ArrayList<MobilePhone>();
		mobilephonesToREMOVE.add(mobilePhone);
		mobilephonesToREMOVE.add(newMobilePhone);
		ownerMobilePhoneManager.deleteMobilePhoneSFromOwner(mobilephonesToREMOVE, owner.getId());
		owner = ownerMobilePhoneManager.getByOwnerId(owner.getId());
		assertEquals(1, owner.getMobilephones().size());
	}

}
