package TestBase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public WebDriver driver;
public Logger logger; //log4j
public Properties p;	
	@SuppressWarnings("deprecation")
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"OS","browser"})
	
	
	public void setup(String OS, String br) throws IOException {
		//loading config.properties file 
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		logger=LogManager.getLogger(this.getClass()); //log4j2 watch the video again
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities=new DesiredCapabilities();
			if(OS.equalsIgnoreCase("windows")) {
			capabilities.setPlatform(Platform.WIN11);
			}else if(OS.equalsIgnoreCase("mac")){
				capabilities.setPlatform(Platform.MAC);
			}else{
				System.out.println("no matching os");
				return;
			}
			switch(br.toLowerCase()) {
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("no matching browser"); return;
			
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444"),capabilities);
		}
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
		switch(br.toLowerCase()) {
		case "chrome" : driver=new ChromeDriver(); break;
		case "edge"   : driver=new EdgeDriver(); break;
		case "firefox" : driver=new FirefoxDriver(); break;
		default : System.out.println("Invalid browser name....."); return;
		}
		
		}
		driver.manage().deleteAllCookies();
//		ChromeOptions options=new ChromeOptions();
//		options.addArguments("disable-notifications");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown() throws InterruptedException { 
       
	driver.quit();
	}
	public String RandomString() {
		@SuppressWarnings("deprecation")
		String generateString=RandomStringUtils.randomAlphabetic(6);
		return generateString;
	}
	public String RandomNumber() {
		@SuppressWarnings("deprecation")
		String generateNumber=RandomStringUtils.randomAlphanumeric(10);
		return generateNumber;
	}
	public String RandomAlphaNumberic() {
		@SuppressWarnings("deprecation")
		String generateString=RandomStringUtils.randomAlphabetic(3);
		@SuppressWarnings("deprecation")
		String generateNumber=RandomStringUtils.randomAlphanumeric(4);
		return (generateNumber+"@"+generateString);
	}
}
