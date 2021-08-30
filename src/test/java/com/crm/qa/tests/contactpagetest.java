package com.crm.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.basepage.baseclass;
import com.crm.qa.pages.contactpage;
import com.crm.qa.pages.homepage;
import com.crm.qa.pages.loginpage;
import com.crm.qa.util.testutil;

public class contactpagetest extends baseclass {
	loginpage loginpg;
	homepage homepg;
	contactpage contactpg;
	testutil testutil;
	public contactpagetest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {

		intialization();
		loginpg = new loginpage();
		contactpg = new contactpage();
		homepg = new homepage();
		testutil=new testutil();
		homepg = loginpg.loginp(pro.getProperty("username"), pro.getProperty("passwprd"));
		testutil.switchtoframe();
	}

	
	@Test(priority = 1)
	public void verifycontactpagetest() throws IOException {
		homepg.clickoncontactlink();
		Assert.assertTrue(contactpg.verifycontactpage());

	}

	@Test(priority = 2)
	public void selectcheckboxtest() throws IOException {
		homepg.clickoncontactlink();
		contactpg.selectcheckbox();
	}
	@Test(priority = 3)
	public void clickoncreatecontact() {
		contactpg.createnewcontact();
		
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
