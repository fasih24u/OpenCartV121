package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage3 extends BasePage{

	public AccountRegistrationPage3(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@placeholder='Name']")	
	WebElement name;
	@FindBy(xpath="//input[@data-qa='signup-email']")	
	WebElement email;
	@FindBy(xpath="//button[normalize-space()='Signup']")
	WebElement signup; 
	
		

	
	public void setname(String name1) {
		name.sendKeys(name1);
	}
	
	public void setemail(String semail) {
		email.sendKeys(semail);
	}
	
	
	public void clicksignup() {
		signup.click();
	}
	
//	public String getconfirmationMSG() {
//		try {
//			return (msgConfirmation.getText());
//		}catch(Exception e) {
//			return (e.getMessage());
//		}
}
