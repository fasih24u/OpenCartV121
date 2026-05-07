package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@data-qa='login-email']")	
	WebElement email;
	@FindBy(xpath="//input[@data-qa='login-password']")	
	WebElement pwd;
	@FindBy(xpath="//button[@data-qa='login-button']")
	WebElement login; 
	
		

	
	public void enterEmail(String eemail) {
		email.sendKeys(eemail);
	}
	
	public void enterPWD(String pswd) {
		pwd.sendKeys(pswd);
	}
	
	
	public void clicklogin() {
		login.click();
	}
	
//	public boolean IsMyAaccountExist() {
//		try {
//			return (msgConfirmation.getText());
//		}catch(Exception e) {
//			return (e.getMessage());
////		}
}
