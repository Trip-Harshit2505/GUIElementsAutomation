package pages;

import org.openqa.selenium.By;

public class TablePage {

    // Static Table
    public By staticWebTableRows =
            By.xpath("//table[@name='BookTable']/tbody/tr");

    public By staticWebTableCols =
            By.xpath("//table[@name='BookTable']/tbody/tr[1]/th");

    // Dynamic Table
    public By dynamicTableRows =
            By.xpath("//table[@id='taskTable']/tbody/tr");

    public By dynamicTableCols =
            By.xpath("//table[@id='taskTable']/thead/tr/th");

    // Pagination Table
    public By paginationRows =
            By.xpath("//table[@id='productTable']/tbody/tr");

    public By nextPage =
            By.xpath("//a[text()='Next']");
}
