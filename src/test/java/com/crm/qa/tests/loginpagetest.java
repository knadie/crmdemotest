package com.crm.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.basepage.baseclass;
import com.crm.qa.extentreport.extentreport;
import com.crm.qa.pages.homepage;
import com.crm.qa.pages.loginpage;

public class loginpagetest extends baseclass {

	loginpage loginpg;
	homepage homepg;
	
	public loginpagetest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setup() throws IOException {

		intialization();
		loginpg = new loginpage();

	}

	@Test(priority=1)
	public void loginpagetitletest() {
		extentreport.createtest("validate loginpage");
		String title = loginpg.validateloginpage();
		Assert.assertEquals(title,"CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	@Test(priority=2)
	public void crmlogotest() {
		extentreport.createtest("validate logo");
		boolean lg = loginpg.validatelogo();
		Assert.assertTrue(lg);
	}
	@Test(priority=3)
	public void logintest() throws IOException {
		extentreport.createtest("login to app");
		homepg=loginpg.loginp(pro.getProperty("username"), pro.getProperty("passwprd"));

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
