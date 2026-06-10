package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AlertPage;

public class AlertTest extends BaseTest {

    AlertPage page =
            new AlertPage();

    @Test(priority = 1)
    public void handleSimpleAlert() {
    	
    	logger.info("Clicking the Simple alert button");
    	test.info("Clicking the Simple alert button");
        driver.findElement(page.simpleAlertButton)
                .click();
        
        logger.info("Accepting the alert popup");
        driver.switchTo()
                .alert()
                .accept();

        Assert.assertTrue(true);
        logger.info("Simple alert button worked successfully");
        test.info("Simple alert button worked successfully");
    }

    @Test(priority = 2)
    public void handleConfirmationAlert() {

    	logger.info("Clicking the Confirm alert button");
    	test.info("Clicking the Confirm alert button");
        driver.findElement(page.confirmAlertButton)
                .click();
        
        logger.info("Accepting the alert popup");
        driver.switchTo()
                .alert()
                .accept();

        Assert.assertTrue(true);
        logger.info("Confirm alert button worked successfully");
        test.info("Confirm alert button worked successfully");
    }

    @Test(priority = 3)
    public void handlePromptAlert() {
    	
    	logger.info("Clicking the Prompt alert button");
    	test.info("Clicking the Prompt alert button");
        driver.findElement(page.promptAlertButton)
                .click();
        
        logger.info("Sending prompt to alert");
        driver.switchTo()
                .alert()
                .sendKeys("Harshit");
        
        logger.info("Accepting the alert popup");
        driver.switchTo()
                .alert()
                .accept();

        String text =
                driver.findElement(page.promptResult)
                      .getText();

        Assert.assertTrue(
                text.contains("Harshit"));
        logger.info("Prompt alert button worked successfully");
        test.info("Prompt alert button worked successfully");
    }
}