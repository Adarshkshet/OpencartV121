package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="Datadriven") //getting data provider form different class
	public void verify_loginDDT(String email,String pwd,String exp)
	{
		
			logger.info("**************** Starting TC003_LoginDDT test***************");
			
			try
			{
				//HomePage
				HomePage hp=new HomePage(driver);
				hp.clickMyAccount();
				hp.clickLogin();
				
				//LoginPage
				LoginPage lp=new LoginPage(driver);
				lp.setEmail(email);
				lp.setPassword(pwd);
				lp.clickLogin();
				
				//MyAccountPage
				
				MyAccountPage macc=new MyAccountPage(driver);
				boolean targetPage=macc.isMyAccountPageExists();
				

				/*
				 * Data is Valid - login success - test pass - logout
					 			 - login Failed - test fail
				 * 
				 * Data is InValid - login success - test fail - logout
				 * 				   - login  Failed- test pass 
				 */

				if(exp.equalsIgnoreCase("Valid"))
				{
					if(targetPage==true) 
					{						//Data is Valid - login success - test pass - logout
					macc.clickLogout();						
					Assert.assertTrue(true);
					}
					else
					{
						Assert.assertTrue(false);		// - login Failed - test fail

					}
				}
				
				if(exp.equalsIgnoreCase("Invalid"))
				{
					if(targetPage==true) 
					{						//Data is InValid - login success - test pass - logout
					macc.clickLogout();						
					Assert.assertTrue(false);
					}else
					{
						Assert.assertTrue(true);
					}
				}
			}
			catch(Exception e)
			{
				Assert.fail();
			}
			logger.info("*********** finished ***************");
	}
}
