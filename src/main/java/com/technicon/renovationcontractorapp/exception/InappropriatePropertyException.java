package com.technicon.renovationcontractorapp.exception;

/**
 *  This class is a custom exception of our application.
 *  This is called when the property is null or one of the 
 *  propertys attributes has inappropriate value.
 * 
 *  @author Grproth, skroutzzz, Chris394
 */
public class InappropriatePropertyException extends Exception{

	public InappropriatePropertyException( final String errorMessage) {
        
        super(errorMessage);
    }
}
