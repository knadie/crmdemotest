package com.crm.qa.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentreport {

	private extentreport(){

	}
	public static ExtentReports extent;


	public static void initreport() {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Crmdemo");
		extent.attachReporter(spark);
	}


	public static void closereport() throws IOException {
		extent.flush();
		Desktop.getDesktop().browse(new File("index.html").toURI());
	}
	public static void createtest(String testname) {
		extent.createTest(testname);


	}
}
