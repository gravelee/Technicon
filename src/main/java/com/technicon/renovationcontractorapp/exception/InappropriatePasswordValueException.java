package com.technicon.renovationcontractorapp.exception;

/**
 *  This class is a custom exception of our application.
 *  This is called when the password has inappropriate 
 *  value.
 * 
 *  @author Grproth, skroutzzz, Chris394
 */
public class InappropriatePasswordValueException extends Exception{

	public InappropriatePasswordValueException( final String errorMessage) {
        
        super(errorMessage);
    }
}
