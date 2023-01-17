package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.exceptions.InvalidIpLocationException;
import com.example.demo.payload.User;
import com.example.demo.payload.UserResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RegistrationService {
	
	   private static  Logger logger = LoggerFactory.getLogger(RegistrationService.class);

	
	public UserResponse saveUser(User user) throws JsonMappingException, JsonProcessingException  {

		UserResponse response = new UserResponse();
		String cityName = validateIPLocation(user.getIpAddress());
		logger.info(" requested user city is  {} ",cityName);

	    String uuid = UUID.randomUUID().toString().replace("-", "");
	    
	    response.setUuId(uuid);
	    response.setWelcomeMessage("Hi "+user.getUsername()+" from "+cityName);
	    
	    return response;
	}
	
	
	public String  validateIPLocation(String ipaddress) throws JsonMappingException, JsonProcessingException  {
		
		
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "http://ip-api.com/json/";
		
		ResponseEntity<String> response  = restTemplate.getForEntity(fooResourceUrl+ipaddress, String.class);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());
		JsonNode countryCode = root.path("countryCode");
		
		if(!countryCode.asText().equalsIgnoreCase("CA")){
			logger.error(" request has country code  is {} ", countryCode.asText());
			throw new InvalidIpLocationException(" given ip address not belongs to CANADA");
			
		}
		JsonNode cityName = root.path("city");
		
		return  cityName.asText();


	}

}
