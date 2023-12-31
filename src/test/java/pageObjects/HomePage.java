package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
   public HomePage(WebDriver driver) {
	   super(driver);
   }
   
   //Webelementlocators+identifications
   
   @FindBy(xpath="//a[normalize-space()='Register']") WebElement registerLink;
   @FindBy(xpath="//a[normalize-space()='Log in']") WebElement loginLink;
   
   //actionMethods
   
  public void clickRegister() {
	  registerLink.click();
  }
  public void clickLogin() {
	  loginLink.click();
  }
}
