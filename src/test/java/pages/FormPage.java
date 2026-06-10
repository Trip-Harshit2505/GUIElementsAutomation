package pages;

import org.openqa.selenium.By;

public class FormPage {

    // Form Details
    public By name = By.id("name");
    public By email = By.id("email");
    public By phone = By.id("phone");
    public By address = By.id("textarea");

    // Gender
    public By male = By.id("male");
    public By female = By.id("female");

    // Days
    public By sunday = By.id("sunday");
    public By monday = By.id("monday");
    public By tuesday = By.id("tuesday");
    public By wednesday = By.id("wednesday");
    public By thursday = By.id("thursday");
    public By friday = By.id("friday");
    public By saturday = By.id("saturday");

    // Dropdowns
    public By country = By.id("country");
    public By colors = By.id("colors");
    public By animals = By.id("animals");
}
