package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class logInPage extends BasePage{
	
	public logInPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@name='email']")
	WebElement txtEmailAddress;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement btnLogin;
	
	
	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void btnLogin() {
		btnLogin.click();
	}
	
	
	
	
	
	
	

}
