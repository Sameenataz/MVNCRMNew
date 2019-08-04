package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//span[contains(text(),'sameena taz')]")
	WebElement name;
	@FindBy(xpath = "//span[contains(text(),'Calendar')]")
	WebElement calendar;
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contacts;
	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	WebElement tasks;
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyHomePageName() {
		return name.getText();
	}
	public boolean homePageCalender() {
		return (calendar.isEnabled() & calendar.isDisplayed());
	}
	
	public Contacts homePageContacts() {
		if (contacts.isEnabled()){
			System.out.println("Contacts enabled and clickable");
			contacts.click();			
		}
		return new Contacts();
	}
	public Tasks homePageTasks() {
		if (tasks.isEnabled()){
			tasks.click();			
		}
		return new Tasks();
	}
}
