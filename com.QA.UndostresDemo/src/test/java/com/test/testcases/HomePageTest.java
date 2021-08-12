package com.test.testcases;

import com.test.pages.*;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;

public class HomePageTest extends BaseTest{
	public static final Logger log =	Logger.getLogger(HomePageTest.class.getName());
	public String operator, rechanrgeAmount;
	public long mobileNumber;
  @BeforeClass
  public void beforeClass() throws Exception {
	  operator 			= readPropertyFile.getPropValue(homePropFile, "OperatorValue");
	  mobileNumber 		= Long.parseLong(readPropertyFile.getPropValue(homePropFile, "MobileNum"));  
	  rechanrgeAmount 	= readPropertyFile.getPropValue(homePropFile, "RechargeAmount");  
  }

  @Test
  public void mobileRechargeTest() {
  try {
	  long mobNum = 8465433546L;
	  String appURL = readPropertyFile.getPropValue(configFile, "homePageURL");   
	  homePage.openPage(appURL);
	  homePage.clickOperatorField();
	  homePage.selectOperatorValue(operator);
	  homePage.enterMobileNumber(mobileNumber);
	  homePage.enterRechargeAmount(rechanrgeAmount);
	  homePage.clickNextButton();
  }	catch	(Exception e) {
	  log.error("Error");
	  e.printStackTrace();
  }
  }
  
}
