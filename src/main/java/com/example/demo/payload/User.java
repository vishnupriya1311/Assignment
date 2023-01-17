package com.example.demo.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.example.demo.util.CustomConstants;


public class User {
	
    @NotBlank(message =CustomConstants.USERNAME_EMPTY_MSG)
	private String username;
	
    @NotBlank(message = CustomConstants.USERNAME_EMPTY_MSG)
    @Pattern(regexp = CustomConstants.PASSWORD_PATTERN , message =CustomConstants.INVALID_PASSWORD_MSG)
	private String password;
    @NotBlank(message = CustomConstants.IP_EMPTY_MSG)
    @Pattern(regexp = CustomConstants.IP_PATTERN, message=CustomConstants.INVALID_IP_MSG)
	private String ipAddress;

	
	public User(String username, String password, String ipAddress) {
		this.username = username;
		this.password = password;
		this.ipAddress = ipAddress;
	}

	public User() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", ipAddress=" + ipAddress + "]";
	}

}
