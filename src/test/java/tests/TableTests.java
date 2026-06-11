package tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.TablePage;
import utilities.ScrollUtils;
import utilities.WaitUtils;

public class TableTests extends BaseTest {

    TablePage page =
            new TablePage();

    @Test(priority=1)
    public void verifyStaticTable() {

        logger.info("Starting Static Table Verification");
        test.info("Starting Static Table Verification");
        
        ScrollUtils.scrollToElement(
                driver,
                driver.findElement(page.staticWebTableRows));
        
        WaitUtils.pause(2);

        List<WebElement> rows =
                driver.findElements(
                        page.staticWebTableRows);

        logger.info("Number of rows found: " + rows.size());
        test.info("Number of rows found: " + rows.size());

        Assert.assertTrue(
                rows.size() > 0,
                "Static table has no rows");

        boolean seleniumBookFound = false;

        logger.info("Searching for Selenium book entry");
        test.info("Searching for Selenium book entry");

        for (WebElement row : rows) {

            if (row.getText().contains("Selenium")) {

                seleniumBookFound = true;

                logger.info("Selenium book found");
                test.info("Selenium book found");

                break;
            }
        }

        Assert.assertTrue(
                seleniumBookFound,
                "Selenium book not found");

        logger.info("Static Table Verification completed successfully");
        test.info("Static Table Verification completed successfully");
    }

    @Test(priority=2)
    public void verifyDynamicTable() {

        logger.info("Starting Dynamic Table Verification");
        test.info("Starting Dynamic Table Verification");
        
        ScrollUtils.scrollToElement(
                driver,
                driver.findElement(page.dynamicTableRows));
        
        WaitUtils.pause(2);

        List<WebElement> rows =
                driver.findElements(
                        page.dynamicTableRows);

        logger.info("Number of rows found: " + rows.size());
        test.info("Number of rows found: " + rows.size());

        Assert.assertTrue(
                rows.size() > 0,
                "Dynamic table is empty");

        logger.info("Dynamic Table Verification completed successfully");
        test.info("Dynamic Table Verification completed successfully");
    }

    @Test(priority=3)
    public void verifyChromePresent() {

        logger.info("Starting Chrome Row Verification");
        test.info("Starting Chrome Row Verification");
        
        ScrollUtils.scrollToElement(
                driver,
                driver.findElement(page.dynamicTableRows));
        
        WaitUtils.pause(2);


        List<WebElement> rows =
                driver.findElements(
                        page.dynamicTableRows);

        boolean chromeFound = false;

        logger.info("Searching for Chrome row");
        test.info("Searching for Chrome row");

        for (WebElement row : rows) {

            logger.info("Row Data : " + row.getText());

            if (row.getText().contains("Chrome")) {

                chromeFound = true;

                logger.info("Chrome row found");
                test.info("Chrome row found");

                break;
            }
        }

        Assert.assertTrue(
                chromeFound,
                "Chrome row not found");

        logger.info("Chrome Row Verification completed successfully");
        test.info("Chrome Row Verification completed successfully");
    }
    
    @Test(priority=4)
    public void verifyPaginationTable() {

        logger.info("Verifying Pagination Table");
        test.info("Verifying Pagination Table");
        
        ScrollUtils.scrollToElement(
                driver,
                driver.findElement(page.paginationRows));
        
        WaitUtils.pause(2);

        int totalRows = 0;

        while(true) {

            totalRows +=
                    driver.findElements(
                            page.paginationRows)
                            .size();

            try {

                driver.findElement(page.nextPage)
                      .click();
                
                WaitUtils.pause(1);

            }
            catch(Exception e) {

                break;
            }
        }

        logger.info(
                "Total rows found: "
                + totalRows);

        test.info(
                "Total rows found: "
                + totalRows);

        Assert.assertTrue(
                totalRows > 0);

        test.pass(
                "Pagination table verified");
    }
}