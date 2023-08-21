package testscripts;


import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.PredefinedActions;


public class TestBase {
	
	@BeforeMethod
	public void startUp() {
		String env = System.getProperty("env");
		PredefinedActions.start(env);
	}
	
	
	@AfterMethod
	public void wrapUp(ITestResult testResult) {
		if(testResult.getStatus() == testResult.FAILURE)
			PredefinedActions.takeScreenshot(testResult.getMethod().getMethodName());
		PredefinedActions.wrapUp();
	}
}
