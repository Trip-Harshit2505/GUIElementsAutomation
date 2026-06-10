package base;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import utilities.*;

public class BaseTest {

    protected WebDriver driver;

    protected static ExtentReports extent;
    protected ExtentTest test;
    
    protected static final Logger logger =
            LogManager.getLogger(BaseTest.class);

    @BeforeSuite
    public void setupReport() {

        extent =
                ExtentManager.getInstance();
    }

    @BeforeMethod
    public void setup(Method method) {

        driver =
                DriverFactory.getDriver();

        driver.get(
                "https://testautomationpractice.blogspot.com/");

        test =
                extent.createTest(
                        method.getName());
        
        logger.info("Starting Test : " + method.getName());
    }

    @AfterMethod
    public void tearDown(
            ITestResult result)
            throws Exception {

        if(result.getStatus()
                == ITestResult.SUCCESS) {

            test.pass("Test Passed");
        }

        else if(result.getStatus()
                == ITestResult.FAILURE) {

        	String screenshotPath =
                    ScreenshotUtils.capture(
                            driver,
                            result.getMethod()
                                  .getMethodName());


            test.fail(
                    result.getThrowable());
            
            test.addScreenCaptureFromPath(
                    screenshotPath);
        }

        DriverFactory.quitDriver();
    }

    @AfterSuite
    public void closeReport() {

        extent.flush();
    }
}