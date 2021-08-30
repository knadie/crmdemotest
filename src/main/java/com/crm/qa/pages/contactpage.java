package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.basepage.baseclass;

public class contactpage extends baseclass {

	public contactpage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;

	@FindBy(xpath = "//a[text()='kuma dgd']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")
	WebElement selectt;
	
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement cont;
	
	@FindBy(xpath="//ul//li//a[text()='New Contact']")
	WebElement create;


	public boolean verifycontactpage() {
		return contactslabel.isDisplayed();
	}

	public void selectcheckbox() {
		selectt.click();

	}
	public void createnewcontact() {
		Actions action= new Actions(driver);
		action.moveToElement(cont).build().perform();
		action.moveToElement(create).build().perform();
		create.click();
		
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("kuamar");
		driver.findElement(By.xpath("//input[@name='surname']")).sendKeys("nak");
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		
		
		
				
		

	}
}
