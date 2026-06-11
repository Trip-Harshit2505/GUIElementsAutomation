package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.UploadPage;
import utilities.ScrollUtils;
import utilities.WaitUtils;

public class UploadTest extends BaseTest {

	UploadPage page =
            new UploadPage();

    @Test(priority=1)
    public void uploadSingleFile() {

        logger.info("Starting Single File Upload Test");
        test.info("Starting Single File Upload Test");
        
        ScrollUtils.scrollToElement(
                driver,
                driver.findElement(page.uploadFile));
        
        WaitUtils.pause(2);

        String path =
                System.getProperty("user.dir")
                + "\\src\\test\\resources\\file1.pdf";

        logger.info("Uploading file: " + path);
        test.info("Uploading file: file1.pdf");

        driver.findElement(page.uploadFile)
                .sendKeys(path);

        logger.info("Clicking Upload Single File button");
        test.info("Clicking Upload Single File button");
        
        WaitUtils.pause(2);

        driver.findElement(
                page.submitSingleFileButton)
                .click();

        logger.info("Verifying upload success message");
        test.info("Verifying upload success message");
        
        WaitUtils.pause(2);

        String successMsg =
                driver.findElement(page.uploadSuccessMessage)
                      .getText();

        Assert.assertTrue(
                successMsg.contains("file1.pdf"));

        logger.info("Single File Upload completed successfully");
        test.pass("Single File uploaded successfully");
    }

    @Test(priority=2)
    public void uploadMultipleFiles() {

        logger.info("Starting Multiple File Upload Test");
        test.info("Starting Multiple File Upload Test");
        
        ScrollUtils.scrollToElement(
                driver,
                driver.findElement(page.uploadFiles));
        
        WaitUtils.pause(2);

        String file1 =
                System.getProperty("user.dir")
                + "\\src\\test\\resources\\file1.pdf";

        String file2 =
                System.getProperty("user.dir")
                + "\\src\\test\\resources\\file2.pdf";

        logger.info("Uploading files: file1.pdf and file2.pdf");
        test.info("Uploading files: file1.pdf and file2.pdf");

        driver.findElement(page.uploadFiles)
                .sendKeys(file1 + "\n" + file2);

        logger.info("Clicking Upload Multiple Files button");
        test.info("Clicking Upload Multiple Files button");
        
        WaitUtils.pause(2);

        driver.findElement(
                page.submitMultipleFilesButton)
                .click();

        logger.info("Verifying multiple file upload success message");
        test.info("Verifying multiple file upload success message");
        
        WaitUtils.pause(2);

        String successMsg =
                driver.findElement(page.multipleUploadSuccessMessage)
                      .getText();

        Assert.assertTrue(
                successMsg.contains("file1.pdf")
                && successMsg.contains("file2.pdf"),
                "Uploaded files not displayed correctly");

        logger.info("Multiple File Upload completed successfully");
        test.pass("Multiple files uploaded successfully");
    }
}