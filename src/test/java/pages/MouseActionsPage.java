package pages;

import org.openqa.selenium.By;

public class MouseActionsPage {

    // Hover
    public By pointMeButton =
            By.xpath("//button[text()='Point Me']");

    public By mobilesOption =
            By.xpath("//div[@class='dropdown-content']//a[text()='Mobiles']");

    public By laptopsOption =
            By.xpath("//div[@class='dropdown-content']//a[text()='Laptops']");

    // Double Click
    public By field1 = By.id("field1");
    public By field2 = By.id("field2");

    public By copyTextButton =
            By.xpath("//button[text()='Copy Text']");

    // Drag Drop
    public By draggable =
            By.id("draggable");

    public By droppable =
            By.id("droppable");

    // Slider
    public By sliderRange =
            By.id("slider-range");

    public By minSliderHandle =
            By.xpath("//div[@id='slider-range']/span[1]");

    public By maxSliderHandle =
            By.xpath("//div[@id='slider-range']/span[2]");

    public By priceRange =
            By.xpath("//input[@id='amount']");
}
