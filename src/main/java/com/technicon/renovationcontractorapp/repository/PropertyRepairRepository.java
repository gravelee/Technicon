package com.technicon.renovationcontractorapp.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.technicon.renovationcontractorapp.domain.RepairType;
import com.technicon.renovationcontractorapp.domain.StatusType;
import com.technicon.renovationcontractorapp.model.PropertyRepair;

/**
 * 	A more specific interface that extends the repository.
 * 	It represents the property-repair repository with the 
 * 	specific update & read methods of all its attributes.
 * 
 * 	@author Grproth, skroutzzz, Chris394
 */
public interface PropertyRepairRepository extends Repository<PropertyRepair, Long> {
    
	// read based on dateTime, vatNumber
	List<PropertyRepair> readByDate(LocalDate dateTime) throws Exception;
	List<PropertyRepair> readByDates(LocalDate dateTime1,LocalDate dateTime2) throws Exception;
	List<PropertyRepair> readByVatNumber(String vatNumber) throws Exception;
	
	// updates for datetime, summary, repairType, statusType, cost, repairDesc
	boolean updateDateTime(long propertyRepairId,LocalDate dateTime) throws Exception;
	boolean updateSummary(long propertyRepairId,String summary) throws Exception;
	boolean updateRepairType(long propertyRepairId,RepairType repairType) throws Exception;
	boolean updateStatusType(long propertyRepairId,StatusType statusType) throws Exception;
	boolean updateCost(long propertyRepairId,BigDecimal cost) throws Exception;
	boolean updateRepairDesc(long propertyRepairId,String repairDesc) throws Exception;
	
}
