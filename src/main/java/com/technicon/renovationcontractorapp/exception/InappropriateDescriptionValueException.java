package com.technicon.renovationcontractorapp.exception;

/**
 *  This class is a custom exception of our application.
 *  This is called when the description has inappropriate 
 *  value.
 * 
 *  @author Grproth, skroutzzz, Chris394
 */
public class InappropriateDescriptionValueException extends Exception{

	public InappropriateDescriptionValueException( final String errorMessage) {
        
        super(errorMessage);
    }
}
