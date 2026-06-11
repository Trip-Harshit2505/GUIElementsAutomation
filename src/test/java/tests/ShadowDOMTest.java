package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ShadowDOMPage;
import utilities.ScrollUtils;
import utilities.WaitUtils;

public class ShadowDOMTest extends BaseTest{
	
	ShadowDOMPage page = new ShadowDOMPage();
	
	@Test(priority=1)
	public void shadowTextBoxTest() {

	    logger.info("Handling Shadow DOM Textbox");
	    test.info("Handling Shadow DOM Textbox");
	    
	    ScrollUtils.scrollToElement(
                driver,
                driver.findElement(page.shadowHost));
	    
	    WaitUtils.pause(2);

	    WebElement host =
	            driver.findElement(page.shadowHost);

	    SearchContext shadowRoot =
	            host.getShadowRoot();

	    WebElement textBox =
	            shadowRoot.findElement(
	                    By.cssSelector("input[type='text']"));

	    textBox.sendKeys("Harshit");
	    
	    WaitUtils.pause(2);

	    Assert.assertEquals(
	            textBox.getAttribute("value"),
	            "Harshit");

	    test.pass("Shadow textbox verified");
	}
	
	@Test(priority=2)
	public void shadowCheckboxTest() {

	    logger.info("Handling Shadow DOM Checkbox");
	    test.info("Handling Shadow DOM Checkbox");
	    
	    ScrollUtils.scrollToElement(
                driver,
                driver.findElement(page.shadowHost));
	    
	    WaitUtils.pause(2);

	    WebElement host =
	            driver.findElement(page.shadowHost);

	    SearchContext shadowRoot =
	            host.getShadowRoot();

	    WebElement checkbox =
	            shadowRoot.findElement(
	                    By.cssSelector("input[type='checkbox']"));
	    
	    WaitUtils.pause(2);

	    checkbox.click();
	    
	    WaitUtils.pause(2);

	    Assert.assertTrue(
	            checkbox.isSelected());

	    test.pass("Checkbox selected successfully");
	}
	
	@Test(priority=3)
	public void shadowFileUploadTest() {

	    logger.info("Uploading file inside Shadow DOM");
	    test.info("Uploading file inside Shadow DOM");
	    
	    ScrollUtils.scrollToElement(
                driver,
                driver.findElement(page.shadowHost));
	    
	    WaitUtils.pause(2);

	    String filePath =
	            System.getProperty("user.dir")
	            + "\\src\\test\\resources\\file1.pdf";

	    WebElement host =
	            driver.findElement(page.shadowHost);

	    SearchContext shadowRoot =
	            host.getShadowRoot();

	    WebElement fileUpload =
	            shadowRoot.findElement(
	                    By.cssSelector("input[type='file']"));
	    
	    WaitUtils.pause(2);

	    fileUpload.sendKeys(filePath);
	    
	    WaitUtils.pause(2);

	    Assert.assertFalse(
	            fileUpload.getAttribute("value")
	                      .isEmpty());

	    test.pass("File uploaded successfully");
	}
	
	@Test(priority=4)
	public void clickBlogLinkTest() {

	    logger.info("Clicking Blog Link");
	    test.info("Clicking Blog Link");
	    
	    ScrollUtils.scrollToElement(
                driver,
                driver.findElement(page.shadowHost));
	    
	    WaitUtils.pause(2);

	    WebElement host =
	            driver.findElement(page.shadowHost);

	    SearchContext shadowRoot =
	            host.getShadowRoot();
	    
	    WebElement blogLink =
	            shadowRoot.findElement(
	                    By.cssSelector("a"));

	    System.out.println(
	            "Href = "
	            + blogLink.getAttribute("href"));

	    String href =
	            blogLink.getAttribute("href");

	    driver.navigate().to(href);
	    
	    WaitUtils.pause(2);

	    Assert.assertTrue(
	            driver.getCurrentUrl()
	                  .contains("pavantestingtools"));

	    test.pass("Blog link clicked successfully");
	}
	
}
