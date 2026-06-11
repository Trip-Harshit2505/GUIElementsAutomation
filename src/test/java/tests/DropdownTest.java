package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FormPage;
import utilities.ScrollUtils;
import utilities.WaitUtils;

public class DropdownTest extends BaseTest {

	FormPage page =
            new FormPage();

    @Test(priority=1)
    public void selectColor() {

        logger.info("Selecting color");
        test.info("Selecting color");
        
        ScrollUtils.scrollToElement(
                driver,
                driver.findElement(page.colors));
        
        WaitUtils.pause(2);

        Select colors =
                new Select(
                        driver.findElement(
                                page.colors));

        colors.selectByVisibleText("Red");
        
        WaitUtils.pause(2);

        String selected =
                colors.getFirstSelectedOption()
                      .getText();

        Assert.assertEquals(
                selected,
                "Red");

        test.pass("Color selected successfully");
    }

    @Test(priority=2)
    public void selectAnimal() {

        logger.info("Selecting animal");
        test.info("Selecting animal");
        
        ScrollUtils.scrollToElement(
                driver,
                driver.findElement(page.animals));
        
        WaitUtils.pause(2);

        Select animals =
                new Select(
                        driver.findElement(
                                page.animals));

        animals.selectByVisibleText("Dog");
        
        WaitUtils.pause(2);

        String selected =
                animals.getFirstSelectedOption()
                       .getText();

        Assert.assertEquals(
                selected,
                "Dog");

        test.pass("Animal selected successfully");
    }
}