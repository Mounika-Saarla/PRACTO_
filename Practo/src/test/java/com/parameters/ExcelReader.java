package com.parameters;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.pages.userpage;

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
    


public static String getCellData(String sheetName, int row, int col) throws Exception {
        String excelPath = PropertyReader.getProperty("excelFilePath");
        FileInputStream fis = new FileInputStream(excelPath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            workbook.close();
            throw new RuntimeException("Sheet '" + sheetName + "' not found in Excel file.");
        }

        Row r = sheet.getRow(row);
        if (r == null) {
            workbook.close();
            throw new RuntimeException("Row " + row + " not found in sheet '" + sheetName + "'");
        }

        Cell c = r.getCell(col);
        if (c == null) {
            workbook.close();
            throw new RuntimeException("Cell [" + row + "," + col + "] not found in sheet '" + sheetName + "'");
        }

        String value;
        if (c.getCellType() == CellType.NUMERIC) {
            value = String.valueOf((int) c.getNumericCellValue());
        } else {
            value = c.getStringCellValue();
        }

        workbook.close();
        return value;
    }
public String getCity(int row) throws Exception {
    return getCellData(row, 0); // Column 0 for city
}

public String getRole(int row) throws Exception {
    return getCellData(row, 1); // Column 1 for Role
}


}