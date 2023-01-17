package com.example.demo.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payload.User;
import com.example.demo.payload.UserResponse;
import com.example.demo.service.RegistrationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/api/v1")
public class RegistrationController {
	
   private static  Logger logger = LoggerFactory.getLogger(RegistrationController.class);

	@Autowired
	private RegistrationService registrationService;
	@PostMapping("/registration")
	public ResponseEntity<UserResponse> resigration(@Valid @RequestBody 	User user) throws JsonMappingException, JsonProcessingException {
		
		logger.info(" Registration  requested by {} ",user.getUsername());
		
		UserResponse response =registrationService.saveUser(user);
		 return  new ResponseEntity<>(response,HttpStatus.OK);
		
	}

}
