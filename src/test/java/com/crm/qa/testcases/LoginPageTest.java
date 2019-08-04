package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialiation();
		loginpage = new LoginPage();		
	}
	
	@Test(priority = 1)
	public void logInPageTitleTest() {
		String str = loginpage.validateLoginTitle();
		Assert.assertEquals(str, "Free CRM software for any Business");
	}
	@Test(priority = 2)
	public void logInPageLoginEnabled() {
		Assert.assertEquals(loginpage.validateLoginEnabled(), true);
	}
	@Test(priority = 3)
	public void logInPageLogin() {
		
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
	
	driver.quit();
	}

}
