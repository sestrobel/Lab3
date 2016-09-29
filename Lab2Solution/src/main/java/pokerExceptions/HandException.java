package pokerExceptions;

import java.lang.reflect.Method;

import pokerBase.Hand;
import pokerEnums.eHandStrength;
import pokerEnums.eHandExceptionType;

public class HandException extends Exception{
	
	private Hand h;
	
	public HandException(Hand h, String message) {
		super(message);
		this.h = h;
		
	} //had gibbons help
}
