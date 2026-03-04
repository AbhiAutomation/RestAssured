package com.blackrock.qa.api_automation.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.blackrock.qa.api_automation.base.AuthService;
import com.blackrock.qa.api_automation.models.request.LoginRequest;
import com.blackrock.qa.api_automation.models.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.blackrock.qa.api_automation.listeners.TestListeners.class)
public class LoginApiTest {
	
	private static final Logger logger = LogManager.getLogger(LoginApiTest.class);
	@Test(description = "Test login API with valid credentials")
	public void  loginTest() {
		/***
		 *  Created POJO class for login request payload and using that class to create an object of login request and passing 
			the data to constructor of login request class and then passing that object
			to login method of auth service class and rest assured will handle the serialization of object to json
		 * 
		 */
		LoginRequest loginRequest = new LoginRequest("aks.igec@gmail.com", "Kripalukunj@99");//POJO Object
		AuthService authService =  new AuthService();
		Response response= authService.login(loginRequest);//rest assured will handle the serialization of object to jsonand make sure  jackson dependency is added in pom.xml for serialization and deserialization of json to object and object to json
		logger.info("Login API Response => " + response.asPrettyString());
		LoginResponse loginResponse=response.as(LoginResponse.class);//Deserialization of response to LoginResponse class object
	    
		System.out.println("Response Body is =>  " + response.asPrettyString());
		System.out.println("Token is =>  " + loginResponse.getToken());
		loginResponse.getRoles().forEach(role -> System.out.println("Role is =>  " + role));
		System.out.println("Username is =>  " + loginResponse.getUsername());
		System.out.println("Email is =>  " + loginResponse.getEmail());
		System.out.println("ID is =>  " + loginResponse.getId());
		
		Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200");
		Assert.assertNotNull(loginResponse.getToken(), "Token should not be null");
		Assert.assertEquals(loginResponse.getUsername(), "aks.igec@gmail.com", "Username should match the request");
		Assert.assertEquals(loginResponse.getEmail(), "aks.igec@gmail.com", "Email should match the request");
		
		
		
		
		
		
	}
	
	/***
	 * Test login API with out using rest assured wrapper
	 * 
	 * public void  loginTest() {
		
		LoginRequest loginRequest = new LoginRequest("aks.igec@gmail.com", "Kripalukunj@99");
	
		AuthService authService = new AuthService();
		Response response= authService.login("{ \"username\":\"aks.igec@gmail.com\", \"password\":\"Kripalukunj@99\" }");
		
		System.out.println("Response Body is =>  " + response.asPrettyString());
		
		
		
	}

	 *
	 */
	
	/**
	 * Test login API with out using rest assured wrapper
	 * 
	 * 	@Test(description = "Test login API with valid credentials")
	public void  loginTest() {
	     Response response = given().baseUri("http://64.227.160.186:8080")
	    		 .header("Content-Type", "application/json").body("{ \"username\":\"aks.igec@gmail.com\", \"password\":\"Kripalukunj@99\" }").post("/api/auth/login");
	     System.out.println("Response Body is =>  " + response.asPrettyString());
	}
	 */

}
