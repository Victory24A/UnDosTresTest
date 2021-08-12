package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver ) 	throws Exception{
		super(driver);
	}
	
	//page locators:
	By operateorField = By.name("operator");
	By numMobile = By.xpath("//input[@data-qa='celular-mobile']");
	By rechargeAmount = By.xpath("//*[@data-qa='celular-amount']");
	By dollar10Value = By.xpath("//*[text()='$10']");
	By buttonNext = By.xpath("//button[@data-qa='celular-pay']");
	
	//page actions:
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	public void openPage(String pageString ) {
		driver.get(pageString);
	}
	
	public void clickOperatorField() {
		driver.findElement(operateorField).click();
	}
	
	public void selectOperatorValue(String opValue)	{
		switch(opValue) {
		case "Telcel" :
			driver.findElement(By.xpath("//*[@data-show='Telcel']")).click();
//		case "AT&T" :
//			driver.findElement(By.xpath("//*[@data-show='AT&T']")).click();
//		case "Movistar" :
//			driver.findElement(By.xpath("//*[@data-show='Movistar']")).click();
		}
	}
	
	public void enterMobileNumber(long num)	throws Exception{
		driver.findElement(numMobile).click(); Thread.sleep(1000);
		driver.findElement(numMobile).clear();
		driver.findElement(numMobile).sendKeys(Long.toString(num));
	}
	
	public void enterRechargeAmount(String amount)	{
		driver.findElement(rechargeAmount).click();
		switch(amount)	{
		case "10":
			driver.findElement(dollar10Value).click();
		}
	}
	
	public void clickNextButton()	{
		driver.findElement(buttonNext).click();
	}
	
	
	

}
