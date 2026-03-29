package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.logInPage;
import pageObjects.myAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*Data Valid ---Login success-test pass-logout
 * Data Valid--Login failed-test fail
 * 
 * 
 * Data Invalid--Login Success-test fail-Logout
 * Data Invalid--Login failed-test pass
 */




public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)   //getting DataProvider from different different package
	public void verify_loginDDT(String email,String password,String exp) {
		
		logger.info("********Starting TC003_LoginDDT*******************");
		
		try {
		//HomePage
				HomePage hp =new HomePage(driver);
				hp.clickMyaccount();
				hp.clickLogin();
				
				
	    //Login Page
				logInPage lp = new logInPage(driver);
				lp.setEmail(email);
				lp.setPassword(password);
				lp.btnLogin();
				
				
		//My AccountPage
				
				myAccountPage macc= new myAccountPage(driver);
				boolean targetPage=macc.isMyAccountPageexist();
		
		
			if(exp.equalsIgnoreCase("Valid"))	{
				if(targetPage==true) {
					
					macc.clickLogout();
					Assert.assertTrue(true);
					
				}
				else {
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid")) {
				if(targetPage==true) {
					
					macc.clickLogout();
					Assert.assertTrue(false);
				}
				else {
					Assert.assertTrue(true);
				}
			}
			
		}catch(Exception e) {
			Assert.fail();
		}
			
			logger.info("********Finished TC003_LoginDDT*******************");
				
				
		
	}
	
	

}
