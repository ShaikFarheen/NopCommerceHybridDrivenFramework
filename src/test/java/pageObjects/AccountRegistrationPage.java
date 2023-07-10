package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
  public AccountRegistrationPage(WebDriver driver) {
	  super(driver);
  }
  
  @FindBy(xpath="//input[@id='gender-female']") WebElement genderChkBox;
  @FindBy(xpath="//input[@id='FirstName']") WebElement txtfname;
  @FindBy(xpath="//input[@id='LastName']") WebElement txtlname;  
  @FindBy(xpath="//select[@name='DateOfBirthDay']") WebElement date;
  @FindBy(xpath="//select[@name='DateOfBirthMonth']") WebElement month;
  @FindBy(xpath="//select[@name='DateOfBirthYear']") WebElement yr;
  @FindBy(xpath="//input[@id='Email']") WebElement txtemail;
  @FindBy(xpath="//input[@id='Password']") WebElement txtPassword;
  @FindBy(xpath="//input[@id='ConfirmPassword']") WebElement txtConfirmPassword;
  @FindBy(xpath="//button[@id='register-button']") WebElement registerBtn;
  @FindBy(xpath="//div[@class='result']") WebElement msgConfirmation;
  
  //action methods
   public void checkGender() {
	   genderChkBox.click();
   }
   public void setFirstName(String fname) {
	   txtfname.sendKeys(fname);
   }
   public void setLastName(String lname) {
	   txtlname.sendKeys(lname);
   }
   public WebElement setDate() {
	   return date;
   }
   public WebElement setMonth() {
	   return month;
   }
   public WebElement setYear() {
	   return yr;
   }
   public void setEmail(String email) {
	   txtemail.sendKeys(email);
   }
   public void setPassword(String password ) {
	   txtPassword.sendKeys(password);
   }
   public void setConfirmPassword(String confirmPass) {
	   txtConfirmPassword.sendKeys(confirmPass);
   }
   public void clickRegisterButton() {
	   registerBtn.click();
   }
   public String getConfirmationMessage() {
	   return (msgConfirmation.getText());
   }
}
