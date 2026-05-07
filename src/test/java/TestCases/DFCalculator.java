package TestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import Utilities.ExcelUtility;

public class DFCalculator {
	
public static void main(String [] args) throws IOException, InterruptedException {
	
	ChromeOptions options=new ChromeOptions();
	options.addArguments("disable-notifications");

	
	WebDriver driver=new ChromeDriver(options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html");
	driver.manage().window().maximize();
	String filePath="C:\\Users\\fasih\\eclipse-workspace\\OpencartV121\\testData\\datasheet.xlsx";
	
	ExcelUtility exlutil=new ExcelUtility();
	int rows=exlutil.getRowCount(filePath,"sheet1");
	for(int i=1;i<=rows;i++) {
	String pric=	exlutil.getCellData(filePath,"sheet1", i, 0);
	String rate=	exlutil.getCellData(filePath,"sheet1", i, 1);
	String priod1=	exlutil.getCellData(filePath,"sheet1", i, 2);
	String priod2=	exlutil.getCellData(filePath,"sheet1", i, 3);
	String freq=	exlutil.getCellData(filePath,"sheet1", i, 4);
	String exp_mauturity=	exlutil.getCellData(filePath,"sheet1", i, 5);
	
	driver.findElement(By.xpath("//input[@name='principal']")).sendKeys(pric);
	driver.findElement(By.xpath("//input[@name='interest']")).sendKeys(rate);
	driver.findElement(By.xpath("//input[@name='tenure']")).sendKeys(priod1);
//	WebElement per1 =driver.findElement(By.xpath("//select[@id='tenure']"));
//	Select p1=new Select(per1);
//	p1.selectByVisibleText(priod1);
	WebElement p2=driver.findElement(By.xpath("//select[@id='tenurePeriod']"));
	Select per2=new Select(p2);
	per2.selectByVisibleText(priod2);
	WebElement f=driver.findElement(By.xpath("//select[@id='frequency']"));
	Select ff=new Select(f);
	ff.selectByVisibleText(freq);
	
	driver.findElement(By.xpath("//div[@class='CTR PT15']//a[1]//img")).click();
	String act_mValue=driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
	if(Double.parseDouble(act_mValue)==Double.parseDouble(exp_mauturity)) {
		System.out.println("Test passed");
		exlutil.setCellData(filePath,"sheet1",i, 7,"passed");
	}
	else {
		System.out.println("Test failed");
		exlutil.setCellData(filePath,"sheet1",i, 7,"failed");
	}
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@class='CTR PT15']//a[2]//img")).click();
	}

	
	driver.quit();
}

}
