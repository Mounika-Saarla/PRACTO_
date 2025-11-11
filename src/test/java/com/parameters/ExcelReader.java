package com.parameters;



import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;

public class ExcelReader {
    public static String getCellData(String sheetName, int row, int col) throws Exception {
        FileInputStream fis = new FileInputStream("src/test/resources/Exceldata/Data.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheet(sheetName);
        return sheet.getRow(row).getCell(col).getStringCellValue();
    }
}