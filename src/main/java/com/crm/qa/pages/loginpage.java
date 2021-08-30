package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.basepage.baseclass;

public class loginpage extends baseclass {

	public loginpage() throws IOException {

		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginbtn;

	@FindBy(xpath = "//a[normalize-space()='Sign Up']")
	WebElement signup;

	@FindBy(xpath = "//img[@src='https://classic.freecrm.com/img/logo.png']")
	WebElement crmlogo;

	public String validateloginpage() {

		return driver.getTitle();

	}

	public boolean validatelogo() {

		return crmlogo.isDisplayed();

	}

	public homepage loginp(String user, String pass) throws IOException {
		username.sendKeys(user);
		password.sendKeys(pass);
		loginbtn.click();
		
		return new homepage();
		
	}

}
