package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.UploadPage;

public class UploadTest extends BaseTest {

	UploadPage page =
            new UploadPage();

    @Test
    public void uploadSingleFile() {

        logger.info("Starting Single File Upload Test");
        test.info("Starting Single File Upload Test");

        String path =
                System.getProperty("user.dir")
                + "\\src\\test\\resources\\file1.pdf";

        logger.info("Uploading file: " + path);
        test.info("Uploading file: file1.pdf");

        driver.findElement(page.uploadFile)
                .sendKeys(path);

        logger.info("Clicking Upload Single File button");
        test.info("Clicking Upload Single File button");

        driver.findElement(
                page.submitSingleFileButton)
                .click();

        logger.info("Verifying upload success message");
        test.info("Verifying upload success message");

        String successMsg =
                driver.findElement(page.uploadSuccessMessage)
                      .getText();

        Assert.assertTrue(
                successMsg.contains("file1.pdf"));

        logger.info("Single File Upload completed successfully");
        test.pass("Single File uploaded successfully");
    }

    @Test
    public void uploadMultipleFiles() {

        logger.info("Starting Multiple File Upload Test");
        test.info("Starting Multiple File Upload Test");

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

        driver.findElement(
                page.submitMultipleFilesButton)
                .click();

        logger.info("Verifying multiple file upload success message");
        test.info("Verifying multiple file upload success message");

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