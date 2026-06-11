package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.WindowPage;
import utilities.ScrollUtils;
import utilities.WaitUtils;

public class WindowHandlingTest extends BaseTest{
	
	WindowPage page =
            new WindowPage();
	
	@Test(priority=1)
	public void newTabTest() {

	    logger.info("Opening new tab");
	    test.info("Opening new tab");

	    String parent =
	            driver.getWindowHandle();
	    
	    WaitUtils.pause(2);

	    driver.findElement(page.newTab)
	          .click();

	    for(String window :
	            driver.getWindowHandles()) {

	        driver.switchTo()
	              .window(window);
	    }
	    
	    WaitUtils.pause(2);

	    Assert.assertNotEquals(
	            driver.getWindowHandle(),
	            parent);

	    test.pass(
	            "New tab opened successfully");
	}
	
	@Test(priority=2)
	public void popupWindowTest() {

	    logger.info("Opening popup window");
	    test.info("Opening popup window");
	    
	    ScrollUtils.scrollToElement(
                driver,
                driver.findElement(page.popup));
	    
	    WaitUtils.pause(2);

	    String parent =
	            driver.getWindowHandle();

	    driver.findElement(page.popup)
	          .click();
	    
	    WaitUtils.pause(2);

	    for(String window :
	            driver.getWindowHandles()) {

	        driver.switchTo()
	              .window(window);
	    }
	    
	    WaitUtils.pause(2);

	    Assert.assertNotEquals(
	            driver.getWindowHandle(),
	            parent);

	    test.pass(
	            "Popup window opened successfully");
	}
}
