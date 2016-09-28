package pokerExceptions;

import java.lang.reflect.Method;

import pokerBase.Hand;
import pokerEnums.eHandStrength;

public class HandException extends Exception{
	public HandException(String message) {
		super(message);
	} 
//	public HandException(Hand h, HandException ShortHand, String message) {
//		super(message);
//	} Not sure, but doesn't seem right idk how to catch yet - liz
}
