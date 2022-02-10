package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener{

    private ExtentTest extentTest;
    private ExtentSparkReporter spark;
    private ExtentReports extent;



    // Smoketest text context

    @Override
    public void onStart(ITestContext iTestContext) {
        extent = new ExtentReports();
        String reportPath = System.getProperty("user.dir") + "/reports/result.html";
        spark = new ExtentSparkReporter(reportPath);
        extent.attachReporter(spark);
        spark.config().setTheme(Theme.DARK);



    }

    // ON test cases
    @Override
    public void onTestStart(ITestResult iTestResult) {
        String testCaseName = iTestResult.getMethod().getMethodName();
        extentTest = extent.createTest(testCaseName);

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        WebDriver driver = DriverUtil.driver();
        String screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
        extentTest.addScreenCaptureFromBase64String(screenshot,"Failed");

        extentTest.fail("This test case has failed");

    }




    @Override
    public void onFinish(ITestContext iTestContext) {
        extent.flush();

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        extentTest.pass("This test case has passed");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        extentTest.skip("This test case has been skipped");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    /*
    - OnStart & OnFinish is about text context for example SmokeTest, Regression test which contains multiple test cases.

    - OnTestStart, OnTestSuccess, OnTestFailure are about individual test cases that are contained inside the smokeTest and regression test.

    - TestListener class implements methods that will be executed automatically as the test execution progresses.
        Basically test execution detection which we can use or utilize to generate report on the fly.

    - Once you implement TestListener class don't forget to add it to listener class in testng.xml file.
    or as a tag for the test class example : @Listeners (utility.TestListener.class)



     */
}


