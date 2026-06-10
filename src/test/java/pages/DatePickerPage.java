package pages;

import org.openqa.selenium.By;

public class DatePickerPage {

    public By datepicker1 =
            By.id("datepicker");

    public By datepicker2 =
            By.id("txtDate");

    public By startDate =
            By.id("start-date");

    public By endDate =
            By.id("end-date");

    public By submitDateButton =
            By.xpath("//button[@class='submit-btn']");
}
