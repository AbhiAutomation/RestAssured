package com.blackrock.qa.api_automation.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.blackrock.qa.api_automation.base.AuthService;
import com.blackrock.qa.api_automation.base.UserProfileManagementService;
import com.blackrock.qa.api_automation.models.request.LoginRequest;
import com.blackrock.qa.api_automation.models.request.ProfileRequest;
import com.blackrock.qa.api_automation.models.response.LoginResponse;
import com.blackrock.qa.api_automation.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {
	@Test (description = "Verify that user can update their profile information successfully")
	
	public void testUpdateProfile() {
	//Meting the token using login API
		
		AuthService authService = new AuthService();
		 Response response= authService.login(new LoginRequest("aks.igec@gmail.com","Kripalukunj@99"));
		 System.out.println("Login Response => " + response.asPrettyString());
		 LoginResponse loginResponse = response.as(LoginResponse.class);
		 
		 System.out.println("Token => " + loginResponse.getToken());
		 System.out.println("==============================================================================");
			 
		 //Creating the profile request payload using builder pattern and passing the updated details for the profile
		 ProfileRequest   profileRequest=  new ProfileRequest.Builder()
				 			
		                   .setFirstName("Abhisheks")
		                   .setLastName("Sonis")
		                   .setEmail("aks.igec@gmail.com")
		                   .setMobileNumber("9632409384")
		                   .build();
		 UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		 response	=	userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);
		 System.out.println("Update Profile Response => " + response.asPrettyString());
		 
		 System.out.println("========================deserization ======================================================");
	     UserProfileResponse userProfileResponse= response.as(UserProfileResponse.class);
	    //asserting the response
	     Assert.assertEquals(userProfileResponse.getFirstName(), "Abhisheks", "Email should match the expected value");
	}

}
