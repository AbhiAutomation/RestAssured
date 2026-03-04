package com.blackrock.qa.api_automation.base;


import static io.restassured.RestAssured.given;

import com.blackrock.qa.api_automation.filters.LoginFilter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class BaseService {
	
	//Wraper  for rest assured API call
	//base URI 
	//handle request and response
	private  static  final String BASE_URI = "http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;
	
	static {
		RestAssured.filters(new LoginFilter());
	}
	
	//constructor to initialize request specification
	 public BaseService() {
		 requestSpecification =  given().baseUri(BASE_URI);
	 }
	 /**
	  * 
	  * Initially our BaseService was tightly coupled to specific request types. 
	  * We refactored it using polymorphism by accepting Object as payload. 
	  * Since every POJO extends Object implicitly, this made our framework loosely coupled and scalable
	  */
	 
	/**
	 * 
	 * @param payload
	 * @param endpoint
	 * @return
	 */
	 protected  Response postRequest(Object payload, String endpoint) {
	  
		 return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	 }
	 
	 
	 protected  Response putRequest(Object payload, String endpoint) {
		  
		 return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
	 }
	 
	 
	 protected  Response getRequest(String endpoint) {
		  
		 return requestSpecification.get(endpoint);
	 
	 }
	 
	 
	 protected  void setAuthToken(String token) {
		 requestSpecification.header("Authorization", "Bearer " + token);
	 }
	 /**
	  * 
	  *base URI is common for all services but if we want to override base URI for specific service then
	  * we can use below method which accepts base URI as parameter and override the base URI for that 
	  * specific service
	 /***
	  */
	  
	 protected  Response postRequest(String baseUrl, Object payload, String endpoint) {
		  
		 return requestSpecification.baseUri(baseUrl).contentType(ContentType.JSON).body(payload).post(endpoint);
	 }
	 
	 
}