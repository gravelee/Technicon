package com.technicon.renovationcontractorapp.exception;

/**
 *  This class is a custom exception of our application.
 *  This is called when the user is null or one of the 
 *  users attributes has inappropriate value.
 * 
 *  @author Grproth, skroutzzz, Chris394
 */
public class InappropriateUserException extends Exception{

	public InappropriateUserException( final String errorMessage) {
        
        super(errorMessage);
    }
}
