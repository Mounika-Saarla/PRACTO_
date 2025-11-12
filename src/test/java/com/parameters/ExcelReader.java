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



           /* public static String getCity(String filePath, int sheetIndex, int rowIndex) {
                String city = "";
                try (FileInputStream fis = new FileInputStream(filePath);
                     Workbook workbook = new XSSFWorkbook(fis)) {

                    Sheet sheet = workbook.getSheetAt(sheetIndex);
                    Row row = sheet.getRow(rowIndex);
                    Cell cell = row.getCell(0); // Column A (City)
                    city = cell.getStringCellValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return city;
            }*/
    

        /**
         * Reads a cell value from an Excel file based on sheet, row, and column index.
         *
         * @param filePath   Path to the Excel file
         * @param sheetIndex Index of the sheet (0-based)
         * @param rowIndex   Index of the row (0-based)
         * @param colIndex   Index of the column (0-based)
         * @return Cell value as String
         */
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
    }

    
    
        /*public static List<String> getCities(String filePath) {
            List<String> cities = new ArrayList<>();
            try (FileInputStream fis = new FileInputStream(filePath);
                 Workbook workbook = WorkbookFactory.create(fis)) {
                Sheet sheet = workbook.getSheet("Cities");
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);
                    cities.add(row.getCell(0).getStringCellValue());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return cities;
        }*/
        

   
//}