package com.test.pages;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

//import com.QA.UndostresDemo.com.QA.UndostresDemo.*;
import com.test.util.ReadPropertyFile;

public class BaseTest {
	
	protected static WebDriver driver;
	protected ReadPropertyFile readPropertyFile = new ReadPropertyFile(); 
	
	protected static String configFile		=	"config.properties";
	protected static String commonFile		=	"common.properties";
	protected static String homePropFile	=	"HomePage.properties";
	protected static File file;
	protected static String strTestBrowser;
	
	protected HomePage homePage;
	
	
	public WebDriver getDriver()	{
		return driver;
	}
	
	@BeforeTest
	public void initializeTest ()throws Exception {
		strTestBrowser = readPropertyFile.getPropValue(configFile, "browser");
		
	}
	
	@BeforeClass
	public void initializeDriver ()throws Exception {
		if (strTestBrowser.equals("InternetExplorer"))	{
			DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			file = new File(readPropertyFile.getPropValue(commonFile, "IEDriverPath"));
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver = new InternetExplorerDriver(cap);
		}
		
		if (strTestBrowser.equals("chrome"))	{
			System.setProperty("webdriver.chrome.driver", readPropertyFile.getPropValue(commonFile, "ChromeDriverPath"));
			ChromeOptions option = new ChromeOptions();
			option.setExperimentalOption("useAutomationExtension", false);
			option.addArguments("--no-sandbox","--disable-dev-shm-usage");
			driver = new ChromeDriver(option);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		homePage	=	new HomePage(driver);
	}

}
