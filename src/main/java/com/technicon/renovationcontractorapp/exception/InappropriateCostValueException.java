package com.technicon.renovationcontractorapp.exception;

/**
 *  This class is a custom exception of our application.
 *  This is called when the coost has inappropriate value.
 * 
 *  @author Grproth, skroutzzz, Chris394
 */
public class InappropriateCostValueException extends Exception{

	public InappropriateCostValueException( final String errorMessage) {
        
        super(errorMessage);
    }
}
