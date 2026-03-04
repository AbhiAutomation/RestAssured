package com.blackrock.qa.api_automation.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoginFilter  implements Filter {
   public static final  Logger logger = LogManager.getLogger(LoginFilter.class);
	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		
		logRequest(requestSpec);
		 Response response =  ctx.next(requestSpec, responseSpec); //proceed with the request and get the response
		 logResponse(response);
		 
		 return response;// return the response to the next filter in the chain or to the caller if this is the last filter	
	}
	
	public void logRequest(FilterableRequestSpecification requestSpec) {
		logger.info("Request Method => " + requestSpec.getMethod());
		logger.info("Request  BASE URI => " + requestSpec.getURI());
		logger.info("Request Headers => " + requestSpec.getHeaders());
		logger.info("Request Body => " + requestSpec.getBody());

	}
	
	public void logResponse(Response response) {	
		logger.info("Response Status Code => " + response.getStatusCode());
		logger.info("Response Headers => " + response.getHeaders());
		logger.info("Response Body => " + response.asPrettyString());
		
	}

	

}
