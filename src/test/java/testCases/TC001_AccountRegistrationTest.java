package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	

	
	@Test(groups={"Regression","Master"})
	public void verify_Acc_Reg() {
		
		logger.info("***********Starting TC001_AccountRegistrationTest*****************");
		
		try
		{
		HomePage hp = new HomePage(driver);
		
		hp.clickMyaccount();
		logger.info("Clicked on Myaccount link");
		
		hp.clickRegister();
		logger.info("Clicked on Register link");
		
		AccountRegistrationPage rp = new AccountRegistrationPage(driver);
		
		
		logger.info("Providing Customer details");
		rp.setFirstName(randomString().toUpperCase());      //randomly generates the firstName
		rp.setLastName(randomString().toUpperCase());        //randomly generates the lastName
		rp.setEmail(randomString()+"@gmail.com");   //randomly generated the email
		rp.setTelephone(randomNumber());
		
		
		String password=randomAlphaNumeric();
		
		rp.setPassword(password);
		rp.setConfirmPassword(password);
		rp.setPrivacypolicy();
		rp.setButtonContinue();
		
		logger.info("Validating expected message");
		String confmsg= rp.getmsgConfirmation();
		
		if(confmsg.equals("Your Account Has Been Created!")) {
			
			Assert.assertTrue(true);
		}
		else {
			
			logger.error("Test Failed");
			logger.debug("Debug Logs");
			Assert.assertTrue(false);
		}
		
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!!!");
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("***********Finished TC001_AccountRegistrationTest*****************"); 
		
	}
	
	
	

}
