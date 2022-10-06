package com.technicon.renovationcontractorapp.exception;

/**
 *  This class is a custom exception of our application.
 *  This is called when the id has inappropriate 
 *  value.
 * 
 *  @author Grproth, skroutzzz, Chris394
 */
public class InappropriateIdValueException extends Exception{

	public InappropriateIdValueException( final String errorMessage) {
        
        super(errorMessage);
    }
}
