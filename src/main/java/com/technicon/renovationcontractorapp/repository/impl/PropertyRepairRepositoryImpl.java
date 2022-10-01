package com.technicon.renovationcontractorapp.repository.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.technicon.renovationcontractorapp.domain.Property;
import com.technicon.renovationcontractorapp.domain.PropertyRepair;
import com.technicon.renovationcontractorapp.domain.RepairType;
import com.technicon.renovationcontractorapp.domain.StatusType;
import com.technicon.renovationcontractorapp.repository.PropertyRepairRepository;

/**
 * 	This class extends the functionality of the repository 
 * 	implementation and adds the more specific update methods
 * 	that the property-repair repository needs.
 * 
 * 	@author Grproth, skroutzzz, Chris394
 */
public class PropertyRepairRepositoryImpl extends RepositoryImpl<PropertyRepair>  implements PropertyRepairRepository {


	public PropertyRepairRepositoryImpl(List<PropertyRepair> propertyRepairList) {
        super(propertyRepairList);
    }
	
	@Override
	public List<PropertyRepair> readByDates(LocalDate dateTime1, LocalDate dateTime2) {
		List<PropertyRepair> propertyRepairs = new ArrayList<>();
		for(PropertyRepair propertyRepair:read()){
			if(propertyRepair.getDateTime().isAfter(dateTime1) && 
					propertyRepair.getDateTime().isBefore(dateTime2)) {
				propertyRepairs.add(propertyRepair);
			}
		}
		return propertyRepairs;
	}

	@Override
	public List<PropertyRepair> readByDate(LocalDate dateTime) {
		List<PropertyRepair> propertyRepairs = new ArrayList<>();
		for(PropertyRepair propertyRepair:read()){
			if(propertyRepair.getDateTime().isEqual(dateTime)) {
				propertyRepairs.add(propertyRepair);
			}
		}
		return propertyRepairs;
	}

	@Override
	public List<PropertyRepair> readByVatNumber(String vatNumber) {
		List<PropertyRepair> propertyRepairs = new ArrayList<>();
		for(PropertyRepair propertyRepair:read()){
			if(propertyRepair.getVatNumber().equals(vatNumber)) {
				propertyRepairs.add(propertyRepair);
			}
		}
		return propertyRepairs;
	}

	@Override
	public boolean updateDateTime(long propertyRepairId, LocalDate dateTime) {
		PropertyRepair propertyRepair = read(propertyRepairId);
		if( propertyRepair == null) return false;
		propertyRepair.setDateTime(dateTime);
		return true;
	}

	@Override
	public boolean updateSummary(long propertyRepairId, String summary) {
		PropertyRepair propertyRepair = read(propertyRepairId);
		if( propertyRepair == null) return false;
		propertyRepair.setSummary(summary);
		return true;
	}

	@Override
	public boolean updateRepairType(long propertyRepairId, RepairType repairType) {
		PropertyRepair propertyRepair = read(propertyRepairId);
		if( propertyRepair == null) return false;
		propertyRepair.setRepairType(repairType);
		return true;
	}

	@Override
	public boolean updateStatusType(long propertyRepairId, StatusType statusType) {
		PropertyRepair propertyRepair = read(propertyRepairId);
		if( propertyRepair == null) return false;
		propertyRepair.setStatusType(statusType);
		return true;
	}

	@Override
	public boolean updateCost(long propertyRepairId, BigDecimal cost) {
		PropertyRepair propertyRepair = read(propertyRepairId);
		if( propertyRepair == null) return false;
		propertyRepair.setCost(cost);
		return true;
	}

	@Override
	public boolean updateOwnerVatNumber(long propertyRepairId, String ownerVatNumber) {
		PropertyRepair propertyRepair = read(propertyRepairId);
		if( propertyRepair == null) return false;
		propertyRepair.setVatNumber(ownerVatNumber);
		return true;
	}

	@Override
	public boolean updatePidNumber(long propertyRepairId, long pIdNumber) {
		PropertyRepair propertyRepair = read(propertyRepairId);
		if( propertyRepair == null) return false;
		propertyRepair.setPropertyId(propertyRepairId);
		return true;
	}

	@Override
	public boolean updateRepairDesc(long propertyRepairId, String repairDesc) {
		PropertyRepair propertyRepair = read(propertyRepairId);
		if( propertyRepair == null) return false;
		propertyRepair.setRepairDesc(repairDesc);
		return true;
	}
	
}
