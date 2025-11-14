
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
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
	public static String getName1(String filePath, int sheetIndex, int rowIndex) {
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
	
	public static final int HOSPITAL_COLUMN_INDEX=0;
	public static String pathfiles="C:\\training\\Java\\SprintPracto\\Practo\\src\\test\\resources\\ExcelData\\OrderMeds.xlsx";
	public static String getCellDatas(String filePath, Integer sheetIndex, Integer rowIndex, Integer colIndex) {
		String cellValue = "";
		FileInputStream fis = null;
		Workbook workbook = null;

		try {
			fis = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheetAt(sheetIndex);
			Row row = sheet.getRow(rowIndex);
			Cell cell = row.getCell(colIndex);

			if (cell != null) {
				cellValue = cell.toString().trim();
			}
		} catch (IOException e) {
			System.err.println("Error reading Excel file: " + e.getMessage());
		} finally {
			try {
				if (workbook != null) workbook.close();
				if (fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return cellValue;
	}

	
	// Siri code
	private static final String FILE_PATH = "src\\test\\resources\\ExcelData\\Form.xlsx";
	 
    public static Map<String, String> getRowData(String sheetName, int rowNum) {
        Map<String, String> data = new HashMap<>();
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = new XSSFWorkbook(fis)) {
 
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet " + sheetName + " not found in Excel file");
            }
 
            Row headerRow = sheet.getRow(0);
            Row dataRow = sheet.getRow(rowNum);
            if (headerRow == null || dataRow == null) {
                throw new RuntimeException("Invalid row index: " + rowNum);
            }
 
            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                Cell headerCell = headerRow.getCell(i);
                Cell valueCell = dataRow.getCell(i);
                if (headerCell != null && valueCell != null) {
                    String key = headerCell.getStringCellValue().trim();
                    String value = getCellValue(valueCell);
                    data.put(key, value);
                }
            }
 
        } catch (Exception e) {
            throw new RuntimeException("Error reading Excel: " + e.getMessage());
        }
        return data;
    }
 
    private static String getCellValue(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    // Convert numeric to long if it's an integer-like value
                    double numericValue = cell.getNumericCellValue();
                    if (numericValue == Math.floor(numericValue)) {
                        return String.valueOf((long) numericValue);
                    } else {
                        return String.valueOf(numericValue);
                    }
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }
}