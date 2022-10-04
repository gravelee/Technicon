package com.technicon.renovationcontractorapp.exception;

/**
 *  This class is a custom exception of our application.
 *  This is called when the construction year has 
 *  inappropriate value.
 * 
 *  @author Grproth, skroutzzz, Chris394
 */
public class InappropriateConstructionYearValueException extends Exception{

	public InappropriateConstructionYearValueException( final String errorMessage) {
        
        super(errorMessage);
    }
}
