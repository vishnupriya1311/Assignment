package com.example.demo.payload;

public class UserResponse {
	
	private String uuId;
	
	private String welcomeMessage;

	public String getUuId() {
		return uuId;
	}

	public void setUuId(String uuId) {
		this.uuId = uuId;
	}

	public String getWelcomeMessage() {
		return welcomeMessage;
	}

	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}

	@Override
	public String toString() {
		return "UserResponse [uuId=" + uuId + ", welcomeMessage=" + welcomeMessage + "]";
	}
	
	

}
