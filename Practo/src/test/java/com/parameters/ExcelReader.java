package com.parameters;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {

    private String filePath;

    public ExcelReader(String filePath) {
        this.filePath = filePath;
    }


//    public Map<String, String> getRowData(int sheetIndex, int rowIndex) {
//        Map<String, String> rowData = new HashMap<>();
//        try (FileInputStream fis = new FileInputStream(filePath);
//             Workbook workbook = new XSSFWorkbook(fis)) {
//
//            Sheet sheet = workbook.getSheetAt(sheetIndex);
//            Row headerRow = sheet.getRow(0); // First row is header
//            Row dataRow = sheet.getRow(rowIndex);
//
//            if (headerRow != null && dataRow != null) {
//                int lastCellNum = headerRow.getLastCellNum();
//                for (int i = 0; i < lastCellNum; i++) {
//                    String header = headerRow.getCell(i) != null ? headerRow.getCell(i).toString().trim() : "";
//                    String value = dataRow.getCell(i) != null ? dataRow.getCell(i).toString().trim() : "";
//                    if (!header.isEmpty()) {
//                        rowData.put(header, value);
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return rowData;
//    }
//
//    /**
//     * Get data from a specific cell
//     * @param sheetIndex Sheet index (0-based)
//     * @param rowIndex Row index (0-based)
//     * @param colIndex Column index (0-based)
//     * @return Cell value as String or null if empty
//     */
//    public String getCellData(int sheetIndex, int rowIndex, int colIndex) {
//        String cellValue = null;
//        try (FileInputStream fis = new FileInputStream(filePath);
//             Workbook workbook = new XSSFWorkbook(fis)) {
//
//            Sheet sheet = workbook.getSheetAt(sheetIndex);
//            Row row = sheet.getRow(rowIndex);
//
//            if (row != null) {
//                Cell cell = row.getCell(colIndex);
//                if (cell != null) {
//                    cellValue = cell.toString().trim();
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return cellValue;
//    }
    
//    
//    public static final int SEARCH_COLUMN_INDEX=0;
//    public static String excelpath="C:\\Users\\dyamaa\\SpritPracto\\Practo\\src\\test\\resources\\Excel\\Scenarioout3.xlsx";
//    public static String getLocalityByRow(String excelPath, int sheetIndex, int rowIndex) throws Exception {
////      String filePath = System.getProperty("C:\\Users\\alluri\\eclipse-workspace\\BestBuy\\src\\test\\resources\\com\\Excel\\TestData.xlsx");
////      String filePath ="C:\\Users\\dyamaa\\SpritPracto\\Practo\\src\\test\\resources\\Excel\\Scenarioout2.xlsx";
////  	  FileInputStream fis = new FileInputStream(filePath);
////      Workbook workbook = new XSSFWorkbook(fis);
////      Sheet sheet = workbook.getSheetAt(i);
////      Row row = sheet.getRow(int2); // No +1
////      if (row == null) {
////          throw new RuntimeException("Row " + int2 + " does not exist in sheet " + i + ". Available rows: 0 to " + sheet.getLastRowNum());
////      }
//
//    	 FileInputStream fis = new FileInputStream(excelPath);
//    	    Workbook workbook = new XSSFWorkbook(fis);
//    	    Sheet sheet = workbook.getSheetAt(sheetIndex);
//    	    Row row = sheet.getRow(rowIndex);
//    	    if (row == null) {
//    	        throw new RuntimeException("Row " + rowIndex + " does not exist in sheet " + sheetIndex);
//    	    }
//
//   
//      Cell cell = row.getCell(0);
//      workbook.close();
//      return cell.getStringCellValue();
//	}
//  }
    
    public static String getLocalityByRow(String excelPath, int sheetIndex, int rowIndex) throws Exception {
        FileInputStream fis = new FileInputStream(excelPath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        Row row = sheet.getRow(rowIndex);
        if (row == null) {
            throw new RuntimeException("Row " + rowIndex + " does not exist in sheet " + sheetIndex);
        }

        Cell cell = row.getCell(0);
        workbook.close();

        return cell.getStringCellValue().trim(); // ✅ Trim spaces
    }

}



//scenario outline 2
