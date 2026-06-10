package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.WindowPage;

public class WindowHandlingTest extends BaseTest{
	
	WindowPage page =
            new WindowPage();
	
	@Test
	public void newTabTest() {

	    logger.info("Opening new tab");
	    test.info("Opening new tab");

	    String parent =
	            driver.getWindowHandle();

	    driver.findElement(page.newTab)
	          .click();

	    for(String window :
	            driver.getWindowHandles()) {

	        driver.switchTo()
	              .window(window);
	    }

	    Assert.assertNotEquals(
	            driver.getWindowHandle(),
	            parent);

	    test.pass(
	            "New tab opened successfully");
	}
	
	@Test
	public void popupWindowTest() {

	    logger.info("Opening popup window");
	    test.info("Opening popup window");

	    String parent =
	            driver.getWindowHandle();

	    driver.findElement(page.popup)
	          .click();

	    for(String window :
	            driver.getWindowHandles()) {

	        driver.switchTo()
	              .window(window);
	    }

	    Assert.assertNotEquals(
	            driver.getWindowHandle(),
	            parent);

	    test.pass(
	            "Popup window opened successfully");
	}
}
