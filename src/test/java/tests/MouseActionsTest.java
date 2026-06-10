package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.MouseActionsPage;

public class MouseActionsTest extends BaseTest {

	MouseActionsPage page =
            new MouseActionsPage();

    @Test
    public void mouseHoverTest() {

        logger.info("Starting Mouse Hover Test");
        test.info("Starting Mouse Hover Test");

        Actions actions =
                new Actions(driver);

        logger.info("Hovering over Point Me button");
        test.info("Hovering over Point Me button");

        actions.moveToElement(
                driver.findElement(
                        page.pointMeButton))
                .perform();

        logger.info("Clicking Mobiles option");
        test.info("Clicking Mobiles option");

        driver.findElement(
                page.mobilesOption)
                .click();

        logger.info("Mouse Hover Test completed successfully");
        test.info("Mouse Hover Test completed successfully");
    }

    @Test
    public void dragAndDropTest() {

        logger.info("Starting Drag and Drop Test");
        test.info("Starting Drag and Drop Test");

        Actions actions =
                new Actions(driver);

        logger.info("Dragging element to drop area");
        test.info("Dragging element to drop area");

        actions.dragAndDrop(
                driver.findElement(
                        page.draggable),

                driver.findElement(
                        page.droppable))
                .perform();

        logger.info("Verifying drop operation");
        test.info("Verifying drop operation");

        Assert.assertTrue(
                driver.findElement(page.droppable)
                      .getText()
                      .contains("Dropped"));

        logger.info("Drag and Drop Test completed successfully");
        test.info("Drag and Drop Test completed successfully");
    }

    @Test
    public void doubleClickTest() {

        logger.info("Starting Double Click Test");
        test.info("Starting Double Click Test");

        Actions actions =
                new Actions(driver);

        logger.info("Performing double click on Copy Text button");
        test.info("Performing double click on Copy Text button");

        actions.doubleClick(
                driver.findElement(
                        page.copyTextButton))
                .perform();

        logger.info("Fetching values from both text fields");
        test.info("Fetching values from both text fields");

        String field1 =
                driver.findElement(page.field1)
                      .getAttribute("value");

        String field2 =
                driver.findElement(page.field2)
                      .getAttribute("value");

        logger.info("Verifying copied text");
        test.info("Verifying copied text");

        Assert.assertEquals(
                field1,
                field2,
                "Copied text mismatch");

        logger.info("Double Click Test completed successfully");
        test.info("Double Click Test completed successfully");
    }

    @Test
    public void sliderTest() {

        logger.info("Starting Slider Test");
        test.info("Starting Slider Test");

        WebElement minSlider =
                driver.findElement(
                        page.minSliderHandle);

        Actions actions =
                new Actions(driver);

        String before =
                driver.findElement(page.priceRange)
                      .getAttribute("value");

        logger.info("Slider value before movement: " + before);
        test.info("Slider value before movement: " + before);

        logger.info("Moving slider");
        test.info("Moving slider");

        actions.clickAndHold(minSlider)
                .moveByOffset(60, 0)
                .release()
                .perform();

        String after =
                driver.findElement(page.priceRange)
                      .getAttribute("value");

        logger.info("Slider value after movement: " + after);
        test.info("Slider value after movement: " + after);

        logger.info("Verifying slider value changed");
        test.info("Verifying slider value changed");

        Assert.assertNotEquals(
                before,
                after,
                "Slider value did not change");

        logger.info("Slider Test completed successfully");
        test.info("Slider Test completed successfully");
    }
}