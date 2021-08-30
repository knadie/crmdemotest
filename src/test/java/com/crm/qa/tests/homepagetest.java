package com.crm.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.basepage.baseclass;
import com.crm.qa.pages.companiespage;
import com.crm.qa.pages.contactpage;
import com.crm.qa.pages.homepage;
import com.crm.qa.pages.loginpage;
import com.crm.qa.util.testutil;

public class homepagetest extends baseclass {

	loginpage loginpg;
	homepage homepg;
	testutil testutil;
	contactpage contactpg;
	companiespage comaniespg;

	public homepagetest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setup() throws IOException {

		intialization();
		testutil = new testutil();
		loginpg = new loginpage();
		contactpg = new contactpage();
		comaniespg = new companiespage();
		homepg = new homepage();
		homepg=loginpg.loginp(pro.getProperty("username"), pro.getProperty("passwprd"));

	}

	@Test(priority=1)
	public void verifyhomepagetest() {
		String title = homepg.verifyhomepagetitle();
		Assert.assertEquals(title, "CRMPRO", "homepage title not matched");
	}

	@Test(priority=2)
	public void verifyusernamelabletest() {
		testutil.switchtoframe();
		Assert.assertTrue(homepg.verifyusernamelabel());
	}
	@Test(priority=3)
	public void clickoncontacttest() throws IOException {
		testutil.switchtoframe();
		contactpg = homepg.clickoncontactlink();
	}
	@Test(priority=4)
	public void clickoncompaniestest() throws IOException {
		testutil.switchtoframe();
		comaniespg = homepg.clickoncompanieslink();

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
