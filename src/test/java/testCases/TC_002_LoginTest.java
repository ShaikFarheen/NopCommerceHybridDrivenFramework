package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	@Test(groups= {"Sanity","Master"})
   public void test_Login() {
		 logger.info("**** Starting TC_002_LoginTest ****");
		 HomePage hp=new HomePage(driver);
		 hp.clickLogin();
		 logger.info("clicked on login link");
		 LoginPage lp=new LoginPage(driver);
		 logger.info("providing login details");
		 lp.setLoginEmail(rb.getString("email"));
		 lp.setLoginpassword(rb.getString("password"));
		 lp.clickLoginBtn();
		 logger.info("clicked on login button");
		 MyAccountPage macc=new MyAccountPage(driver);
		 logger.info("validating expected message");
		boolean targetPage= macc.isNopCommerceImageExits();
		Assert.assertEquals(targetPage, true);
		logger.info("**** Finished TC_002_LoginTest*****");
   }
}
