package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static Object[][] getExcelData()
            throws Exception {

        String path =
                System.getProperty("user.dir")
                + "\\src\\test\\resources\\TestData.xlsx";

        FileInputStream fis =
                new FileInputStream(path);

        Workbook workbook =
                new XSSFWorkbook(fis);

        Sheet sheet =
                workbook.getSheetAt(0);

        int rows =
                sheet.getPhysicalNumberOfRows();

        int cols =
                sheet.getRow(0)
                     .getPhysicalNumberOfCells();

        Object[][] data =
                new Object[rows - 1][cols];

        for(int i = 1; i < rows; i++) {

            for(int j = 0; j < cols; j++) {

            	DataFormatter formatter =
            	        new DataFormatter();

            	data[i-1][j] =
            	        formatter.formatCellValue(
            	                sheet.getRow(i)
            	                     .getCell(j));
            }
        }

        workbook.close();
        fis.close();

        return data;
    }
}
