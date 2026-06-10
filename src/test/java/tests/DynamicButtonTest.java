package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import base.BaseTest;
import pages.DynamicButtonPage;

import utilities.WaitUtils;

public class DynamicButtonTest extends BaseTest{
	
	DynamicButtonPage page =
            new DynamicButtonPage();
	
	@Test
    public void dynamicBtnTest() {

        logger.info("Clicking Start Button");
        test.info("Clicking Start Button");

        driver.findElement(page.dynamicBtnStart)
              .click();

        WebElement stopBtn =
                WaitUtils.waitForElementClickable(
                        driver,
                        page.dynamicBtnStop);

        logger.info("Stop Button is enabled");
        test.info("Stop Button is enabled");

        Assert.assertTrue(
                stopBtn.isEnabled(),
                "Stop button is not enabled");
    }
}
