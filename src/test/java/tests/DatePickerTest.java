package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DatePickerPage;
import utilities.ScrollUtils;
import utilities.WaitUtils;

public class DatePickerTest extends BaseTest {

    DatePickerPage page =
            new DatePickerPage();

    @Test(priority=1)
    public void datePicker1Test() {

        logger.info("Entering date in DatePicker1");
        test.info("Entering date in DatePicker1");
        
        ScrollUtils.scrollToElement(
                driver,
                driver.findElement(page.datepicker1));
        
        WaitUtils.pause(2);

        driver.findElement(page.datepicker1)
              .sendKeys("06/12/2026");
        
        WaitUtils.pause(2);

        String value =
                driver.findElement(page.datepicker1)
                      .getAttribute("value");

        Assert.assertEquals(
                value,
                "06/12/2026");

        test.pass("DatePicker1 verified");
    }

    @Test(priority=2)
    public void datePicker2Test() {

        logger.info("Entering date in DatePicker2");
        test.info("Entering date in DatePicker2");
        
        ScrollUtils.scrollToElement(
                driver,
                driver.findElement(page.datepicker2));
        
        WaitUtils.pause(2);

        WebElement datepicker2 = driver.findElement(page.datepicker2);
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        js.executeScript("arguments[0].setAttribute('value', '12/06/2026')", datepicker2);
        
        WaitUtils.pause(2);
        
        Assert.assertFalse(
                driver.findElement(page.datepicker2)
                      .getAttribute("value")
                      .isEmpty());

        test.pass("DatePicker2 verified");
    }

    @Test(priority=3)
    public void dateRangeTest() {

        logger.info("Selecting start and end date");
        test.info("Selecting start and end date");
        
        ScrollUtils.scrollToElement(
                driver,
                driver.findElement(page.startDate));
        
        WaitUtils.pause(2);

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].value='2026-06-21';",
                driver.findElement(page.startDate));

        js.executeScript(
                "arguments[0].value='2026-06-30';",
                driver.findElement(page.endDate));
        
        WaitUtils.pause(2);

        driver.findElement(page.submitDateButton)
              .click();
        
        String actualDate =
                driver.findElement(page.startDate)
                      .getAttribute("value");

        logger.info("Actual Start Date = " + actualDate);
        test.info("Actual Start Date = " + actualDate);

        System.out.println(actualDate);

        Assert.assertEquals(
                driver.findElement(page.startDate)
                      .getAttribute("value"),
                "2026-06-21");

        test.pass("Date range submitted successfully");
    }
}
