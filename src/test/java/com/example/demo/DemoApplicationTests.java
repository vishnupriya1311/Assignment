package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.payload.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;


	@Test
	public void ProcessRequest_success() throws Exception {
		User user = new User("Vishnupriya", "Abcdef#123","24.48.0.1");
		ObjectMapper objectMapper = new ObjectMapper();

		mockMvc.perform(post("/api/v1/registration")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(user)))
		.andDo(print())
		.andExpect(status().isOk());
	}
	
	@Test
	public void test_username_is_null() throws Exception {
		User user = new User();
		user.setIpAddress("24.48.0.1");
		user.setPassword("Abcdef#123");
		ObjectMapper objectMapper = new ObjectMapper();

		mockMvc.perform(post("/api/v1/registration")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(user)))
		.andExpect(status().isBadRequest());

	}
	
	@Test
	public void test_username_is_blank() throws Exception {
		User user = new User();
		user.setIpAddress("24.48.0.1");
		user.setPassword("Abcdef#123");
		user.setUsername("     ");
		ObjectMapper objectMapper = new ObjectMapper();

		mockMvc.perform(post("/api/v1/registration")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(user)))
		.andExpect(status().isBadRequest());

	}
	@Test
	public void test_password_is_null() throws Exception {
		User user = new User();
		user.setIpAddress("24.48.0.1");
		user.setUsername("Vishnupriya");
		ObjectMapper objectMapper = new ObjectMapper();

		mockMvc.perform(post("/api/v1/registration")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(user)))
		.andExpect(status().isBadRequest());

	}
	@Test
	public void test_password_is_Invalid() throws Exception {
		User user = new User();
		user.setIpAddress("24.48.0.1");
		user.setUsername("Vishnupriya");
		user.setPassword("ABCDFEG");
		ObjectMapper objectMapper = new ObjectMapper();

		mockMvc.perform(post("/api/v1/registration")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(user)))
		.andExpect(status().isBadRequest());

	}
	@Test
	public void test_IP_is_null() throws Exception {
		User user = new User();
		user.setUsername("Vishnupriya");
		user.setPassword("Abcdef#123");

		ObjectMapper objectMapper = new ObjectMapper();

		mockMvc.perform(post("/api/v1/registration")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(user)))
		.andExpect(status().isBadRequest());

	}
	@Test
	public void test_IP_Country() throws Exception {
		User user = new User();
		user.setUsername("Vishnupriya");
		user.setPassword("Abcdef#123");
		user.setIpAddress("192.168.0.106");

		ObjectMapper objectMapper = new ObjectMapper();

		mockMvc.perform(post("/api/v1/registration")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(user)))
		.andExpect(status().isBadRequest());

	}

}
