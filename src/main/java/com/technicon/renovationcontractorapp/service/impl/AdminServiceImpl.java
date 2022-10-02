package com.technicon.renovationcontractorapp.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.technicon.renovationcontractorapp.model.Property;
import com.technicon.renovationcontractorapp.model.PropertyRepair;
import com.technicon.renovationcontractorapp.model.PropertyType;
import com.technicon.renovationcontractorapp.model.RepairType;
import com.technicon.renovationcontractorapp.model.StatusType;
import com.technicon.renovationcontractorapp.model.User;
import com.technicon.renovationcontractorapp.repository.PropertyRepairRepository;
import com.technicon.renovationcontractorapp.repository.PropertyRepository;
import com.technicon.renovationcontractorapp.repository.UserRepository;
import com.technicon.renovationcontractorapp.service.AdminService;

/**
 * This is the implementation of the administrators services.
 * 
 * @author Grproth, skroutzzz
 */
public class AdminServiceImpl extends UserServiceImpl implements AdminService {

	private UserRepository userRepository;
	
	AdminServiceImpl( UserRepository userRepository, 
			PropertyRepository properyRepository,
			PropertyRepairRepository properyRepairRepository) {

		super(properyRepository, properyRepairRepository);
		this.userRepository = userRepository;
	}

	@Override
	public boolean addUser(User user) {
		
		return false;

		//userRepository.addRecord(user);
	}

	@Override
	public boolean addProperty(Property property) {

		return false;
	}

	@Override
	public boolean addPropertyRepair(PropertyRepair propertyRepair) {

		return false;
	}

	@Override
	public boolean updateUserAddress(long userId, String address) {

		return false;
	}

	@Override
	public boolean updateUserEmail(long userId, String email) {

		return false;
	}

	@Override
	public boolean updateUserPassword(long userId, String password) {

		return false;
	}

	@Override
	public boolean updatePropertyAddress(long propertyId, String address) {

		return false;
	}

	@Override
	public boolean updatePropertyConstructionYear(long propertyId, LocalDate constructionYear) {

		return false;
	}

	@Override
	public boolean updatePropertyType(long propertyId, PropertyType propertyType) {

		return false;
	}

	@Override
	public boolean updatePropertyVatNumber(long propertyId, String vatNumber) {

		return false;
	}

	@Override
	public boolean updatePropertyRepairDateTime(long propertyRepairId, LocalDate dateTime) {

		return false;
	}

	@Override
	public boolean updatePropertyRepairSummary(long propertyRepairId, String summary) {

		return false;
	}

	@Override
	public boolean updatePropertyRepairType(long propertyRepairId, RepairType repairType) {

		return false;
	}

	@Override
	public boolean updatePropertyRepairStatusType(long propertyRepairId, StatusType statusType) {

		return false;
	}

	@Override
	public boolean updatePropertyRepairCost(long propertyRepairId, BigDecimal cost) {

		return false;
	}

	@Override
	public boolean updatePropertyRepairVatNumber(long propertyRepairId, String vatNumber) {

		return false;
	}

	@Override
	public boolean updatePropertyRepairDesc(long propertyRepairId, String repairDesc) {

		return false;
	}

	@Override
	public boolean deleteUser(User user) {

		return false;
	}

	@Override
	public boolean deleteProperty(Property property) {

		return false;
	}

	@Override
	public boolean deletePropertyRepair(PropertyRepair propertyRepair) {

		return false;
	}

	@Override
	public User readUserWithVatNumber(String vatNumber) {

		return null;
	}

	@Override
	public User readUserWithEmail(String email) {

		return null;
	}
}
