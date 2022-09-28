package com.technicon.renovationcontractorapp.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.technicon.renovationcontractorapp.domain.Property;
import com.technicon.renovationcontractorapp.domain.PropertyRepair;
import com.technicon.renovationcontractorapp.domain.PropertyType;
import com.technicon.renovationcontractorapp.domain.RepairType;
import com.technicon.renovationcontractorapp.domain.StatusType;
import com.technicon.renovationcontractorapp.domain.User;
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
	
	AdminServiceImpl(UserRepository userRepository, PropertyRepository properyRepository,
			PropertyRepairRepository properyRepairRepository) {

		super(properyRepository, properyRepairRepository);
		this.userRepository = userRepository;
	}

	@Override
	public boolean addUser(User user) {

		return false;
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
	public boolean updateUserAddress(User user, String address) {

		return false;
	}

	@Override
	public boolean updateUserEmail(User user, String email) {

		return false;
	}

	@Override
	public boolean updateUserPassword(User user, String password) {

		return false;
	}

	@Override
	public boolean updatePropertyAddress(Property property, String address) {

		return false;
	}

	@Override
	public boolean updatePropertyConstructionYear(Property property, LocalDate constructionYear) {

		return false;
	}

	@Override
	public boolean updatePropertyType(Property property, PropertyType propertyType) {

		return false;
	}

	@Override
	public boolean updatePropertyVatNumber(Property property, String vatNumber) {

		return false;
	}

	@Override
	public boolean updatePropertyRepairDateTime(Property property, LocalDate dateTime) {

		return false;
	}

	@Override
	public boolean updatePropertyRepairSummary(Property property, String summary) {

		return false;
	}

	@Override
	public boolean updatePropertyRepairType(Property property, RepairType repairType) {

		return false;
	}

	@Override
	public boolean updatePropertyRepairStatusType(Property property, StatusType statusType) {

		return false;
	}

	@Override
	public boolean updatePropertyRepairCost(Property property, BigDecimal cost) {

		return false;
	}

	@Override
	public boolean updatePropertyRepairVatNumber(Property property, String vatNumber) {

		return false;
	}

	@Override
	public boolean updatePropertyRepairDesc(Property property, String repairDesc) {

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
