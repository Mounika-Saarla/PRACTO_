package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	//---------------------scenario 1 (outline1)-------------
	
	public static String getCellData(int sheetIndex, int rowIndex, int colIndex) throws Exception {
	    String filePath = System.getProperty("user.dir") + "/src/test/resources/TestData/Practo_Automation.xlsx";
	    FileInputStream fis = new FileInputStream(filePath);
	    Workbook workbook = new XSSFWorkbook(fis);
	    Sheet sheet = workbook.getSheetAt(sheetIndex);
	    Row row = sheet.getRow(rowIndex); // No +1
	    if (row == null) {
	        throw new RuntimeException("Row " + rowIndex + " does not exist in sheet " + sheetIndex +
	                                   ". Available rows: 0 to " + sheet.getLastRowNum());
	    }

	    Cell cell = row.getCell(colIndex);
	    workbook.close();
	    return cell.getStringCellValue();
	}

	//---------------------scenario 5 (outline2)-------------
//	public String getCellData1(int sheetIndex, int rowIndex, int colIndex) throws Exception {
//	    String filePath = System.getProperty("user.dir") + "/src/test/resources/TestData/outline2.xlsx";
//	    FileInputStream fis = new FileInputStream(filePath);
//	    Workbook workbook = new XSSFWorkbook(fis);
//	    Sheet sheet = workbook.getSheetAt(sheetIndex);
//	    Row row = sheet.getRow(rowIndex); // No +1
//	    if (row == null) {
//	        throw new RuntimeException("Row " + rowIndex + " does not exist in sheet " + sheetIndex +
//	                                   ". Available rows: 0 to " + sheet.getLastRowNum());
//	    }
//
//	    Cell cell = row.getCell(colIndex);
//	    workbook.close();
//	    return cell.getStringCellValue();
//	}
	public String getCellData1(int sheetIndex, int rowIndex, int colIndex) throws Exception {
	    String filePath = System.getProperty("user.dir") + "/src/test/resources/TestData/outline2.xlsx";

	    try (FileInputStream fis = new FileInputStream(filePath);
	         Workbook workbook = new XSSFWorkbook(fis)) {

	        Sheet sheet = workbook.getSheetAt(sheetIndex);

	        // Skip header row by adding +1
	        Row row = sheet.getRow(rowIndex + 1);
	        if (row == null) {
	            throw new RuntimeException("Row " + (rowIndex + 1) + " does not exist in sheet " + sheetIndex +
	                                       ". Available rows: 0 to " + sheet.getLastRowNum());
	        }

	        Cell cell = row.getCell(colIndex);
	        if (cell == null) return "";

	        // Use DataFormatter to handle all cell types
	        DataFormatter formatter = new DataFormatter();
	        return formatter.formatCellValue(cell).trim();
	    }
	}
	
	
	
	  public static final int HOSPITAL_COLUMN_INDEX=0;
		public static final String FILE_PATH2 = "C:\\Training\\SprintPracto\\Practo\\src\\test\\resources\\TestData\\outline2.xlsx";
	        public static String getCellDatas(String filePath, int sheetIndex, int rowIndex, int colIndex) {
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
	 

}