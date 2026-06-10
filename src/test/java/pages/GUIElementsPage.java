package pages;

import org.openqa.selenium.By;

public class GUIElementsPage {
	
	// Details Form
	public By name = By.id("name");
	public By email = By.id("email");
	public By phone = By.id("phone");
	public By address = By.id("textarea");
	
	// Gender radio-button
	public By male = By.id("male");
	public By female = By.id("female");
	
	// Days Checkbox
	public By sunday = By.id("sunday");
	public By monday = By.id("monday");
	public By tuesday = By.id("tuesday");
	public By wednesday = By.id("wednesday");
	public By thursday = By.id("thursday");
	public By friday = By.id("friday");
	public By saturday = By.id("saturday");
	
	// Country Dropdown
	public By country = By.id("country");
	
	// Colors Dropdown
	public By colors = By.id("colors");
	
	// Sorted List Dropdown
	public By animals = By.id("animals");
	
	public By datepicker1 = By.id("datepicker");
	public By datepicker2 = By.id("txtDate");
	
	// Datepicker3
	public By startDate = By.id("start-date");
	public By endDate = By.id("end-date");
	public By submitDateButton = By.xpath("//button[@class='submit-btn']");
	
	public By home = By.linkText("Home");
	public By subscribe = By.linkText("Posts (Atom)");
	
	// Single File upload
	public By uploadFile = By.id("singleFileInput");
	public By submitSingleFileButton =
	        By.xpath("//button[text()='Upload Single File']");
	public By uploadSuccessMessage =
	        By.id("singleFileStatus");
	
	// Multiple file 
	public By uploadFiles = By.id("multipleFilesInput");
	public By submitMultipleFilesButton =
	        By.xpath("//button[text()='Upload Multiple Files']");
	public By multipleUploadSuccessMessage = By.id("multipleFilesStatus");
	
	// Static Web Table
	public By staticWebTableRows = By.xpath("//table[@name='BookTable']/tbody/tr");
	public By staticWebTableCols = By.xpath("//table[@name='BookTable']/tbody/tr[1]/th");
	
	// Dynamic Web Table
	public By dynamicTableRows =
	        By.xpath("//table[@id='taskTable']/tbody/tr");
	public By dynamicTableCols =
	        By.xpath("//table[@id='taskTable']/thead/tr/th");
	
	// Pagination Table
	public By paginationRows =
	        By.xpath("//table[@id='productTable']/tbody/tr");
	public By nextPage =
	        By.xpath("//a[text()='Next']");
	
	// Slider container
	public By sliderRange = By.id("slider-range");
	// Left handle
	public By minSliderHandle =
	        By.xpath("//div[@id='slider-range']/span[1]");
	// Right handle
	public By maxSliderHandle =
	        By.xpath("//div[@id='slider-range']/span[2]");
	
	// Price range
	public By priceRange =
	        By.xpath("//input[@id='amount']");
	
	// Search bar
	public By searchBar = By.id("Wikipedia1_wikipedia-search-input");
	public By searchBtn = By.xpath("//input[@type='submit']");
	
	// Dynamic button
	public By dynamicBtnStart = By.xpath("//button[@name='start']");
	public By dynamicBtnStop = By.xpath("//button[@name='stop']");
	
	// Alert popups
	public By simpleAlertButton =
	        By.id("alertBtn");
	public By confirmAlertButton =
	        By.id("confirmBtn");
	public By promptAlertButton =
	        By.id("promptBtn");
	public By confirmResult = By.id("demo");
	public By promptResult = By.id("demo");
	
	// New Browser window
	public By newTab = By.xpath("//button[text()='New Tab']");
	
	// PopUp window
	public By popup = By.id("PopUp");
	
	// Mouser Hover
	public By pointMeButton =
	        By.xpath("//button[text()='Point Me']");
	public By mobilesOption =
	        By.xpath("//div[@class='dropdown-content']//a[text()='Mobiles']");
	public By laptopsOption =
	        By.xpath("//div[@class='dropdown-content']//a[text()='Laptops']");	
	
	// Double Click
	public By field1 = By.id("field1");
	public By field2 = By.id("field2");
	public By copyTextButton = By.xpath("//button[text()='Copy Text']");
	
	// Drag drop 
	public By draggable = By.id("draggable");
	public By droppable = By.id("droppable");
	
	// Scrolling Dropdown
	public By scrollingDropDown = By.id("comboBox");
	
	// Links
	public By Apple = By.linkText("Apple");
	public By Lenovo = By.linkText("Lenovo");
	public By Dell = By.linkText("Dell");
	
	// Error code links 
	public By err400 = By.linkText("Errorcode 400");
	public By err401 = By.linkText("Errorcode 401");
	public By err403 = By.linkText("Errorcode 403");
	public By err404 = By.linkText("Errorcode 404");
	public By err408 = By.linkText("Errorcode 408");
	public By err500 = By.linkText("Errorcode 500");
	public By err502 = By.linkText("Errorcode 502");
	public By err503 = By.linkText("Errorcode 503");
	 
	// Form Details
	public By input1 = By.id("input1");
	public By formBtn1 = By.id("btn1");
	public By input2 = By.id("input2");
	public By formBtn2 = By.id("btn2");
	public By input3 = By.id("input3");
	public By formBtn3 = By.id("btn3");
}