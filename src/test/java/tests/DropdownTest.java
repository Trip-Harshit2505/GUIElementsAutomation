package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FormPage;

public class DropdownTest extends BaseTest {

	FormPage page =
            new FormPage();

    @Test
    public void selectColor() {

        logger.info("Selecting color");
        test.info("Selecting color");

        Select colors =
                new Select(
                        driver.findElement(
                                page.colors));

        colors.selectByVisibleText("Red");

        String selected =
                colors.getFirstSelectedOption()
                      .getText();

        Assert.assertEquals(
                selected,
                "Red");

        test.pass("Color selected successfully");
    }

    @Test
    public void selectAnimal() {

        logger.info("Selecting animal");
        test.info("Selecting animal");

        Select animals =
                new Select(
                        driver.findElement(
                                page.animals));

        animals.selectByVisibleText("Dog");

        String selected =
                animals.getFirstSelectedOption()
                       .getText();

        Assert.assertEquals(
                selected,
                "Dog");

        test.pass("Animal selected successfully");
    }
}