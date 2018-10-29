package com.capgemini.doctors.invalidinputexception;

@SuppressWarnings("serial")
public class InvalidInputExcetion extends RuntimeException{
	
	public InvalidInputExcetion(String msg) {
		super(msg);
	}
	
	public void InvalidException(String msg) {
		System.out.println("DISAPPROVED");
	}

}
