package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
   public LoginPage(WebDriver driver) {
	   super(driver);
   }
   @FindBy(xpath="//input[@id='Email']") WebElement txtLoginEmail;
   @FindBy(xpath="//input[@id='Password']") WebElement txtLoginPassword;
   @FindBy(xpath="//input[@id='Password']") WebElement loginBtn;
   
   public void setLoginEmail(String loginEmail) {
	   txtLoginEmail.sendKeys(loginEmail);
   }
   public void setLoginpassword(String loginPassword) {
	   txtLoginPassword.sendKeys(loginPassword);
   }
   public void clickLoginBtn() {
	   loginBtn.click();
   }
   
}
