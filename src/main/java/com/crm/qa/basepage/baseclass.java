package com.crm.qa.basepage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.crm.qa.extentreport.extentreport;
import com.crm.qa.util.testutil;

public class baseclass {

	public static WebDriver driver;
	public static Properties pro;

	public baseclass() throws IOException {

		pro = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\user\\.eclipse\\eclipse\\Crmdemotest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");

		pro.load(fis);

	}

	@BeforeSuite
	public void beforesuite() {
		extentreport.initreport();

	}
	@AfterSuite 
	public void aftersuite() throws IOException {
		extentreport.closereport();
	}

	public static void intialization() {
		String brows = pro.getProperty("browser");

		if (brows.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\user\\.eclipse\\eclipse\\Crmdemotest\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\user\\.eclipse\\eclipse\\Crmdemotest\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(testutil.IMPLICITLY_WAIT, TimeUnit.SECONDS);

		driver.get(pro.getProperty("url"));

	}

}
