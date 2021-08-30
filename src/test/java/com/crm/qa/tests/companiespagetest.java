package com.crm.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.basepage.baseclass;
import com.crm.qa.pages.companiespage;
import com.crm.qa.pages.homepage;
import com.crm.qa.pages.loginpage;
import com.crm.qa.util.testutil;

public class companiespagetest extends baseclass{
	loginpage loginpg;
	homepage homepg;
	companiespage comppage;
	testutil testutil;

	public companiespagetest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws IOException {

		intialization();
		loginpg = new loginpage();
		comppage = new companiespage();
		homepg = new homepage();
		testutil=new testutil();
		homepg = loginpg.loginp(pro.getProperty("username"), pro.getProperty("passwprd"));
		testutil.switchtoframe();
	}
	
	
	@Test
	public void verifycompaniespagetest() throws IOException {
		homepg.clickoncompanieslink();
		Assert.assertTrue(comppage.checklabel());
		
	}
	
	

}
