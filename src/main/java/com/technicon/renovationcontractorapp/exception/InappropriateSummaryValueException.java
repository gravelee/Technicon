package com.technicon.renovationcontractorapp.exception;

/**
 *  This class is a custom exception of our application.
 *  This is called when the summary has inappropriate 
 *  value.
 * 
 *  @author Grproth, skroutzzz, Chris394
 */
public class InappropriateSummaryValueException extends Exception{

	public InappropriateSummaryValueException( final String errorMessage) {
        
        super(errorMessage);
    }
}
