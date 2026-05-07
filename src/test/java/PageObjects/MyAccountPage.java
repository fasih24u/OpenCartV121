package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends HomePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
@FindBy(xpath="//a[normalize-space()='Logout']")
WebElement logout;
public void logout1() {
	logout.click();
}
}
