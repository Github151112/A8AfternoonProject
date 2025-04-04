package com.Ecommerce.genericLibrary;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;

public class DataUtility {
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void implicitWait(WebDriver driver,int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	public void launchApplication(WebDriver driver,String url)
	{
		driver.get(url);
	}
	
	public String getRandomEmail() {
		Random r = new Random();
		int no = r.nextInt(10000);
		String email = "vidhu"+no +"@gmail.com";
		return email;
	}

}
