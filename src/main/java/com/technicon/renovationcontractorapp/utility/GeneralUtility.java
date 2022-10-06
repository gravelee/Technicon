package com.technicon.renovationcontractorapp.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.technicon.renovationcontractorapp.domain.PropertyType;
import com.technicon.renovationcontractorapp.domain.RepairType;
import com.technicon.renovationcontractorapp.domain.StatusType;
import com.technicon.renovationcontractorapp.model.Property;
import com.technicon.renovationcontractorapp.model.PropertyRepair;
import com.technicon.renovationcontractorapp.model.User;

public class GeneralUtility {

	private static final String USER_FILE_NAME = "users.csv";
    private static final String PROPERTIES_FILE_NAME = "properties.csv";
    private static final String PROPERTY_REPAIRS_FILE_NAME = "repairs.csv";
	
	/**
     *  Reads the .csv file into a list of String arrays.
     * 
     *  @param  fileName                ( the file name of the data red)          
     *  @return List of String arrays.  ( the data returned in a list)
     */
    @SuppressWarnings("resource")
	public static List<String[]> readCsvFile( final String fileName) {
        
        List<String[]> list = new ArrayList<>();
        BufferedReader br;
        
        try {
            
            br = new BufferedReader( new FileReader(fileName));
             
            String str;

            while( ( str = br.readLine()) != null) {

                list.add( str.split(","));
            }
        
        }catch( Exception ex) {
            
            System.out.println( "Problem openning the file " + fileName + "!");
            return null;
        }
        
        return list;
    }
    
    /**
     *  We load the data of a .csv file and then we write them into the 
     *  user list.
     */
    public List<User> loadUserData() {
        
        List<String[]> list = GeneralUtility.readCsvFile(USER_FILE_NAME);
        
        String name, surname, address, phoneNumber, email, 
        		username, password, vatNumber;
        boolean isAdmin;
        List<User> users = new ArrayList<>();

        for( String[] temp: list) {

        	name = temp[0];
        	surname = temp[1];
        	address = temp[2];
        	phoneNumber = temp[3];
        	email = temp[4];
        	username = temp[5];
        	password = temp[6];
        	vatNumber = temp[7];
        	isAdmin = Boolean.valueOf(temp[8]);
        	
            users.add( new User( name,surname,address,phoneNumber,
            		email,username,password,vatNumber,isAdmin));

        }
        
        return users;
    }
    
    /**
     *  We load the data of a .csv file and then we write them into the 
     *  user list.
     */
    public List<Property> loadPropertyData() {
        
        List<String[]> list = GeneralUtility.readCsvFile(PROPERTIES_FILE_NAME);
        
        String address;
        LocalDate constructionYear;
        PropertyType propertyType;
        
        List<Property> properties = new ArrayList<>();

        for( String[] temp: list) {

        	address = temp[0];
        	constructionYear = LocalDate.parse(temp[1]);
        	propertyType = PropertyType.valueOf(temp[1]);
        	
            properties.add( new Property( address, 
            	constructionYear, propertyType));

        }
        
        return properties;
    }
    
    /**
     *  We load the data of a .csv file and then we write them into the 
     *  user list.
     */
    public List<PropertyRepair> loadRepairsData() {
        
        List<String[]> list = GeneralUtility.readCsvFile(PROPERTY_REPAIRS_FILE_NAME);
        
        LocalDate dateTime;
		String summary,repairDesc;
		RepairType repairType;
		StatusType statusType;
		BigDecimal cost;
        List<PropertyRepair> repairs = new ArrayList<>();

        for( String[] temp: list) {

        	dateTime = LocalDate.parse(temp[0]);
        	summary = temp[1];
        	repairType = RepairType.valueOf(temp[2]);
        	statusType = StatusType.valueOf(temp[3]);
        	cost = BigDecimal.valueOf(Double.parseDouble(temp[3]));
        	repairDesc = temp[4];
        	
        	repairs.add( new PropertyRepair( dateTime, summary, repairType,
        			statusType,cost,repairDesc));

        }
        
        return repairs;
    }
}
