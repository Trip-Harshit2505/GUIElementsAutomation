package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.SearchPage;

public class SearchTest extends BaseTest {

	SearchPage page =
            new SearchPage();

    @Test
    public void wikipediaSearchTest() {

        logger.info("Searching Selenium");
        test.info("Searching Selenium");

        driver.findElement(page.searchBar)
              .sendKeys("Selenium");

        driver.findElement(page.searchBtn)
              .click();

        Assert.assertTrue(
                driver.getPageSource()
                      .contains("Selenium"));

        test.pass(
                "Wikipedia search successful");
    }
}
