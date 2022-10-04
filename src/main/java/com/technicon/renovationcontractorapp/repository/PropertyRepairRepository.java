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
    /*
	// read based on dateTime, vatNumber
	List<PropertyRepair> readByDate(LocalDate dateTime);
	List<PropertyRepair> readByDates(LocalDate dateTime1,LocalDate dateTime2);
	List<PropertyRepair> readByVatNumber(String vatNumber);
	
	// updates for datetime, summary, repairType, statusType, cost, ownerVatNumber, pIdNumber, repairDesc
	boolean updateDateTime(long propertyRepairId,LocalDate dateTime);
	boolean updateSummary(long propertyRepairId,String summary);
	boolean updateRepairType(long propertyRepairId,RepairType repairType);
	boolean updateStatusType(long propertyRepairId,StatusType statusType);
	boolean updateCost(long propertyRepairId,BigDecimal cost);
	boolean updateVatNumber(long propertyRepairId,String ownerVatNumber);
	boolean updatePidNumber(long propertyRepairId,long pIdNumber);
	boolean updateRepairDesc(long propertyRepairId,String repairDesc);
	*/
}
