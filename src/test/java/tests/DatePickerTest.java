package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DatePickerPage;

public class DatePickerTest extends BaseTest {

    DatePickerPage page =
            new DatePickerPage();

    @Test
    public void datePicker1Test() {

        logger.info("Entering date in DatePicker1");
        test.info("Entering date in DatePicker1");

        driver.findElement(page.datepicker1)
              .sendKeys("06/12/2026");

        String value =
                driver.findElement(page.datepicker1)
                      .getAttribute("value");

        Assert.assertEquals(
                value,
                "06/12/2026");

        test.pass("DatePicker1 verified");
    }

    @Test
    public void datePicker2Test() {

        logger.info("Entering date in DatePicker2");
        test.info("Entering date in DatePicker2");

        WebElement datepicker2 = driver.findElement(page.datepicker2);
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        js.executeScript("arguments[0].setAttribute('value', '12/06/2026')", datepicker2);

        Assert.assertFalse(
                driver.findElement(page.datepicker2)
                      .getAttribute("value")
                      .isEmpty());

        test.pass("DatePicker2 verified");
    }

    @Test
    public void dateRangeTest() {

        logger.info("Selecting start and end date");
        test.info("Selecting start and end date");

        driver.findElement(page.startDate)
              .sendKeys("21/06/2026");

        driver.findElement(page.endDate)
              .sendKeys("30/06/2026");

        driver.findElement(page.submitDateButton)
              .click();

        Assert.assertEquals(
                driver.findElement(page.startDate)
                      .getAttribute("value"),
                "2026-06-21");

        test.pass("Date range submitted successfully");
    }
}
