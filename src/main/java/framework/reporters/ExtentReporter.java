package framework.reporters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//https://extentreports.com/docs/versions/2/java/
public class ExtentReporter {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest test;
	public static ExtentReports extent;

	public static void startReporter() {

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReportResults.html");
		htmlReporter.config().setDocumentTitle("Automation Execution Report");
		htmlReporter.config().setReportName("Ecommerce Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "Mitul's PC");
		extent.setSystemInfo("OS", "WIN10");
		extent.setSystemInfo("SDET", "Mitulsinh Vaghela");
	}
	
	public static ExtentTest startTest(String testName) {
		return extent.createTest(testName);
		
	}
	
	public static void GenerateReport() {
		extent.flush();
		
	}
	

}
