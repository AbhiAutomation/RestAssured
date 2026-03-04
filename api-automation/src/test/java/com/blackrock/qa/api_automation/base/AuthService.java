package com.blackrock.qa.api_automation.base;

import java.util.HashMap;

import com.blackrock.qa.api_automation.models.request.LoginRequest;
import com.blackrock.qa.api_automation.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AuthService  extends BaseService {
	private static final String BASE_PATH = "/api/auth/"; // CONSTANT FOR BASE PATH OF AUTH SERVICE CONSTANT comes from Static  along with final why 

	
	//Method to perform login API call	from Swager documentation we know that login API is POST method and it accepts username and password in request body and returns token in response body
	public Response login( LoginRequest payload) {
		 return postRequest(payload, BASE_PATH + "login");
	}
	
	public Response signup( SignUpRequest signUpRequest) {
		 return postRequest(signUpRequest, BASE_PATH + "signup");
	}
	
	
	public Response forgot(String  emailAdress) {
		HashMap<String, String> payload = new HashMap<String,String>();
		payload.put("email", emailAdress);
		 return postRequest(payload , BASE_PATH + "forgot-password");
	}
	
}
