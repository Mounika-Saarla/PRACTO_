
package com.parameters;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//public class ExcelReader {
//
//
//    public static String getSpecializationFromExcel() throws IOException {
//    	String filePath = System.getProperty("user.dir") + "/src/test/resources/ExcelData/TestSpecialization.xlsx";   
//    	
//   	try (FileInputStream fis = new FileInputStream(filePath);
//             Workbook workbook = new XSSFWorkbook(fis)) {
//
//
//   		
//    		Sheet sheet = workbook.getSheet("Sheet1");
//   		
//           Row row = sheet.getRow(0);            // Row 1 = index 0
//            
//            Cell cell = row.getCell(0);           // Column A = index 0
//            return cell.getStringCellValue().trim(); 
//           
//        }
//  
//}
//}

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelReader {
public static String getName(String filePath, int sheetIndex, int rowIndex) {
    try (FileInputStream fis = new FileInputStream(filePath);
         Workbook workbook = new XSSFWorkbook(fis)) {
 
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        Row row = sheet.getRow(rowIndex);
        if (row != null) {
            Cell cell = row.getCell(0);
            if (cell != null) {
                return cell.getStringCellValue().trim();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
 
return null;
}
}