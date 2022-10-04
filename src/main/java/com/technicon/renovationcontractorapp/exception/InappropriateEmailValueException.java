package com.technicon.renovationcontractorapp.exception;

/**
 *  This class is a custom exception of our application.
 *  This is called when the email has inappropriate 
 *  value.
 * 
 *  @author Grproth, skroutzzz, Chris394
 */
public class InappropriateEmailValueException extends Exception{

	public InappropriateEmailValueException( final String errorMessage) {
        
        super(errorMessage);
    }
}
