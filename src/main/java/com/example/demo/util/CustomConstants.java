package com.example.demo.util;

public class   CustomConstants {
	
	public CustomConstants() {
		
	}
	public static final String  USERNAME_EMPTY_MSG ="Please enter the username";
	
	public static final String PASSWORD_EMPTY_MSG ="Please enter the password";
	
	public static final String IP_EMPTY_MSG ="Please enter the IP address";
	
	public static final String INVALID_PASSWORD_MSG ="Password need to be greater than 8 characters,containing at least 1 number,at least captialized letter, at least 1 special character in set of '_#&%.";
	
	public static final String PASSWORD_PATTERN ="^.*(?=.{9,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[_#&%.]).*$";
	
	public static final String IP_PATTERN ="^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$";
	
	public static final String INVALID_IP_MSG ="Please enter the valid IP address";

	

}
