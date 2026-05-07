package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
public ExtentSparkReporter sparkReporter; //UI of the report
public ExtentReports extent;             //populate common info on the report
public ExtentTest Test;                  //test case entries & update status of the test method
String repName;
public void onStart(ITestContext testcontext) {
//	       SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.ss");
//	       Date dt=new Date();
//	       String currentdatetimestamp=df.format(dt);
	       String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.ss").format(new Date());
         repName="Test-Report" +timestamp+".html";
sparkReporter=new ExtentSparkReporter("C:\\Users\\fasih\\eclipse-workspace\\OpencartV121\\reports\\"+repName);
sparkReporter.config().setDocumentTitle("Automation report");  //title of report
sparkReporter.config().setReportName("Functional Testing");    //name of the report
sparkReporter.config().setTheme(Theme.DARK);

extent=new ExtentReports();
extent.attachReporter(sparkReporter);   
extent.setSystemInfo("computer Name","Local");
extent.setSystemInfo("Env", "QA");
extent.setSystemInfo("Tester Name", "Fasih");
extent.setSystemInfo("OS", "Windows");
extent.setSystemInfo("Browser", "Chrome");
String os=testcontext.getCurrentXmlTest().getParameter("os");
extent.setSystemInfo("Operating System", os);
String browser=testcontext.getCurrentXmlTest().getParameter("browser");
extent.setSystemInfo("Browser", browser);

List<String> groups=testcontext.getCurrentXmlTest().getIncludedGroups();
if(!groups.isEmpty()) {
	extent.setSystemInfo("Groups", groups.toString());
}
}
public void OnTestSuccess(ITestResult result) {
	Test=extent.createTest(result.getName());
	Test.log(Status.PASS,"Test cases passed "+result.getName());
	Test.log(Status.PASS, result.getName()+ "got seccussfully executed ");
	
}
public void OnTestFailure(ITestResult result) {
	Test=extent.createTest(result.getName());
	Test.log(Status.FAIL,"Test cases failed "+result.getName());
	Test.log(Status.FAIL,"Test cases failed cause "+result.getThrowable());
}
public void OnTestSkipped(ITestResult result) {
	Test=extent.createTest(result.getName());
	Test.log(Status.SKIP,"Test cases skipped is "+result.getName());
	}
public void onFinish(ITestContext context) {
	extent.flush();
}
}

