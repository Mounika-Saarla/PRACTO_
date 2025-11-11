//package com.parameters;
//
//import java.io.FileInputStream;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelReader {
//    public static String getCellData(String filePath, String sheetName, int rowNum, int colNum) throws Exception {
//        FileInputStream fis = new FileInputStream(filePath);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheet(sheetName);
//        Row row = sheet.getRow(rowNum);
//        Cell cell = row.getCell(colNum);
//
//        String cellValue = cell.getStringCellValue();
//
//        workbook.close();
//        fis.close();
//        return cellValue;
//    }
//}

//package com.parameters;
//
//import java.io.FileInputStream;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelReader{
//
//    public static String getCellData(String filePath, String sheetName, int rowNum, int colNum) throws Exception {
//        FileInputStream fis = new FileInputStream(filePath);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheet(sheetName);
//
//        if (sheet == null) {
//            workbook.close();
//            fis.close();
//            throw new Exception("Sheet '" + sheetName + "' not found in file: " + filePath);
//        }
//
//        Row row = sheet.getRow(rowNum);
//        if (row == null) {
//            workbook.close();
//            fis.close();
//            throw new Exception("Row " + rowNum + " not found in sheet: " + sheetName);
//        }
//
//        Cell cell = row.getCell(colNum);
//        if (cell == null) {
//            workbook.close();
//            fis.close();
//            throw new Exception("Cell " + colNum + " not found in row: " + rowNum);
//        }
//
//        String cellValue = cell.getStringCellValue();
//
//        workbook.close();
//        fis.close();
//        return cellValue;
//    }
//}


package com.parameters;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
public class ExcelReader {
    public static String getCellData(String sheetName, int rowNum, int colNum) {
        String value = "";
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\dyamaa\\SpritPracto\\Practo\\src\\test\\resources\\Excel\\TestData.xlsx");
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