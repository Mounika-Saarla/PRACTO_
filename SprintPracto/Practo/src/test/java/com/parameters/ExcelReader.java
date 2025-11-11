package com.parameters;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;

public class ExcelReader {
    public String getCellData(int row, int col) throws Exception {
    	String excelPath = "C:\\Training\\SprintPracto\\Practo\\src\\test\\resources\\TestData\\Practo_Automation.xlsx";
        FileInputStream fis = new FileInputStream(excelPath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        String data = sheet.getRow(row).getCell(col).getStringCellValue();
        workbook.close();
        return data;
    }

    public String getLocation(int row) throws Exception {
        return getCellData(row, 0); // Column 0 for Location
    }

    public String getSpeciality(int row) throws Exception {
        return getCellData(row, 1); // Column 1 for Speciality
    }
}