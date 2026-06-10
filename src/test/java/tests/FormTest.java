package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FormPage;
import utilities.TestDataProvider;
import utilities.WaitUtils;

public class FormTest extends BaseTest {

    FormPage page =
            new FormPage();

    @Test
    public void fillForm() {

        logger.info("Starting fillForm test");
        test.info("Starting fillForm test");

        logger.info("Entering Name");
        WaitUtils.waitForElementVisible(
                driver, page.name)
                .sendKeys("Harshit");

        logger.info("Entering Email");
        driver.findElement(page.email)
                .sendKeys("abc@gmail.com");

        logger.info("Entering Phone");
        driver.findElement(page.phone)
                .sendKeys("9876543210");

        logger.info("Entering Address");
        driver.findElement(page.address)
                .sendKeys("Bhopal");

        logger.info("Selecting Male as Gender");
        driver.findElement(page.male)
                .click();

        logger.info("Selecting Country: India");
        Select country =
                new Select(
                        driver.findElement(
                                page.country));

        country.selectByVisibleText("India");

        logger.info("Verifying Name field value");
        Assert.assertEquals(
                driver.findElement(page.name)
                        .getAttribute("value"),
                "Harshit");

        logger.info("Verifying Male radio button is selected");
        Assert.assertTrue(
                driver.findElement(page.male)
                        .isSelected());
        test.info("Male radio button verification successfull");

        logger.info("fillForm test completed successfully");
        test.info("fillForm test completed successfully");
    }

    @Test(
            dataProvider = "excelData",
            dataProviderClass = TestDataProvider.class)
    public void fillFormDDT(
            String name,
            String email,
            String phone,
            String address) {

        logger.info("Starting DDT execution");
        test.info("Starting DDT execution");

        logger.info("Entering Name: " + name);
        driver.findElement(page.name)
                .sendKeys(name);

        logger.info("Entering Email: " + email);
        driver.findElement(page.email)
                .sendKeys(email);

        logger.info("Entering Phone: " + phone);
        driver.findElement(page.phone)
                .sendKeys(phone);

        logger.info("Entering Address: " + address);
        driver.findElement(page.address)
                .sendKeys(address);

        logger.info("Verifying Name field value");
        Assert.assertEquals(
                driver.findElement(page.name)
                        .getAttribute("value"),
                name);

        logger.info("DDT execution completed successfully for user: " + name);
        test.info("DDT execution completed successfully for user: " + name);
    }
}