package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.basepage.baseclass;

public class homepage extends baseclass{

	public homepage() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]")
	WebElement usernamelabel;
	
	@FindBy(xpath="//a[normalize-space()='Contacts']")
	WebElement contactslink;
	
	@FindBy(xpath="//a[normalize-space()='Companies']")
	WebElement companieslink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontact;
	
	public String verifyhomepagetitle() {
		return driver.getTitle();
	}
	
	public boolean verifyusernamelabel() {
		return usernamelabel.isDisplayed();
			
	}
	public contactpage clickoncontactlink() throws IOException {
		contactslink.click();
		return new contactpage();
	}
	public companiespage clickoncompanieslink() throws IOException {
		companieslink.click();
		return new companiespage();
		
	}
	public void selectnewcontact() {
		Actions action =new Actions(driver);
		action.moveToElement(contactslink).build().perform();
		newcontact.click();
	}
}
