package utilities;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	@DataProvider(name = "excelData")
	public Object[][] excelData()
	        throws Exception {

	    return ExcelUtils.getExcelData();
	}
}
