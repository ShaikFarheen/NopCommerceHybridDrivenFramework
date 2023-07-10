package testCases;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_Account_RegistrationPage extends BaseClass {
	@Test(groups={"Regression","Master"})
   public void test_account_Registration() throws InterruptedException {
		
	   logger.debug("application logs");
	   logger.info("**** Starting TC_001_Account_RegistrationPage ****");
	   HomePage hp=new HomePage(driver);
	   hp.clickRegister();
	   logger.info("Clicked on Register link");
	   AccountRegistrationPage regPage=new AccountRegistrationPage(driver);
	   logger.info("Providing customer data");
	   regPage.checkGender();
	   regPage.setFirstName("pandu");
	   regPage.setLastName("shaik");
	   Select dt=new Select(regPage.setDate());
	   dt.selectByVisibleText("25");
	   Select mon=new Select(regPage.setMonth());
	   mon.selectByVisibleText("May");
	   Select year=new Select(regPage.setYear());
	   year.selectByVisibleText("2023");
	   regPage.setEmail("pppp@gmail.com");
	   regPage.setPassword("pandu@123");
	   regPage.setConfirmPassword("pandu@123");
	   regPage.clickRegisterButton();
	   logger.info("Clicked on register button");
	   Thread.sleep(3000);
	   String status=regPage.getConfirmationMessage();
	   logger.info("Validating expected message");
	   Assert.assertEquals(status,"Your registration completed","Test failed");
	   logger.info("*** Finished TC_001_Account_RegistrationPage ***");
   }
	
}
