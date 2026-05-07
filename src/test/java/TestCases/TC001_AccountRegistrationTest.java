
package TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;
import TestBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	public WebDriver driver;
	@BeforeClass
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.opencart.com/index.php?route=cms/demo");
		driver.manage().window().maximize();
		
	} 
	
	  
//	@AfterClass 
//	public void tearDown() {
//		driver.quit();
//	}
	@Test
	public void verify_act_registration() { 
		logger.info("launch the page");
		HomePage ob=new HomePage(driver);
		ob.clickRegister();
		AccountRegistrationPage rg=new AccountRegistrationPage(driver);
//		rg.setusername("TCS");
//		rg.setfirstname("Fasih");
//		rg.setlastname("uddin");
//        rg.setemail("udd@yahoo.com");
//		rg.setcountrt("USA");
//		rg.setpwd("123456");
//		rg.clickregister();
//		
		String cnfmsg=rg.getconfirmationMSG();
		Assert.assertEquals(cnfmsg,"Register for OpenCart account");
}

}
