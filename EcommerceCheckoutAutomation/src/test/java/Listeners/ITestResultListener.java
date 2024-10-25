package Listeners;

import DriverFactory.DriverFactory;
import Utilities.Utility;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestResultListener implements ITestListener {


    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed " + result.getName());
    }



    public void onTestFailure(ITestResult result) {
        Utility.takeScreenShot(DriverFactory.driver, result.getTestName());
    }
}
