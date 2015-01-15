package com.example.nosqldemo.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.nosqldemo.domain.MobilePhone;
import com.example.nosqldemo.domain.Owner;
import com.example.nosqldemo.repository.MobilePhoneRepository;
import com.example.nosqldemo.repository.OwnerRepository;

@Component
public class OwnerMobilePhoneManager {

	@Autowired
	private MobilePhoneRepository mobilePhoneRepository;
	@Autowired
	private OwnerRepository ownerRepository;

	// CRUD FOR MobilePhone
	// Create
	public MobilePhone addMobilePhone(MobilePhone mobilePhone) {
		return mobilePhoneRepository.save(mobilePhone);
	}

	// Read
	public List<MobilePhone> getAllMobilePhones() {
		return (List<MobilePhone>) mobilePhoneRepository.findAll();
	}

	public MobilePhone getMobilePhoneById(ObjectId mobilePhone_id) {
		return mobilePhoneRepository.findById(mobilePhone_id);
	}

	public List<MobilePhone> getMobilePhones(String model) {
		return mobilePhoneRepository.findByModel(model);
	}

	public List<MobilePhone> getMobilePhones(String brand, String model) {
		return mobilePhoneRepository.znajdzTelefon(brand, model);
	}

	// Update
	public void updateMobilePhone(MobilePhone oldMobilePhone, MobilePhone newMobilePhone) {
		oldMobilePhone.setBatteryLifes(newMobilePhone.getBatteryLifes());
		oldMobilePhone.setBrand(newMobilePhone.getBrand());
		oldMobilePhone.setHasCamera(newMobilePhone.getHasCamera());
		oldMobilePhone.setModel(newMobilePhone.getModel());

		mobilePhoneRepository.save(oldMobilePhone);
	}

	// Delete
	public void deleteAllMobilePhones() {
		mobilePhoneRepository.deleteAll();
	}

	public void deleteMobilePhone(MobilePhone mobile) {
		mobilePhoneRepository.delete(mobile);
	}

	public void deleteMobilePhoneById(ObjectId mobilPhone_id) {
		mobilePhoneRepository.delete(mobilPhone_id);
	}

	// END CRUD

	// Relations

	public List<MobilePhone> getAllMobilePhonesFromOwnerByOwnerId(ObjectId ownerId) {
		return ownerRepository.findById(ownerId).getMobilephones();
	}

	public void deleteMobilePhoneByBrandFromOwner(String brand, ObjectId ownerId) {
		Owner owner = ownerRepository.findById(ownerId);
		List<MobilePhone> Newmobilephone = new ArrayList<MobilePhone>();

		for (MobilePhone mobilePhone2 : owner.getMobilephones()) {
			if (!mobilePhone2.getBrand().equals(brand)) {
				Newmobilephone.add(mobilePhone2);
			}
		}
		owner.setMobilephones(Newmobilephone);
		ownerRepository.save(owner);
	}

	public void deleteMobilePhoneFromOwner(MobilePhone mobilePhone, ObjectId ownerId) {
		Owner owner = ownerRepository.findById(ownerId);
		List<MobilePhone> Newmobilephone = new ArrayList<MobilePhone>();

		for (MobilePhone mobilePhone2 : owner.getMobilephones()) {
			if (mobilePhone2.getHasCamera() != mobilePhone.getHasCamera()
					&& mobilePhone2.getBatteryLifes() != mobilePhone.getBatteryLifes()
					&& !mobilePhone2.getBrand().equals(mobilePhone.getBrand())
					&& !mobilePhone2.getModel().equals(mobilePhone.getModel())) {
				Newmobilephone.add(mobilePhone2);
			}
		}
		owner.setMobilephones(Newmobilephone);
		ownerRepository.save(owner);
	}

	public void deleteMobilePhoneSFromOwner(List<MobilePhone> mobilePhones,
			ObjectId ownerId) {
		Owner owner = ownerRepository.findById(ownerId);
		List<MobilePhone> Newmobilephone = new ArrayList<MobilePhone>();

		for (MobilePhone mobilePhoneFromOwner : owner.getMobilephones()) {
			Boolean isInsidePhonesToDelete = false;
			for (MobilePhone phoneToDelete : mobilePhones) {
				if (mobilePhoneFromOwner.getHasCamera() == phoneToDelete.getHasCamera()
						&& mobilePhoneFromOwner.getBatteryLifes() == phoneToDelete
								.getBatteryLifes()
						&& mobilePhoneFromOwner.getBrand().equals(
								phoneToDelete.getBrand())
						&& mobilePhoneFromOwner.getModel().equals(
								phoneToDelete.getModel())) {
					isInsidePhonesToDelete = true;
				}
			}

			if (!isInsidePhonesToDelete) {
				Newmobilephone.add(mobilePhoneFromOwner);
			}

		}
		owner.setMobilephones(Newmobilephone);
		ownerRepository.save(owner);
	}

	// END Relations

	// Owner

	public void deleteAllOwners() {
		ownerRepository.deleteAll();
	}

	public Owner AddOwner(Owner owner) {
		return ownerRepository.save(owner);
	}

	public Owner getByOwnerId(ObjectId id) {
		return ownerRepository.findById(id);
	}
	
	// END Owner

}
