package com.technicon.renovationcontractorapp.exception;

/**
 *  This class is a custom exception of our application.
 *  This is called when the date has inappropriate 
 *  value.
 * 
 *  @author Grproth, skroutzzz, Chris394
 */
public class InappropriateDateValueException extends Exception{

	public InappropriateDateValueException( final String errorMessage) {
        
        super(errorMessage);
    }
}
