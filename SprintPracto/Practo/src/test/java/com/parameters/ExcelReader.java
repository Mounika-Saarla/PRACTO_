package com.parameters;
 
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelReader {
	

	public static String[] getRowData(int sheetIndex, int rowIndex) throws IOException {
		FileInputStream fis = new FileInputStream("src/test/resources/Excel/PractoTestSc1.xlsx");
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(sheetIndex);
		Row row = sheet.getRow(rowIndex);
		String[] data = new String[row.getLastCellNum()];
		for (int i = 0; i < row.getLastCellNum(); i++) {
			data[i] = row.getCell(i).getStringCellValue();
		}
		workbook.close();
		return data;
	}

	
	
	
	
	
//	public static String[] getRowData(int sheetNo, int rowNum) throws IOException {
//	    String filePath = "src/test/resources/Excel/PractoTestSc1.xlsx";
//	    FileInputStream file = new FileInputStream(filePath);
//	    Workbook workbook = new XSSFWorkbook(file);
//	    Sheet sheet = workbook.getSheetAt(sheetNo);
//	    DataFormatter formatter = new DataFormatter();
// 
//	    // Get header row to determine column count
//	    Row headerRow = sheet.getRow(0);
//	    int colCount = headerRow.getLastCellNum();
// 
//	    // Read target row
//	    Row row = sheet.getRow(rowNum);
//	    String[] rowData = new String[colCount];
//	    for (int j = 0; j < colCount; j++) {
//	        Cell cell = (row != null) ? row.getCell(j) : null;
//	        rowData[j] = (cell != null) ? formatter.formatCellValue(cell) : "";
//	    }
//	    workbook.close();
//	    file.close();
//	    return rowData;
//	}
	
}



















