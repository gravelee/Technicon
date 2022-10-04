package com.technicon.renovationcontractorapp.exception;

/**
 *  This class is a custom exception of our application.
 *  This is called when the address has inappropriate 
 *  value.
 * 
 *  @author Grproth, skroutzzz, Chris394
 */
public class InappropriateAddressValueException extends Exception{

	public InappropriateAddressValueException( final String errorMessage) {
        
        super(errorMessage);
    }
}
