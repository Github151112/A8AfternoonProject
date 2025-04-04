package com.Ecommerce.TestScripts;

import org.testng.annotations.Test;

import com.Ecommerce.genericLibrary.BaseTest;

import objectRepository.LoginPage;
import objectRepository.WelcomePage;

public class LoginTest extends BaseTest {
	
	@Test
	public void login() {
		
		WelcomePage p = new WelcomePage(driver);
		p.getLoginLink().click();
		LoginPage lp = new LoginPage(driver);
		lp.performLogin("ggfg@gmail.com","uiyjhgtfrd" );
		
	}

}
