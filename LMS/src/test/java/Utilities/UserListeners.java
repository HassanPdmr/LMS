package Utilities;

import CommonFunctions.CommonFunctions;
import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class UserListeners extends CommonFunctions implements ITestListener {


    @Override
    public void onStart(ITestContext Context) {

//        extentReport = new ExtentReports();

//        extentReport = new ExtentReports();
//        ExtentSparkReporter Sparkreporter = new ExtentSparkReporter("ExtentReport.html");
//        extentReport.attachReporter(Sparkreporter);


    }


    @Override
    public void onTestFailure(ITestResult result) {


        Object currentClass = result.getInstance();
        WebDriver driver = CommonFunctions.driver;

        if (driver != null) {

            String screenshotPath = ((CommonFunctions) currentClass).takeScreenshot(result.getMethod().getMethodName());
            testCase.addScreenCaptureFromPath(screenshotPath);
        }

//        testCase = extentReport.createTest(result.getMethod().getDescription());
        testCase.fail(result.getThrowable());
        testCase.assignCategory(result.getMethod().getDescription());


    }

    @Override
    public void onFinish(ITestContext Context) {


        if (extentReport != null) {
            extentReport.flush();
        } else {
            // Handle the case when extentReport is null
            System.err.println("extentReport is null. Cannot flush.");
        }

//        extentReport.flush();

    }

    public void onTestStart(ITestResult result) {

//        String description = result.getMethod().getDescription();
//        testCase = extentReport.createTest(result.getMethod().getMethodName(), description);
        testCase = extentReport.createTest(result.getMethod().getDescription());


    }

    public void onTestSuccess(ITestResult result) {

        testCase.pass("Test has been Passed");
        testCase.assignCategory(result.getMethod().getMethodName());
    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

}
