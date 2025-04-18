package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	
	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "ico-register")
	private WebElement registerLink;
	
	@FindBy(linkText = "Log in")
	private WebElement loginLink;
	
	@FindBy(className = "ico-logout")
	private WebElement logoutLink;

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getRegisterLink() {
		return registerLink;
	}

}
