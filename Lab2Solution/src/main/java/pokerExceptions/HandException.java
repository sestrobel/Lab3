package pokerExceptions;

import java.lang.reflect.Method;
import java.util.ArrayList;

import pokerBase.Hand;
import pokerEnums.eHandStrength;
import pokerEnums.eHandExceptionType;

public class HandException extends Exception{
	
	private Hand h;
	private ArrayList<Hand> hands;
	
	public HandException(Hand h, String message) {
		super(message);
		this.h = h;
	}//had gibbons help
	
	public HandException(ArrayList<Hand> hands, String message) {
			super(message);
			this.hands = hands;
	} 
}
