package com.technicon.renovationcontractorapp.exception;

/**
 *  This class is a custom exception of our application.
 *  This is called when the property id has inappropriate 
 *  value.
 * 
 *  @author Grproth, skroutzzz, Chris394
 */
public class InappropriatePropertyIdValueException extends Exception{

	public InappropriatePropertyIdValueException( final String errorMessage) {
        
        super(errorMessage);
    }
}
