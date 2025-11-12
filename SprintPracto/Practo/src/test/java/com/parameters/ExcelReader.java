
package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//public class ExcelReader {
//
//    public static String getCellData(String filePath, int sheetIndex, int rowIndex, int colIndex) {
//        String cellValue = "";
//        try (FileInputStream fis = new FileInputStream("src/test/resources/com/Excel/PractoTetSc1.xlsx");
//             Workbook workbook = new XSSFWorkbook(fis)) {
//            Sheet sheet = workbook.getSheetAt(sheetIndex);
//            Row row = sheet.getRow(rowIndex);
//            Cell cell = row.getCell(colIndex);
//            cellValue = cell.getStringCellValue();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return cellValue;
//    }
//}
public class ExcelReader {
    public static String getCellData(String filePath, int sheetIndex, int rowIndex, int colIndex) {
        String cellValue = "";
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            Row row = sheet.getRow(rowIndex);
            Cell cell = row.getCell(colIndex);
            cellValue = cell.getStringCellValue();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cellValue;
    }
}
//public class ExcelReader {
//    public static List<String> getTestNames(String filePath, String sheetName) {
//        List<String> testNames = new ArrayList<>();
//        try (FileInputStream fis = new FileInputStream("src/test/resources/com/Excel/PractoTetSc1.xlsx");
//             Workbook workbook = new XSSFWorkbook(fis)) {
//            Sheet sheet = workbook.getSheet(sheetName);
//            for (Row row : sheet) {
//                Cell cell = row.getCell(0); // Assuming first column has test names
//                if (cell != null) {
//                    testNames.add(cell.getStringCellValue());
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return testNames;
//    }
//}

