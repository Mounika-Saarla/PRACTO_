package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public String getCellData(int sheetIndex, int rowIndex, int colIndex) throws Exception {
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

	//-----------------------------------------scenario 3




	public static String getCellDataByColumnName(String sheetName, int rowIndex, String columnName) throws IOException {
		String excelPath = PropertyReader.getProperty("excelFilePath");
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook workbook = new XSSFWorkbook(fis);

		System.out.println("Available sheets in Excel:");
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			System.out.println(" - " + workbook.getSheetName(i));
		}

		Sheet sheet = workbook.getSheet(sheetName);

		if (sheet == null) {
			//   workbook.close();
			throw new RuntimeException("Sheet '" + sheetName + "' not found in Excel file.");
		}

		// Find column index by header name
		Row headerRow = sheet.getRow(0);
		int colIndex = -1;
		for (int i = 0; i < headerRow.getLastCellNum(); i++) {
			Cell headerCell = headerRow.getCell(i);
			if (headerCell != null && headerCell.getStringCellValue().equalsIgnoreCase(columnName)) {
				colIndex = i;
				break;
			}
		}

		if (colIndex == -1) {
			workbook.close();
			throw new RuntimeException("Column '" + columnName + "' not found in sheet '" + sheetName + "'");
		}

		Row dataRow = sheet.getRow(rowIndex);
		if (dataRow == null) {
			workbook.close();
			throw new RuntimeException("Row " + rowIndex + " not found in sheet '" + sheetName + "'");
		}

		Cell cell = dataRow.getCell(colIndex);
		if (cell == null) {
			workbook.close();
			throw new RuntimeException("Cell [" + rowIndex + "," + colIndex + "] not found in sheet '" + sheetName + "'");
		}

		String value;
		if (cell.getCellType() == CellType.NUMERIC) {
			value = String.valueOf((int) cell.getNumericCellValue());
		} else {
			value = cell.getStringCellValue();
		}

		workbook.close();
		return value;
	}

	//public String getLocation(int row) throws Exception {
	//    return getCellData(row, 0); // Column 0 for city
	//}

	//public String getRole(int row) throws Exception {
	//    return getCellData(row, 1); // Column 1 for Role
	//}


}