package com.technicon.renovationcontractorapp.exception;

/**
 *  This class is a custom exception of our application.
 *  This is called when the repair type has inappropriate 
 *  value.
 * 
 *  @author Grproth, skroutzzz, Chris394
 */
public class InappropriateRepairTypeValueException extends Exception{

	public InappropriateRepairTypeValueException( final String errorMessage) {
        
        super(errorMessage);
    }
}
