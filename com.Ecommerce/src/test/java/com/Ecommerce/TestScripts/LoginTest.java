package com.Ecommerce.TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Ecommerce.genericLibrary.BaseTest;

import objectRepository.LoginPage;
import objectRepository.WelcomePage;

public class LoginTest extends BaseTest {
	
	@Test(groups = "ST")
	public void login() {
		
		WelcomePage p = new WelcomePage(driver);
		p.getLoginLink().click();
		
//		//using hard assert
//		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Login");
		
		//soft assert
		SoftAssert s = new SoftAssert();
		s.assertEquals(driver.getTitle(), "Demo Web Shop. Logi");
		
		LoginPage lp = new LoginPage(driver);
		lp.performLogin("ajay002@gmail.com","123456" );
		
		Assert.assertEquals(p.getLogoutLink().isDisplayed(),true);
		
		s.assertAll();
		
		
		
	}

}
