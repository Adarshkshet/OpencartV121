package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{

	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() 
	{
		logger.info("****** Starting TC001_AccountRegistrationTest  *****");
		
		try 
		{
			
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		
		logger.info("****** Clicked on MyAccount Link  *****");

		hp.clickRegister();
	
		logger.info("****** Clicked on Register Link  *****");
			
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("****** Providing CUstomer Details  *****");
		
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
	}catch (Exception e)
	{
		logger.info(" Test failed ");
		logger.info("Debug logs..");
		Assert.fail();
	}
		logger.info("******Finished TC001_AccountRegistrationTest  *****");

  }	
	
}



