package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {
	 
public HomePage(WebDriver driver) {
	super(driver);
}
//@FindBy(xpath="//a[@class='btn btn-black navbar-btn']")
@FindBy(xpath="//a/i[@class='fa fa-lock']")
WebElement lock;

public void clickRegister() {
	lock.click();
}
 
}
