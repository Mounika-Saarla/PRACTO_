package com.parameters;
 
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
 
public class ExcelReader {
    public static String getCellData(String sheetName, int rowNum, int colNum) {
        String value = "";
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/com/Excel/PractoTetSc1.xlsx");
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(colNum);
            value = cell.getStringCellValue();
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}