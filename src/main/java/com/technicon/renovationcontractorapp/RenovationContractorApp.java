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
      
		User user = new User();
		user.setName("Kostantinos");
		user.setSurname("Tsigkounis");
		user.setAddress("Komotinis 12");
		user.setPhoneNumber("6942854060");
		user.setEmail("konstantinos.tsigk@mail.com");
		user.setUsername("kost");
		user.setPassword("Tsigkou99!");
		user.setVatNumber("0123456789");
		user.setAdmin(false);

		User user1 = new User();
		user1.setName("Aristeidis");
		user1.setSurname("Gerakis");
		user1.setAddress("Thessalonikis 25");
		user1.setPhoneNumber("6992445586");
		user1.setEmail("gravelee@mail.com");
		user1.setUsername("Aris");
		user1.setPassword("Gerakis32!");
		user1.setVatNumber("1234567890");
		user1.setAdmin(true);

		User user2 = new User();
		user2.setName("Christos");
		user2.setSurname("Xidas");
		user2.setAddress("Pentelis 12");
		user2.setPhoneNumber("6945679234");
		user2.setEmail("cxydas@mail.com");
		user2.setUsername("Chris");
		user2.setPassword("Xidas284!");
		user2.setVatNumber("2345678901");
		user2.setAdmin(false);


		User user3 = new User();
		user3.setName("Ioannis");
		user3.setSurname("Klian");
		user3.setAddress("Varimpompis 54");
		user3.setPhoneNumber("6912345678");
		user3.setEmail("iklian@mail.com");
		user3.setUsername("Iklian");
		user3.setPassword("IKlian27!");
		user3.setVatNumber("3456789012");
		user3.setAdmin(false);

		User user4 = new User();
		user4.setName("Ioannis");
		user4.setSurname("Daniil");
		user4.setAddress("Giannitson 22");
		user4.setPhoneNumber("6998765432");
		user4.setEmail("idaniil@mail.com");
		user4.setUsername("IDaniil");
		user4.setPassword("IDaniil99!");
		user4.setVatNumber("4567890123");
		user4.setAdmin(false);

		User user5 = new User();
		user5.setName("Markos");
		user5.setSurname("Antoniou");
		user5.setAddress("Komotinis 253");
		user5.setPhoneNumber("6908765432");
		user5.setEmail("markos@mail.com");
		user5.setUsername("Mark");
		user5.setPassword("Antoniou17!");
		user5.setVatNumber("5678901234");
		user5.setAdmin(false);

		//Wrong Phone Number
			User user6 = new User();
		user6.setName("Dimitris");
		user6.setSurname("Antoniadis");
		user6.setAddress("Harilaou 17");
		user6.setPhoneNumber("699876543");
		user6.setEmail("dimitris@mail.com");
		user6.setUsername("Dimi");
		user6.setPassword("Dimitris18!");
		user6.setVatNumber("6789012345");
		user6.setAdmin(false);

		//Wrong Email
		User user7 = new User();
		user7.setName("Stavros");
		user7.setSurname("Giannou");
		user7.setAddress("Oropou 1");
		user7.setPhoneNumber("6958475960");
		user7.setEmail("stavrogmail.com");
		user7.setUsername("Stavrog");
		user7.setPassword("Stavrog99!");
		user7.setVatNumber("7890123456");
		user7.setAdmin(false);

		//Wrong VatNumber
		User user8 = new User();
		user8.setName("Giorgos");
		user8.setSurname("Verikis");
		user8.setAddress("Solonos 32");
		user8.setPhoneNumber("6959375960");
		user8.setEmail("giorgosv@gmail.com");
		user8.setUsername("Giorgosv");
		user8.setPassword("Giorgosv99!");
		user8.setVatNumber("890123456");
		user8.setAdmin(false);

		//Wrong Password
		User user9 = new User();
		user9.setName("Valentinos");
		user9.setSurname("Rossi");
		user9.setAddress("Milano 32");
		user9.setPhoneNumber("6942425960");
		user9.setEmail("valentinor@gmail.com");
		user9.setUsername("Valentinor");
		user9.setPassword("Vale");
		user9.setVatNumber("9012345678");
		user9.setAdmin(false);

		Property property = new Property();
		property.setAddress("Manis 15");
		property.setConstructionYear(LocalDate.of(2020, 3, 8));
		property.setPropertyType(PropertyType.valueOf("DETACHED_HOUSE"));
		property.setUser(user);

		Property property1 = new Property();
		property1.setAddress("Kritis 23");
		property1.setConstructionYear(LocalDate.of(2019, 4, 7));
		property1.setPropertyType(PropertyType.valueOf("MAISONETTE"));
		property1.setUser(user1);
		
		Property property2 = new Property();
		property2.setAddress("Varis 39");
		property2.setConstructionYear(LocalDate.of(2018, 8, 9));
		property2.setPropertyType(PropertyType.valueOf("APARTMENT_BUILDING"));
		property2.setUser(user3);
		
		Property property3 = new Property();
		property3.setAddress("Thrakis 28");
		property3.setConstructionYear(LocalDate.of(2017, 1, 2));
		property3.setPropertyType(PropertyType.valueOf("APARTMENT_BUILDING"));
		property3.setUser(user2);
		
		Property property4 = new Property();
		property4.setAddress("Xanthis 11");
		property4.setConstructionYear(LocalDate.of(2021, 5, 3));
		property4.setPropertyType(PropertyType.valueOf("MAISONETTE"));
		property4.setUser(user4);
		
		Property property5 = new Property();
		property5.setAddress("Menelaou 8");
		property5.setConstructionYear(LocalDate.of(2021, 10, 6));
		property5.setPropertyType(PropertyType.valueOf("DETACHED_HOUSE"));
		property5.setUser(user3);

		Property property6 = new Property();
		property6.setAddress("Aristotelous 12");
		property6.setConstructionYear(LocalDate.of(2019, 8, 9));
		property6.setPropertyType(PropertyType.valueOf("DETACHED_HOUSE"));
		property6.setUser(user2);

		Property property7 = new Property();
		property7.setAddress("Ergoteli 19");
		property7.setConstructionYear(LocalDate.of(2021, 2, 5));
		property7.setPropertyType(PropertyType.valueOf("MAISONETTE"));
		property7.setUser(user);

		//Wrong User (He has wrong Email)
		Property property8 = new Property();
		property8.setAddress("Ergoteli19");
		property8.setConstructionYear(LocalDate.of(2021, 2, 5));
		property8.setPropertyType(PropertyType.valueOf("APARTMENT_BUILDING"));
		property8.setUser(user7);

		PropertyRepair propertyRepair = new PropertyRepair();
		propertyRepair.setDateTime(LocalDate.of(2020, 3, 8));
		propertyRepair.setSummary("Leaking floor");
		propertyRepair.setRepairType(RepairType.valueOf("PLUMBING"));
		propertyRepair.setStatusType(StatusType.valueOf("PENDING"));
		propertyRepair.setCost(new BigDecimal("5000"));
		propertyRepair.setRepairDesc("Change pipes under floor");
		propertyRepair.setProperty(property1);

		PropertyRepair propertyRepair1 = new PropertyRepair();
		propertyRepair1.setDateTime(LocalDate.of(2020, 10, 7));
		propertyRepair1.setSummary("Lights out of order");
		propertyRepair1.setRepairType(RepairType.valueOf("ELECTRICAL_WORK"));
		propertyRepair1.setStatusType(StatusType.valueOf("IN_PROGRESS"));
		propertyRepair1.setCost(new BigDecimal("2350"));
		propertyRepair1.setRepairDesc("Change the electrical system of the kitchen");
		propertyRepair1.setProperty(property2);
		
		PropertyRepair propertyRepair2 = new PropertyRepair();
		propertyRepair2.setDateTime(LocalDate.of(2020, 11, 7));
		propertyRepair2.setSummary("Walls not painted");
		propertyRepair2.setRepairType(RepairType.valueOf("PAINTING"));
		propertyRepair2.setStatusType(StatusType.valueOf("PENDING"));
		propertyRepair2.setCost(new BigDecimal("500"));
		propertyRepair2.setRepairDesc("Change the color of the walls to green");
		propertyRepair2.setProperty(property);
		
		PropertyRepair propertyRepair3 = new PropertyRepair();
		propertyRepair3.setDateTime(LocalDate.of(2021, 6, 2));
		propertyRepair3.setSummary("Windows broken");
		propertyRepair3.setRepairType(RepairType.valueOf("FRAMES"));
		propertyRepair3.setStatusType(StatusType.valueOf("IN_PROGRESS"));
		propertyRepair3.setCost(new BigDecimal("1200"));
		propertyRepair3.setRepairDesc("New windows throughout the whole house");
		propertyRepair3.setProperty(property);
		
		PropertyRepair propertyRepair4 = new PropertyRepair();
		propertyRepair4.setDateTime(LocalDate.of(2018, 6, 2));
		propertyRepair4.setSummary("Toilet problems");
		propertyRepair4.setRepairType(RepairType.valueOf("PLUMBING"));
		propertyRepair4.setStatusType(StatusType.valueOf("COMPLETE"));
		propertyRepair4.setCost(new BigDecimal("2500"));
		propertyRepair4.setRepairDesc("Changed pipes inside the bathroom under the sink");
		propertyRepair4.setProperty(property3);
		
		PropertyRepair propertyRepair5 = new PropertyRepair();
		propertyRepair5.setDateTime(LocalDate.of(2022, 1, 1));
		propertyRepair5.setSummary("Basement Lights");
		propertyRepair5.setRepairType(RepairType.valueOf("ELECTRICAL_WORK"));
		propertyRepair5.setStatusType(StatusType.valueOf("IN_PROGRESS"));
		propertyRepair5.setCost(new BigDecimal("700"));
		propertyRepair5.setRepairDesc("Changed pipes inside the bathroom under the sink");
		propertyRepair5.setProperty(property3);

		PropertyRepair propertyRepair6 = new PropertyRepair();
		propertyRepair6.setDateTime(LocalDate.of(2021, 4, 8));
		propertyRepair6.setSummary("Cold rooms");
		propertyRepair6.setRepairType(RepairType.valueOf("INSULATION"));
		propertyRepair6.setStatusType(StatusType.valueOf("IN_PROGRESS"));
		propertyRepair6.setCost(new BigDecimal("2700"));
		propertyRepair6.setRepairDesc("Puting good stuff inside the walls in order to keep the house warm");
		propertyRepair6.setProperty(property6);

		//Wrong Cost
		PropertyRepair propertyRepair7 = new PropertyRepair();
		propertyRepair7.setDateTime(LocalDate.of(2022, 1, 3));
		propertyRepair7.setSummary("Walls falling");
		propertyRepair7.setRepairType(RepairType.valueOf("PAINTING"));
		propertyRepair7.setStatusType(StatusType.valueOf("IN_PROGRESS"));
		propertyRepair7.setCost(new BigDecimal("-900"));
		propertyRepair7.setRepairDesc("Rub all the walls and then paint them once with astari and two times with new colour");
		propertyRepair7.setProperty(property5);

		//Property not exists
		PropertyRepair propertyRepair8 = new PropertyRepair();
		propertyRepair8.setDateTime(LocalDate.of(2022, 1, 3));
		propertyRepair8.setSummary("Water on the roof");
		propertyRepair8.setRepairType(RepairType.valueOf("FRAMES"));
		propertyRepair8.setStatusType(StatusType.valueOf("PENDING"));
		propertyRepair8.setCost(new BigDecimal("500"));
		propertyRepair8.setRepairDesc("Change the windows on the roof, as water comes in when it rains");
		propertyRepair8.setProperty(property8);

		
		// create the services by injecting the repositories inside them,
		// at the same time we inject the entity managers into the repositories.
		
		AdminService adminService = new AdminServiceImpl(
				new DbUserRepositoryImpl( JpaUtil.getEntityManager()),
				new DbPropertyRepositoryImpl( JpaUtil.getEntityManager()),
				new DbPropertyRepairRepositoryImpl( JpaUtil.getEntityManager()));
	
		UserService userService = new UserServiceImpl(
				new DbPropertyRepositoryImpl( JpaUtil.getEntityManager()),
				new DbPropertyRepairRepositoryImpl( JpaUtil.getEntityManager()));
		
		/*
		adminService.addUser(user);
		adminService.addUser(user1);
		adminService.addUser(user2);
		adminService.addUser(user3);
		adminService.addUser(user4);
		adminService.addUser(user5);
		adminService.addUser(user6);
		adminService.addUser(user7);
		adminService.addUser(user8);
		adminService.addUser(user9);
		
		adminService.addProperty(property);
		adminService.addProperty(property1);
		adminService.addProperty(property2);
		adminService.addProperty(property3);
		adminService.addProperty(property4);
		adminService.addProperty(property5);
		adminService.addProperty(property6);
		adminService.addProperty(property7);
		adminService.addProperty(property8);
		
		adminService.addPropertyRepair(propertyRepair);
		adminService.addPropertyRepair(propertyRepair1);
		adminService.addPropertyRepair(propertyRepair2);
		adminService.addPropertyRepair(propertyRepair3);
		adminService.addPropertyRepair(propertyRepair4);
		adminService.addPropertyRepair(propertyRepair5);
		adminService.addPropertyRepair(propertyRepair6);
		adminService.addPropertyRepair(propertyRepair7);
		adminService.addPropertyRepair(propertyRepair8);
		*/
		
		//	TESTS ALL READS
		
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
				,PropertyType.APARTMENT_BUILDING); 		// true
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
		System.out.println("r="+r);						// true
		
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
		System.out.println("z="+z);						// true
		
		boolean y = 
		adminService.deleteProperty( 
				adminService.readPropertyWithVatNumber(
						"1234567890").get(0));
		System.out.println("y="+y);						// true
		
		boolean x = 
		adminService.deleteUser( 
				adminService.readUserWithVatNumber("1234567890"));
		System.out.println("x="+x);						// true
		
		boolean xx = 
		adminService.deleteUser( 
				adminService.readUserWithVatNumber("0000000000"));
		System.out.println("xx="+xx);					// false
    }
}
