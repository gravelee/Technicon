package com.technicon.renovationcontractorapp.exception;

/**
 *  This class is a custom exception of our application.
 *  This is called when the vat number has inappropriate 
 *  value.
 * 
 *  @author Grproth, skroutzzz, Chris394
 */
public class InappropriateVatNumberValueException extends Exception{

	public InappropriateVatNumberValueException( final String errorMessage) {
        
        super(errorMessage);
    }
}
