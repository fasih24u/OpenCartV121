package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountRegistrationPage extends BasePage{
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	} 
	
	
@FindBy(xpath="//input[@id='id_gender1']")	
WebElement mr;
@FindBy(xpath="//input[@id='password']")	
WebElement pwd;
@FindBy(xpath="//select[@id='days']")
WebElement day;
@FindBy(xpath="//select[@id='months']")
WebElement month;
@FindBy(xpath="//select[@id='years']")
WebElement year;
@FindBy(xpath="//input[@id='newsletter']")
WebElement signupfornew;
@FindBy(xpath="//input[@id='optin']")
WebElement getoffer;

@FindBy(xpath="//input[@id='first_name']")
WebElement fname;
@FindBy(xpath="//input[@id='last_name']")
WebElement lname;
@FindBy(xpath="//input[@id='company']")
WebElement company;
@FindBy(xpath="//input[@id='address1']")
WebElement address;
@FindBy(xpath="//select[@id='country']")
WebElement country;
@FindBy(xpath="//input[@id='state']")
WebElement state;
@FindBy(xpath="//input[@id='city']")
WebElement city;
@FindBy(xpath="//input[@id='zipcode']")
WebElement zip;
@FindBy(xpath="//input[@id='mobile_number']")
WebElement cell;
@FindBy(xpath="//button[normalize-space()='Create Account']")
WebElement btn;
@FindBy(xpath="//input[@id='mobile_number']")
WebElement c;
@FindBy(xpath="//b[normalize-space()='Account Created!']")
WebElement msgConfirmation;

public String getconfirmationMSG() {
	try {
		return (msgConfirmation.getText());
	}catch(Exception e) {
		return (e.getMessage());
	}}
public void clickgender() {
	mr.click();
}
public void setpwd(String pwd1) {
	pwd.sendKeys(pwd1);
}
public void setDay(String day1) {
Select d=new Select(day);
d.selectByVisibleText(day1);
}
public void setmonth(String month1) {
Select d=new Select(month);
d.selectByVisibleText(month1);
}
public void setyear(String year1) {
Select d=new Select(year);
d.selectByVisibleText(year1);

	}
public void clicknew() {
	signupfornew.click();
}
public void clickoffer() {
	getoffer.click();
}
public void fname1(String f) {
	fname.sendKeys(f);
}
public void comp(String c) {
	company.sendKeys(c);;
}
public void adrss(String ad) {
	
address.sendKeys(ad);
}
public void ctry(String ct) {
	Select ctry =new Select(country);
	ctry.selectByVisibleText(ct);
	
}
public void stat(String st) {
   state.sendKeys(st);
}
public void city(String ct) {
	city.sendKeys(ct);;
}
public void zipcode(String zp) {
	zip.sendKeys(zp);
}
public void mobile(String cl) {
	cell.sendKeys(cl);
}
public void createAC() {
	btn.click();
}
public void lname(String l) {
	lname.sendKeys(l);;
}
public String getconfirmationMSG1() {
	try {
		return (msgConfirmation.getText());
	}catch(Exception e) {
		return (e.getMessage());
	}

//@FindBy(xpath="//input[@name='country_id']")	
//WebElement country;
//@FindBy(xpath="//input[@name='password']")	
//WebElement password;
//@FindBy(xpath="//h3[contains(text(),'Register for OpenCart account')]")
//WebElement register;
//@FindBy(xpath="")
//WebElement msgConfirmation;
//@FindBy(xpath="//input[@placeholder='Name']")	
//WebElement username;
//@FindBy(xpath="//input[@data-qa='signup-email']")	
//WebElement email;
//@FindBy(xpath="//button[normalize-space()='Signup']")	
//WebElement signupbutton;


}}
