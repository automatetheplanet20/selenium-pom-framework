package framework.reporters;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ProgressReporter implements ITestListener{

	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		test = ExtentReporter.startTest(result.getName());
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.print(".");
		test.log(Status.PASS, "Test case is pass");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.print("F");
		test.log(Status.FAIL, result.getThrowable());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.print("S");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentReporter.startReporter();
		
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentReporter.GenerateReport();
		
	}


}
