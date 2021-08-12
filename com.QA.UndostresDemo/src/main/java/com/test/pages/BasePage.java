package com.test.pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public static final Logger log =	Logger.getLogger(BasePage.class.getName());
	
	protected WebDriver driver;
	public static WebDriverWait wait;
	private static final int TIMEOUT = 180;
	private static final int POLLING = 5000;
	protected File fileLocHandle = new File("src/test/resources/KeyValue.properties");
	protected static Properties objRepo = new Properties();
	public BasePage(WebDriver driver) throws Exception {
	try {
		this.driver = driver;
		wait = new WebDriverWait (driver,TIMEOUT, POLLING);
		FileInputStream fileStream = new FileInputStream(fileLocHandle);
		objRepo.load(fileStream);
	}	catch (Exception e)	{
		log.error("Selenium Exception");
	}
	}

}
