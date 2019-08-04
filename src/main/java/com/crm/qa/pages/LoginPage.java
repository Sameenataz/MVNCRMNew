package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory 
	@FindBy(xpath = "//span[contains(text(),'Log In')]")
	WebElement Login;
	
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//div[contains(text(),'Login')]")
	WebElement login1;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginTitle() {
		return driver.getTitle();
	}
	public boolean validateLoginEnabled() {
		return Login.isEnabled();
	}
	public HomePage login(String email1,String password1) {
		Login.click();
		
		username.sendKeys(email1);
		password.sendKeys(password1);
		login1.click();
		return new HomePage();
	}

}
