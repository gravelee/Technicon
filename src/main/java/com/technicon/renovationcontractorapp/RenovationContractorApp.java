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
import com.technicon.renovationcontractorapp.repository.impl.DbPropertyRepairRepositoryImpl;
import com.technicon.renovationcontractorapp.repository.impl.DbPropertyRepositoryImpl;
import com.technicon.renovationcontractorapp.repository.impl.DbUserRepositoryImpl;
import com.technicon.renovationcontractorapp.service.AdminService;
import com.technicon.renovationcontractorapp.service.UserService;
import com.technicon.renovationcontractorapp.service.impl.AdminServiceImpl;
import com.technicon.renovationcontractorapp.service.impl.UserServiceImpl;
import com.technicon.renovationcontractorapp.utility.GeneralUtility;
import com.technicon.renovationcontractorapp.jpautil.JpaUtil;

/**
 *	The driver class of our application, here we do the injections
 *	and handle the test cases for our platform ( there will be no
 *	GUI or even a terminal menu).
 *
 *	@author Grproth, skroutzzz, Chris394
 */
public class RenovationContractorApp{
    
	public static void main( String[] args ){
      
		
		//	Reads the data lists to be added to database from .csv files.
		/*
		List<User> users = GeneralUtility.loadUserData();
		List<Property> properties = GeneralUtility.loadPropertyData();
		List<PropertyRepair> repairs = GeneralUtility.loadRepairData();
			
		for( User user : users)
			System.out.println(user);
		
		for( Property property : properties)
		System.out.println(property);
		
		for( PropertyRepair propertyRepair : repairs)
		System.out.println(propertyRepair);
		
		// Sets the different relationships between the objects
		
		properties.get(0).setUser(users.get(0));
		properties.get(1).setUser(users.get(1));
		properties.get(2).setUser(users.get(3));
		properties.get(3).setUser(users.get(2));
		properties.get(4).setUser(users.get(4));
		properties.get(5).setUser(users.get(3));
		properties.get(6).setUser(users.get(2));
		properties.get(7).setUser(users.get(0));
		properties.get(8).setUser(users.get(8));
		
		repairs.get(0).setProperty(properties.get(1));
		repairs.get(1).setProperty(properties.get(2));
		repairs.get(2).setProperty(properties.get(0));
		repairs.get(3).setProperty(properties.get(0));
		repairs.get(4).setProperty(properties.get(3));
		repairs.get(5).setProperty(properties.get(3));
		repairs.get(6).setProperty(properties.get(6));
		repairs.get(7).setProperty(properties.get(5));
		repairs.get(8).setProperty(properties.get(8));
		//*/
		
		// create the services by injecting the repositories inside them,
		// at the same time we inject the entity managers into the repositories.
		
		AdminService adminService = new AdminServiceImpl(
				new DbUserRepositoryImpl( JpaUtil.getEntityManager()),
				new DbPropertyRepositoryImpl( JpaUtil.getEntityManager()),
				new DbPropertyRepairRepositoryImpl( JpaUtil.getEntityManager()));
	
		UserService userService = new UserServiceImpl(
				new DbPropertyRepositoryImpl( JpaUtil.getEntityManager()),
				new DbPropertyRepairRepositoryImpl( JpaUtil.getEntityManager()));
		
		
		//	Trys to add all the data set within the database
		/*
		for( User user : users)
			adminService.addUser(user);
		
		for( Property property : properties)
			adminService.addProperty(property);
		
		for( PropertyRepair propertyRepair : repairs)
			adminService.addPropertyRepair(propertyRepair);
		//*/
		
		//	TESTS ALL READS
		//*
		System.out.println("Property owner calls:\n");
		System.out.println("Print all properties:\n");
		
		Property aProperty = userService.readPropertyWithId(2);		// returns 1
		System.out.println("aProperty="+aProperty);
		
		Property bProperty = userService.readPropertyWithId(-1);	// exception
		System.out.println("bProperty="+bProperty);
		
		Property cProperty = userService.readPropertyWithId(10);	// null
		System.out.println("cProperty="+cProperty);
		
		List<Property> dProperty 
			= userService.readPropertyWithVatNumber("2345678901");	 // returns 2p
		System.out.println("dProperty="+dProperty);
		
		List<Property> eProperty 
			= userService.readPropertyWithVatNumber("");			 // exception
		System.out.println("eProperty="+eProperty);
		
		List<Property> fProperty 
			= userService.readPropertyWithVatNumber("0000000000");   // null
		System.out.println("fProperty="+fProperty);
		
		List<Property> gProperty 
			= userService.readPropertyWithVatNumber("2345678901111");// exception
		System.out.println("gProperty="+gProperty);
		
		System.out.println("Print all repairs:\n");
		
		List<PropertyRepair> aPropertyRepair 
			= userService.readPropertyRepairWithDate(LocalDate.of(2021, 4, 8));	// return 1
		System.out.println("aPropertyRepair="+aPropertyRepair);
		
		List<PropertyRepair> bPropertyRepair 
			= userService.readPropertyRepairWithDate(LocalDate.of(1921, 11, 5));// null
		System.out.println("bPropertyRepair="+bPropertyRepair);
		
		List<PropertyRepair> cPropertyRepair 
			= userService.readPropertyRepairWithDate(LocalDate.of(1, 1, 1));	// null
		System.out.println("cPropertyRepair="+cPropertyRepair);
		
		List<PropertyRepair> dPropertyRepair 
			= userService.readPropertyRepairWithDates(
				LocalDate.of(2021, 4, 7),LocalDate.of(2021, 4, 9));		// return 1
		System.out.println("dPropertyRepair="+dPropertyRepair);
		
		List<PropertyRepair> ePropertyRepair 
			= userService.readPropertyRepairWithDates(
				LocalDate.of(2016, 4, 7),LocalDate.of(2016, 4, 9));		// null
		System.out.println("ePropertyRepair="+ePropertyRepair);
		
		List<PropertyRepair> fPropertyRepair 
			= userService.readPropertyRepairWithDates(
				LocalDate.of(2000, 4, 7),LocalDate.of(2025, 4, 9));		// return 7 (all)
		for( PropertyRepair p : fPropertyRepair)
			System.out.println("fPropertyRepair="+p);
		
		List<PropertyRepair> gPropertyRepair 
			= userService.readPropertyRepairWithVatNumber("0123456789");// return 2
		System.out.println("gPropertyRepair="+gPropertyRepair);
		
		List<PropertyRepair> hPropertyRepair 
			= userService.readPropertyRepairWithVatNumber("123");		// exception
		System.out.println("hPropertyRepair="+hPropertyRepair);
		
		List<PropertyRepair> iPropertyRepair 
			= userService.readPropertyRepairWithVatNumber("0000000000");// null
		System.out.println("iPropertyRepair="+iPropertyRepair);
	
		System.out.println("\n\nAdministrator calls:\n");
		System.out.println("Print all users:\n");
		
		User auser 
			= adminService.readUserWithVatNumber("0123456789");		// return 1
		System.out.println("auser="+auser);
		
		User buser 
			= adminService.readUserWithVatNumber("012345");			// exception
		System.out.println("buser="+buser);
		
		User cuser 
			= adminService.readUserWithVatNumber("0000000000");		// null
		System.out.println("cuser="+cuser);
		
		User duser = adminService.readUserWithEmail("gravelee@mail.com");	// return 1
		System.out.println("duser="+duser);
		
		User euser = adminService.readUserWithEmail("brucelee@gmail.com");	// null
		System.out.println("euser="+euser);
		
		User fuser = adminService.readUserWithEmail("mail.com");			// exception
		System.out.println("fuser="+fuser);
		
		//	TEST ALL UPDATES
		
		System.out.println("\n\nTest all update methods: \n");
		
		boolean a = 
		adminService.updateUserAddress( 
				adminService.readUserWithVatNumber("0123456789"), "Alamanas 18");// true
		System.out.println("a="+a);
		
		boolean b = 
		adminService.updateUserAddress( 
				adminService.readUserWithVatNumber("012345"), "Alamanas 18");	 // exception
		System.out.println("b="+b);
		
		boolean c = 
		adminService.updateUserAddress( 
				adminService.readUserWithVatNumber("6666666666"), "Alamanas 18");// exception
		System.out.println("c="+c);
		
		boolean d = 
		adminService.updateUserEmail(
				adminService.readUserWithVatNumber("0123456789"), "team@mail.com");// true
		System.out.println("d="+d);
		
		boolean e = 
		adminService.updateUserEmail(
				adminService.readUserWithVatNumber("0123456789"), "teammail.com");// exception
		System.out.println("e="+e);
		
		boolean f = 
		adminService.updateUserEmail(
				adminService.readUserWithVatNumber("0123456789"), "team@mail.com");// true
		System.out.println("f="+f);
		
		boolean g =
		adminService.updateUserEmail(
				adminService.readUserWithVatNumber("01234"), "team2@mail.com");	// exception
		System.out.println("g="+g);
		
		boolean h = 
		adminService.updateUserPassword(
				adminService.readUserWithVatNumber("0123456789"), "MailSummer!890");// true
		System.out.println("h="+h);
		
		boolean i = 
		adminService.updateUserPassword(
				adminService.readUserWithVatNumber("0123456789"), "MailSummer890"); // exception
		System.out.println("i="+i);
		
		boolean j = 
		adminService.updateUserPassword(
				adminService.readUserWithVatNumber("0123456789"), "Md!890");		// exception
		System.out.println("j="+j);
		
		boolean k = 
		adminService.updateUserPassword(
				adminService.readUserWithVatNumber("0000000000"), "MailSummer!890");// exception
		System.out.println("k="+k);
		
		boolean l = 
		adminService.updatePropertyAddress( 
				adminService.readPropertyWithId(2L),"Karagiozi 25");			// true
		System.out.println("l="+l);
		
		boolean m = 
		adminService.updatePropertyAddress( 
				adminService.readPropertyWithId(10L),"Kozanhs 2");				// exception
		System.out.println("m="+m);
		
		boolean n = 
		adminService.updatePropertyConstructionYear( 
				adminService.readPropertyWithId(2L),LocalDate.of(1999, 12, 28));// true
		System.out.println("n="+n);
		
		boolean o = 
		adminService.updatePropertyConstructionYear( 
				adminService.readPropertyWithId(11L),LocalDate.of(1956, 2, 8)); // exception
		System.out.println("o="+o);
		
		boolean p = 
		adminService.updatePropertyType( 
				adminService.readPropertyWithId(2L)
				,PropertyType.APARTMENT_BUILDING); 			// true
		System.out.println("p="+p);
		
		boolean q = 
			adminService.updatePropertyRepairDateTime(
					adminService.readPropertyRepairWithVatNumber("0123456789").get(0)
					,LocalDate.of(1994, 10, 28)); 		
			System.out.println("q="+q);						// true
		
		boolean r = 
		adminService.updatePropertyRepairSummary(
				adminService.readPropertyRepairWithDate(LocalDate.of(2021, 6, 2)).get(0)
				,"This is the new summary!"); 		
		System.out.println("r="+r);							// true
		
		boolean s = 
			adminService.updatePropertyRepairType(
					adminService.readPropertyRepairWithDates(
							LocalDate.of(2021, 6, 1),LocalDate.of(2021, 6, 3)).get(0)
					,RepairType.ELECTRICAL_WORK); 		
			System.out.println("s="+s);						// true
		
		boolean t = 
			adminService.updatePropertyRepairStatusType( 
					adminService.readPropertyRepairWithVatNumber("0123456789").get(0)
					,StatusType.COMPLETE); 		
			System.out.println("t="+t);						// true
		
		boolean u = 
			adminService.updatePropertyRepairCost(
					adminService.readPropertyRepairWithVatNumber("0123456789").get(0)
					,BigDecimal.ONE); 		
			System.out.println("u="+u);						// true
		
		boolean w = 
			adminService.updatePropertyRepairDesc( 
					adminService.readPropertyRepairWithVatNumber("0123456789").get(0)
					,"This is a very big description!!!!"); 	
			System.out.println("w="+w);						// true
		
		//	TEST ALL DELETES
		
		System.out.println("\n\nTest all delete methods: \n");
		
		
		
		boolean z = 
		adminService.deletePropertyRepair( 
				adminService.readPropertyRepairWithVatNumber(
						"1234567890").get(0));
		System.out.println("z="+z);							// true
		
		boolean y = 
		adminService.deleteProperty( 
				adminService.readPropertyWithVatNumber(
						"1234567890").get(0));
		System.out.println("y="+y);							// true
		
		boolean x = 
		adminService.deleteUser( 
				adminService.readUserWithVatNumber("1234567890"));
		System.out.println("x="+x);							// true
		
		boolean xx = 
		adminService.deleteUser( 
				adminService.readUserWithVatNumber("0000000000"));
		System.out.println("xx="+xx);						// false
		//*/
    }
}
