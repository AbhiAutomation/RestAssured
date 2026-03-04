package com.blackrock.qa.api_automation.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

	public static final Logger logger = LogManager.getLogger(TestListeners.class);
	
 public	void onStart(ITestContext context) {
	    logger.info("Starting test suite: ",  this.getClass().getSimpleName(), context.getName());
	  }
 public  void onFinish(ITestContext context) {
	    logger.info("Finished test suite: ");
	  }
 
  public void onTestSuccess(ITestResult result) {
	   logger.info("Passed !"+result.getMethod().getMethodName());
	   logger.info("Description"+result.getMethod().getDescription());
	  }
  
  public void onTestFailure(ITestResult result) {
	   logger.error("Failed !"+result.getMethod().getMethodName());
	    // not implemented
	  }
  public void onTestSkipped(ITestResult result) {
	   logger.info("Skipped !"+result.getMethod().getMethodName());
	  }
  
  public void onTestStart(ITestResult result) {
	    logger.info("Starting test: "+result.getMethod().getMethodName());

	    logger.info("Description"+result.getMethod().getDescription());
	  }
}
