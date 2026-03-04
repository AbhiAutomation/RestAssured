package com.blackrock.qa.api_automation.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.blackrock.qa.api_automation.base.AuthService;
import com.blackrock.qa.api_automation.base.UserProfileManagementService;
import com.blackrock.qa.api_automation.models.request.LoginRequest;
import com.blackrock.qa.api_automation.models.response.LoginResponse;
import com.blackrock.qa.api_automation.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {
	@Test (description = "Verify that user can get profile details with valid token")
	public void testGetProfileWithValidToken() {
	//Step 1: Login to get the token  login  into the service and get the token for authentication. We will use the login method from AuthService class to perform login and get the token from the response
	//Step 2: Get profile details using the token
	//Step 3: Assert the response
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("aks.igec@gmail.com", "Kripalukunj@99"));
	//	System.out.println("response 1===>"+response.asPrettyString());
		//Deserialization of response to get the token from the response body
		LoginResponse loginResponse = response.as(LoginResponse.class);//object mapping of response body to LoginResponse class
	//	System.out.println(loginResponse.getToken());
		
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.getProfile(loginResponse.getToken());
	//	System.out.println("response 2===>"+response.asPrettyString());
		
		UserProfileResponse userProfileResponse=  response.as(UserProfileResponse.class);
		System.out.println("User Profile Details => " + userProfileResponse);
		Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200");
		Assert.assertEquals(userProfileResponse.getEmail(), "aks.igec@gmail.com", "Email should match the expected value");
		Assert.assertEquals(userProfileResponse.getUsername(), "aks.igec@gmail.com", "Username should match the expected value");
		Assert.assertEquals(userProfileResponse.getFirstName(), "Abhishek", "First name should match the expected value");
		Assert.assertEquals(userProfileResponse.getLastName(), "soni", "Last name should match the expected value");
		Assert.assertEquals(userProfileResponse.getMobileNumber(), "9632409387", "Mobile number should match the expected value");
		Assert.assertEquals(userProfileResponse.getId(), 4573, "ID should match the expected value");
	
		
	}

}
