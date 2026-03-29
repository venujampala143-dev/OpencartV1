package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	
	public HomePage(WebDriver driver) {
		
		super(driver);
	}
	
	
@FindBy(xpath="//span[normalize-space()='My Account']")       //My Account element
WebElement lnkMyaccount;

@FindBy(xpath="//a[normalize-space()='Register']")           //Register Element
WebElement lnkMyregister;

@FindBy(linkText="Login")                                  //Login Element
WebElement lnkLogin;


public void clickMyaccount() {
	
	lnkMyaccount.click();
}

public void clickRegister() {
	
	lnkMyregister.click();
	
}

public void clickLogin() {
	
	lnkLogin.click();
}

}
