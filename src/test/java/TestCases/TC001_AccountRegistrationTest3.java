package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AccountRegistrationPage;
import PageObjects.AccountRegistrationPage3;
import PageObjects.HomePage;
import TestBase.BaseClass; 

public class TC001_AccountRegistrationTest3 extends BaseClass{
	
	@Test(groups= {"Sanity","Master"})
	public void verify_act_registration() throws InterruptedException { 
		
		logger.info("******Starting TC001**********");
		try {
		HomePage ob=new HomePage(driver);
		logger.info("******CLICK on register**********");
		ob.clickRegister();
		AccountRegistrationPage3 p1=new AccountRegistrationPage3(driver);
		
		p1.setname(RandomString().toUpperCase());
		//p1.setname("fasih");
		p1.setemail(RandomString()+"@yahoo.com");
		//p1.setemail("897gh@yahoo.com");
		p1.clicksignup();
		AccountRegistrationPage p2=new AccountRegistrationPage(driver);
		logger.info("******providing costumer details**********");
		p2.clickgender();
		p2.setpwd(RandomAlphaNumberic());
		//p2.setpwd("123456");
		p2.setDay("4");
		p2.setmonth("May");
		p2.setyear("2016");
		p2.clicknew();
		p2.clickoffer();
		p2.fname1(RandomString().toUpperCase());
		p2.lname(RandomString().toUpperCase());
		//p2.fname1("fasih");
		//p2.lname("uddin");
		p2.comp("abc");
		p2.adrss("789 jack ln");
		p2.ctry("United States"); 
		p2.stat("Texas");
		p2.city("Dallas");
		p2.zipcode("87782");
		p2.mobile(RandomNumber());
		p2.createAC();
		logger.info("******validating expected message**********");
		String cnfmsg=p2.getconfirmationMSG();
		Assert.assertEquals(cnfmsg,"ACCOUNT CREATED!");
		}catch(Exception e){
			logger.error("Test Failed...");
			logger.debug("....debug Logs........");
			Assert.fail();
		}
		logger.info("******finished TC001**********");
}
	
	
}
