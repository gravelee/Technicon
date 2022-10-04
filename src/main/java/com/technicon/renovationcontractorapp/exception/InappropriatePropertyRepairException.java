package com.technicon.renovationcontractorapp.exception;

/**
 *  This class is a custom exception of our application.
 *  This is called when the property repair is null or 
 *  one of the property repairs attributes has 
 *  inappropriate value.
 * 
 *  @author Grproth, skroutzzz, Chris394
 */
public class InappropriatePropertyRepairException extends Exception{

	public InappropriatePropertyRepairException( final String errorMessage) {
        
        super(errorMessage);
    }
}
