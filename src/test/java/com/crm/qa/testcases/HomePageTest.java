package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;



public class HomePageTest extends TestBase{
	
	HomePage homepage;
	Contacts contacts;
	
	public HomePageTest() {
		super();
		
		
	}
	
	@BeforeMethod
	public void setup() {
		System.out.println("inside Setup method");
		initialiation();
		LoginPage loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			
	}
	
	@Test(priority = 1)
	public void homePageNameTest() {
		Assert.assertEquals("sameena taz", homepage.verifyHomePageName());
	}
	
	@Test(priority = 2)
	public void homePageCalenderEnabled() {
		Assert.assertEquals(true, homepage.homePageCalender());
	}
	
	@Test(priority = 3)
	public void homePageClickContacts() throws InterruptedException {
		contacts = homepage.homePageContacts();
		Thread.sleep(5000);
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
