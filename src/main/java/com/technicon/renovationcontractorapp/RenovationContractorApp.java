package com.technicon.renovationcontractorapp;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.technicon.renovationcontractorapp.model.Property;
import com.technicon.renovationcontractorapp.model.PropertyRepair;
import com.technicon.renovationcontractorapp.domain.PropertyType;
import com.technicon.renovationcontractorapp.domain.RepairType;
import com.technicon.renovationcontractorapp.domain.StatusType;
import com.technicon.renovationcontractorapp.model.User;
import com.technicon.renovationcontractorapp.repository.PropertyRepairRepository;
import com.technicon.renovationcontractorapp.repository.PropertyRepository;
import com.technicon.renovationcontractorapp.repository.UserRepository;
import com.technicon.renovationcontractorapp.repository.impl.DbPropertyRepairRepositoryImpl;
import com.technicon.renovationcontractorapp.repository.impl.DbPropertyRepositoryImpl;
import com.technicon.renovationcontractorapp.repository.impl.DbUserRepositoryImpl;
import com.technicon.renovationcontractorapp.service.AdminService;
import com.technicon.renovationcontractorapp.service.UserService;
import com.technicon.renovationcontractorapp.service.impl.AdminServiceImpl;
import com.technicon.renovationcontractorapp.service.impl.UserServiceImpl;
import com.technicon.renovationcontractorapp.jpautil.JpaUtil;

import jakarta.persistence.EntityManager;

/**
 *	The driver class of our application, here we do the injections
 *	and handle the test cases for our platform ( there will be no
 *	GUI or even a terminal menu).
 *
 *	@author Grproth, skroutzzz, Chris394
 */
public class RenovationContractorApp{
    
