package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.SearchPage;
import utilities.ScrollUtils;
import utilities.WaitUtils;

public class SearchTest extends BaseTest {

	SearchPage page =
            new SearchPage();

    @Test
    public void wikipediaSearchTest() {

        logger.info("Searching Selenium");
        test.info("Searching Selenium");
        
        ScrollUtils.scrollToElement(
                driver,
                driver.findElement(page.searchBar));
        
        WaitUtils.pause(2);

        driver.findElement(page.searchBar)
              .sendKeys("Selenium");
        
        WaitUtils.pause(2);

        driver.findElement(page.searchBtn)
              .click();

        Assert.assertTrue(
                driver.getPageSource()
                      .contains("Selenium"));

        test.pass(
                "Wikipedia search successful");
    }
}
