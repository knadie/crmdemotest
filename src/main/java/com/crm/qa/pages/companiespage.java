package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.basepage.baseclass;

public class companiespage extends baseclass{

	public companiespage() throws IOException {
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath="//td[text()='Companies']")
	WebElement complabel;
	
	public boolean checklabel() {
		
		return complabel.isDisplayed();
	}
	
	
	

}