	public static void main( String[] args ){
        
//------- Database Test Creation of table user and insertion of one record -----------------		
		
		//EntityManager entityManager = JpaUtil.getEntityManager();
		
//--------------USERS TEST DATA -----------------//
		
		User user = new User();
		user.setName("Kostantinos");
		user.setSurname("Tsigkounis");
		user.setAddress("Komotinis 12");
		user.setPhoneNumber("6942437586");
		user.setEmail("konstantinos.tsigk@mail.com");
		user.setUsername("kost");
		user.setPassword("tsigk");
		user.setVatNumber("abcdefghij");
		user.setAdmin(false);
		
		User user1 = new User();
		user1.setName("Aristeidis");
		user1.setSurname("Gerakis");
		user1.setAddress("Thessalonikis 25");
		user1.setPhoneNumber("6992445586");
		user1.setEmail("gravelee@mail.com");
		user1.setUsername("Aris");
		user1.setPassword("Gerax");
		user1.setVatNumber("ertyuioplk");
		user1.setAdmin(true);
		
		User user2 = new User();
		user2.setName("Christos");
		user2.setSurname("Xidas");
		user2.setAddress("Pentelis 12");
		user2.setPhoneNumber("6945679234");
		user2.setEmail("cxydas@mail.com");
		user2.setUsername("Chris");
		user2.setPassword("Xid");
		user2.setVatNumber("asdfghjklo");
		user2.setAdmin(false);
		
		User user3 = new User();
		user3.setName("Ioannis");
		user3.setSurname("Klian");
		user3.setAddress("Varimpompis 54");
		user3.setPhoneNumber("6912345678");
		user3.setEmail("iklian@mail.com");
		user3.setUsername("Iklian");
		user3.setPassword("Kli");
		user3.setVatNumber("lkjhgfdswe");
		user3.setAdmin(false);
		
		User user4 = new User();
		user4.setName("Ioannis");
		user4.setSurname("Daniil");
		user4.setAddress("Giannitson 22");
		user4.setPhoneNumber("6998765432");
		user4.setEmail("idaniil@mail.com");
		user4.setUsername("IDaniil");
		user4.setPassword("Dani");
		user4.setVatNumber("zxcvbnmkjh");
		user4.setAdmin(false);
		
//--------------PROPERTIES TEST DATA -----------------//	
		
		Property property = new Property();
		property.setAddress("Manis 15");
		property.setConstructionYear(LocalDate.of(2020, 3, 8));
		property.setPropertyType(PropertyType.valueOf("DETACHED_HOUSE"));
		//property.setVatNumber("abcdefghij");
		property.setUser(user);
		
		Property property1 = new Property();
		property1.setAddress("Kritis 23");
		property1.setConstructionYear(LocalDate.of(2019, 4, 7));
		property1.setPropertyType(PropertyType.valueOf("MAISONETTE"));
		//property1.setVatNumber("ertyuioplk");
		property1.setUser(user1);
		
		Property property2 = new Property();
		property2.setAddress("Varis 39");
		property2.setConstructionYear(LocalDate.of(2018, 8, 9));
		property2.setPropertyType(PropertyType.valueOf("APARTMENT_BUILDING"));
		//property2.setVatNumber("lkjhgfdswe");
		property2.setUser(user3);
		
		Property property3 = new Property();
		property3.setAddress("Thrakis 28");
		property3.setConstructionYear(LocalDate.of(2017, 1, 2));
		property3.setPropertyType(PropertyType.valueOf("APARTMENT_BUILDING"));
		//property3.setVatNumber("asdfghjklo");
		property3.setUser(user2);
		
		Property property4 = new Property();
		property4.setAddress("Xanthis 11");
		property4.setConstructionYear(LocalDate.of(2021, 5, 3));
		property4.setPropertyType(PropertyType.valueOf("MAISONETTE"));
		//property4.setVatNumber("zxcvbnmkjh");
		property4.setUser(user4);
		
		Property property5 = new Property();
		property5.setAddress("Menelaou 8");
		property5.setConstructionYear(LocalDate.of(2021, 10, 6));
		property5.setPropertyType(PropertyType.valueOf("DETACHED_HOUSE"));
		//property5.setVatNumber("lkjhgfdswe");
		property5.setUser(user3);
		
		
		
		
//--------------PROPERTY REPAIRS TEST DATA -----------------//			
		
		
		
		//LocalDate dateTime, String summary, RepairType repairType, StatusType statusType, BigDecimal cost, String vatNumber,  String repairDesc
		PropertyRepair propertyRepair = new PropertyRepair();
		propertyRepair.setDateTime(LocalDate.of(2020, 3, 8));
		propertyRepair.setSummary("Leaking floor");
		propertyRepair.setRepairType(RepairType.valueOf("PLUMBING"));
		propertyRepair.setStatusType(StatusType.valueOf("PENDING"));
		propertyRepair.setCost(new BigDecimal("5000"));
		//propertyRepair.setVatNumber("ertyuioplk");
		propertyRepair.setRepairDesc("Change pipes under floor");
		propertyRepair.setProperty(property1);
		
		
		PropertyRepair propertyRepair1 = new PropertyRepair();
		propertyRepair1.setDateTime(LocalDate.of(2020, 10, 7));
		propertyRepair1.setSummary("Lights out of order");
		propertyRepair1.setRepairType(RepairType.valueOf("ELECTRICAL_WORK"));
		propertyRepair1.setStatusType(StatusType.valueOf("IN_PROGRESS"));
		propertyRepair1.setCost(new BigDecimal("2350"));
		//propertyRepair1.setVatNumber("lkjhgfdswe");
		propertyRepair1.setRepairDesc("Change the electrical system of the kitchen");
		propertyRepair1.setProperty(property2);
		
		PropertyRepair propertyRepair2 = new PropertyRepair();
		propertyRepair2.setDateTime(LocalDate.of(2020, 11, 7));
		propertyRepair2.setSummary("Walls not painted");
		propertyRepair2.setRepairType(RepairType.valueOf("PAINTING"));
		propertyRepair2.setStatusType(StatusType.valueOf("PENDING"));
		propertyRepair2.setCost(new BigDecimal("500"));
		//propertyRepair2.setVatNumber("abcdefghij");
		propertyRepair2.setRepairDesc("Change the color of the walls to green");
		propertyRepair2.setProperty(property);
		
		PropertyRepair propertyRepair3 = new PropertyRepair();
		propertyRepair3.setDateTime(LocalDate.of(2021, 6, 2));
		propertyRepair3.setSummary("Windows broken");
		propertyRepair3.setRepairType(RepairType.valueOf("FRAMES"));
		propertyRepair3.setStatusType(StatusType.valueOf("IN_PROGRESS"));
		propertyRepair3.setCost(new BigDecimal("1200"));
		//propertyRepair3.setVatNumber("abcdefghij");
		propertyRepair3.setRepairDesc("New windows throughout the whole house");
		propertyRepair3.setProperty(property);
		
		PropertyRepair propertyRepair4 = new PropertyRepair();
		propertyRepair4.setDateTime(LocalDate.of(2018, 6, 2));
		propertyRepair4.setSummary("Toilet problems");
		propertyRepair4.setRepairType(RepairType.valueOf("PLUMBING"));
		propertyRepair4.setStatusType(StatusType.valueOf("COMPLETE"));
		propertyRepair4.setCost(new BigDecimal("2500"));
		//propertyRepair4.setVatNumber("asdfghjklo");
		propertyRepair4.setRepairDesc("Changed pipes inside the bathroom under the sink");
		propertyRepair4.setProperty(property3);
		
		PropertyRepair propertyRepair5 = new PropertyRepair();
		propertyRepair5.setDateTime(LocalDate.of(2022, 1, 1));
		propertyRepair5.setSummary("Basement Lights");
		propertyRepair5.setRepairType(RepairType.valueOf("ELECTRICAL_WORK"));
		propertyRepair5.setStatusType(StatusType.valueOf("IN_PROGRESS"));
		propertyRepair5.setCost(new BigDecimal("700"));
		//propertyRepair5.setVatNumber("asdfghjklo");
		propertyRepair5.setRepairDesc("Changed pipes inside the bathroom under the sink");
		propertyRepair5.setProperty(property3);
		
		
// -------------- INSERT IN DATABASE ------------------//		
		
		
//		entityManager.getTransaction().begin();
//		entityManager.persist(user);
//		entityManager.persist(user1);
//		entityManager.persist(user2);
//		entityManager.persist(user3);
//		entityManager.persist(user4);
//		
//		entityManager.persist(property);
//		entityManager.persist(property1);
//		entityManager.persist(property2);
//		entityManager.persist(property3);
//		entityManager.persist(property4);
//		entityManager.persist(property5);
//		
//		entityManager.persist(propertyRepair);
//		entityManager.persist(propertyRepair1);
//		entityManager.persist(propertyRepair2);
//		entityManager.persist(propertyRepair3);
//		entityManager.persist(propertyRepair4);
//		entityManager.persist(propertyRepair5);
//		
//		entityManager.getTransaction().commit();
//		JpaUtil.shutdown();
		
		
		
		/*
		// Create the PropertyRepairRepository
		
		PropertyRepairRepository pRRepo = 
			new DbPropertyRepairRepositoryImpl(
				JpaUtil.getEntityManager());
		
		// Create the PropertyRepository
		
		PropertyRepository pRepo = 
			new DbPropertyRepositoryImpl(
				JpaUtil.getEntityManager());
		
		// Create the UserRepository
		
		UserRepository uRepo = 
			new DbUserRepositoryImpl(
				JpaUtil.getEntityManager());
		*/
		
		// create the services by injecting the repositories inside them,
		// at the same time we inject the entity managers into the repositories.
		
//	AdminService adminService = new AdminServiceImpl(
//		new DbUserRepositoryImpl( JpaUtil.getEntityManager()),
//		new DbPropertyRepositoryImpl( JpaUtil.getEntityManager()),
//		new DbPropertyRepairRepositoryImpl( JpaUtil.getEntityManager()));
//	
//	UserService userService = new UserServiceImpl(
//		new DbPropertyRepositoryImpl( JpaUtil.getEntityManager()),
//		new DbPropertyRepairRepositoryImpl( JpaUtil.getEntityManager()));
//		
		
		// create users and test cases ( call methods from the services)
		PropertyRepairRepository pRRepo = 
				new DbPropertyRepairRepositoryImpl(
					JpaUtil.getEntityManager());
		
		pRRepo.updateSummary(2,"Hydraulics problem");
		
		UserRepository uRepo = 
				new DbUserRepositoryImpl(
					JpaUtil.getEntityManager());
		
		System.out.println(uRepo.readByVatNumber("ukjhgfd").isPresent());
		
//		uRepo.updateAddress("asdfghjklo","Patras 123");
//		uRepo.updateEmail("asdfghjklo", "kalispera@mail.com");
//		uRepo.updatePassword("asdfghjklo", "123456789");
		
		
    }
}
