package pages;

import org.openqa.selenium.By;

public class UploadPage {

    public By uploadFile =
            By.id("singleFileInput");

    public By submitSingleFileButton =
            By.xpath("//button[text()='Upload Single File']");

    public By uploadSuccessMessage =
            By.id("singleFileStatus");

    public By uploadFiles =
            By.id("multipleFilesInput");

    public By submitMultipleFilesButton =
            By.xpath("//button[text()='Upload Multiple Files']");

    public By multipleUploadSuccessMessage =
            By.id("multipleFilesStatus");
}