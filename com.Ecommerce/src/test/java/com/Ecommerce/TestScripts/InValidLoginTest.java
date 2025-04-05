package com.Ecommerce.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Ecommerce.genericLibrary.BaseTest;
import com.Ecommerce.genericLibrary.ExcelUtility;

import objectRepository.LoginPage;
import objectRepository.WelcomePage;

public class InValidLoginTest extends BaseTest {

	@DataProvider(name = "TestData")
	public Object[][] invalidData() throws EncryptedDocumentException, IOException {
	
		return ExcelUtility.readMultipleData(EXCELPATH, INVALIDDATA);
	}

	@Test(dataProvider = "TestData",groups = "FT")
	public void invalidLogin(String email, String password) {
		WelcomePage p = new WelcomePage(driver);
		p.getLoginLink().click();
		LoginPage lp = new LoginPage(driver);
		lp.performInvalidLogin(email, password);
	}

}
