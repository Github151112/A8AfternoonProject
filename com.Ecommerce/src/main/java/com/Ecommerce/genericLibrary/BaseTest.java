package com.Ecommerce.genericLibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest implements IautoConstant {

	FileUtility f = new FileUtility();
	public DataUtility d = new DataUtility();
	public ExcelUtility e = new ExcelUtility();
	public  WebDriver driver;

	@BeforeSuite
	public void toConnectServer() {
		Reporter.log("==server connected sucessfully==",true);
	}

	@BeforeTest
	public void toConnectDatabase() {
		Reporter.log("==database connected sucessfully==",true);
	}
	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser) throws IOException {
		//String browser = f.getDataFromProperty(PROPPATH, "browser");
		String url = f.getDataFromProperty(PROPPATH, "url");
		if(browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if(browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			Reporter.log("Invalid browser",true);
		d.maximizeWindow(driver);
		d.implicitWait(driver,10);
		d.launchApplication(driver, url);
	}
	
	@AfterClass
	public void tearDown() {
		Reporter.log("==closed browser suceessfully==",true);
		driver.quit();
	}
	
	@AfterSuite
	public void toCloseServer() {
		Reporter.log("==server closed sucessfully==",true);
	}

	@AfterTest
	public void toCloseDatabase() {
		Reporter.log("==database closed sucessfully==",true);
	}
	
	

}
