package com.blackrock.qa.api_automation.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.blackrock.qa.api_automation.base.AuthService;
import com.blackrock.qa.api_automation.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationApiTest {
	
	@Test (description = "Test to verify account creation API")
	public void testAccountCreation() {
		
		
		// Create a SignUpRequest object with the required details
		SignUpRequest signUpRequest = new SignUpRequest.Builder()
				.setUsername("newuser22221")
				.setPassword("Passwo2rd@1231")
				.setEmail("tes2t1690@gmail.com")
				.setFirstName("Hemant")
				.setLastName("Kumar")
				.setMobileNumber("9876543200")
				.build();
		
		// Create an instance of the AuthService
			AuthService authService = new AuthService();
		// Call the signUp method of AuthService to create a new account
		  Response response =authService.signup(signUpRequest);
		  System.out.println("Response Body is =>  " + response.asPrettyString());
		  Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
		 Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200");
		
	}
	
	@Test (description = " Forgot password API test")
	public void testForgotPassword() {
		
		AuthService authService = new AuthService();
		Response response = authService.forgot("aks.igec@gmail.com");
		System.out.println("Response Body is =>  " + response.asPrettyString());
	}
}
