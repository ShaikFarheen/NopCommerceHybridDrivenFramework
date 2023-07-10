package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
  public MyAccountPage(WebDriver driver) {
	  super(driver);
  }
  @FindBy(xpath="//img[@alt='nopCommerce demo store']") WebElement nopCommerceImage;
  @FindBy(xpath="//a[normalize-space()='Log out']") WebElement logoutLink;
  
  public boolean isNopCommerceImageExits() {
	  return nopCommerceImage.isDisplayed();
  }
  public void clickLogout() {
	  logoutLink.click();
  }
}
