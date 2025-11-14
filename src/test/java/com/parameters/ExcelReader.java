package com.parameters;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	    public static final int CITY_COLUMN_INDEX = 0; // Assuming city is in first column

	public static final String FILE_PATH = "C:\\Training\\SprintPracto\\Practo\\src\\test\\resources\\Exceldata\\Data.xlsx";
    public static String getCellData(String sheetName, int row, int col) throws Exception {
        FileInputStream fis = new FileInputStream("src/test/resources/Exceldata/Data.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheet(sheetName);
        return sheet.getRow(row).getCell(col).getStringCellValue();
    }

        public static String getCellData(String filePath, int sheetIndex, int rowIndex, int colIndex) {
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
        

        


    
	     public static final int HOSPITAL_COLUMN_INDEX=0;
	public static final String FILE_PATH2 = "C:\\Training\\SprintPracto\\Practo\\src\\test\\resources\\Exceldata\\Data1.xlsx";
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
        
        
