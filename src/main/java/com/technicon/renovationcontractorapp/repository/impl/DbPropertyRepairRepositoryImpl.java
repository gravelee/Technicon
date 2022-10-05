package com.technicon.renovationcontractorapp.repository.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.technicon.renovationcontractorapp.domain.RepairType;
import com.technicon.renovationcontractorapp.domain.StatusType;
import com.technicon.renovationcontractorapp.model.Property;
import com.technicon.renovationcontractorapp.model.PropertyRepair;
import com.technicon.renovationcontractorapp.repository.PropertyRepairRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

/**
* 	This is the implementation of the PropertyRepairRepository interface.
* 	
* 	@author Grproth, skroutzzz, Chris394
*/
public class DbPropertyRepairRepositoryImpl extends DbRepositoryImpl<PropertyRepair,Long> 
            implements PropertyRepairRepository{

	public DbPropertyRepairRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	@Override
	public List<PropertyRepair> readByDate(LocalDate dateTime) {
		String selectString = "select * from propertyrepair where dateTime=?1";
		Query sqlQuery = entityManager.createNativeQuery(selectString, PropertyRepair.class);
		sqlQuery.setParameter(1, dateTime);
		return sqlQuery.getResultList();
	}

	@Override
	public List<PropertyRepair> readByDates(LocalDate dateTime1, LocalDate dateTime2) {
		String selectString = "select * from propertyrepair where dateTime >= ?1 and dateTime <= ?2";
		Query sqlQuery = entityManager.createNativeQuery(selectString, PropertyRepair.class);
		sqlQuery.setParameter(1, dateTime1);
		sqlQuery.setParameter(2, dateTime2);
		return sqlQuery.getResultList();
	}
    
	@Override
	public List<PropertyRepair> readByVatNumber(String vatNumber) {
		String selectString = "select * from propertyrepair pr "
				+ " inner join property p on pr.property_propertyId=p.propertyId"
				+ " inner join user u on p.user_userId = u.userId"
				+ " where u.vatNumber=?1";
		Query sqlQuery = entityManager.createNativeQuery(selectString, PropertyRepair.class);
		sqlQuery.setParameter(1, vatNumber);
		return sqlQuery.getResultList();
	}

	@Override
	public boolean updateDateTime(long propertyRepairId, LocalDate dateTime) {
		Optional<PropertyRepair> propertyRepair = read(propertyRepairId);
		if(propertyRepair.isPresent()) {
			try {
				PropertyRepair propertyRepair2 = propertyRepair.get();
				propertyRepair2.setDateTime(dateTime);
				entityManager.getTransaction().begin();
				entityManager.merge(propertyRepair2);
				entityManager.getTransaction().commit();
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean updateSummary(long propertyRepairId, String summary) {
		Optional<PropertyRepair> propertyRepair = read(propertyRepairId);
		if(propertyRepair.isPresent()) {
			try {
				PropertyRepair propertyRepair2 = propertyRepair.get();
				propertyRepair2.setSummary(summary);
				entityManager.getTransaction().begin();
				entityManager.merge(propertyRepair2);
				entityManager.getTransaction().commit();
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean updateRepairType(long propertyRepairId, RepairType repairType) {
		Optional<PropertyRepair> propertyRepair = read(propertyRepairId);
		if(propertyRepair.isPresent()) {
			try {
				PropertyRepair propertyRepair2 = propertyRepair.get();
				propertyRepair2.setRepairType(repairType);
				entityManager.getTransaction().begin();
				entityManager.merge(propertyRepair2);
				entityManager.getTransaction().commit();
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean updateStatusType(long propertyRepairId, StatusType statusType) {
		Optional<PropertyRepair> propertyRepair = read(propertyRepairId);
		if(propertyRepair.isPresent()) {
			try {
				PropertyRepair propertyRepair2 = propertyRepair.get();
				propertyRepair2.setStatusType(statusType);
				entityManager.getTransaction().begin();
				entityManager.merge(propertyRepair2);
				entityManager.getTransaction().commit();
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean updateCost(long propertyRepairId, BigDecimal cost) {
		Optional<PropertyRepair> propertyRepair = read(propertyRepairId);
		if(propertyRepair.isPresent()) {
			try {
				PropertyRepair propertyRepair2 = propertyRepair.get();
				propertyRepair2.setCost(cost);
				entityManager.getTransaction().begin();
				entityManager.merge(propertyRepair2);
				entityManager.getTransaction().commit();
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean updateRepairDesc(long propertyRepairId, String repairDesc) {
		Optional<PropertyRepair> propertyRepair = read(propertyRepairId);
		if(propertyRepair.isPresent()) {
			try {
				PropertyRepair propertyRepair2 = propertyRepair.get();
				propertyRepair2.setRepairDesc(repairDesc);
				entityManager.getTransaction().begin();
				entityManager.merge(propertyRepair2);
				entityManager.getTransaction().commit();
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public String getEntityClassName() {
		return PropertyRepair.class.getName();
	}

	@Override
	public Class<PropertyRepair> getEntityClass() {
		return PropertyRepair.class;
	}
	
}
