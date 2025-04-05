package com.Ecommerce.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.Ecommerce.genericLibrary.BaseTest;

import objectRepository.RegisterPage;
import objectRepository.WelcomePage;

public class RegisterTest extends BaseTest {

	@Test(groups = "RT")
	public void register() throws InterruptedException, EncryptedDocumentException, IOException {

		String fn = e.readDataFromExcel(EXCELPATH, REGSHEET, 1, 0);
		String ln = e.readDataFromExcel(EXCELPATH, REGSHEET, 1, 1);
		String paswword = e.readDataFromExcel(EXCELPATH, REGSHEET, 1, 2);
		// click on register link
		WelcomePage wp = new WelcomePage(driver);
		wp.getRegisterLink().click();
		RegisterPage rp = new RegisterPage(driver);
		rp.performRegistration(fn, ln, d.getRandomEmail(), paswword);

		Thread.sleep(3000);
		
	}

}
