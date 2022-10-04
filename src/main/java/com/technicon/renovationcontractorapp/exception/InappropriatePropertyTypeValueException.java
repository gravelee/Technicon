package com.technicon.renovationcontractorapp.exception;

/**
 *  This class is a custom exception of our application.
 *  This is called when the property type has inappropriate 
 *  value.
 * 
 *  @author Grproth, skroutzzz, Chris394
 */
public class InappropriatePropertyTypeValueException extends Exception{

	public InappropriatePropertyTypeValueException( final String errorMessage) {
        
        super(errorMessage);
    }
}
