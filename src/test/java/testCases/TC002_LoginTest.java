package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.logInPage;
import pageObjects.myAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void  verify_login() {
		
		logger.info("******Starting TC002_LoginTest*********** ");
		
		try {
		//HomePage
		HomePage hp =new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
		
		
		//Login Page
		logInPage lp = new logInPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.btnLogin();
		
		
		//My AccountPage
		
		myAccountPage macc= new myAccountPage(driver);
		
		boolean targetPage=macc.isMyAccountPageexist();
		
		
		
		Assert.assertTrue(targetPage);    //  (OR)Assert.assertEquals(targetPage, true,"Login Failed");
		
		}catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("******Finised TC002_LoginTest*********** ");
		
		
	}
	
	
	
	

}
