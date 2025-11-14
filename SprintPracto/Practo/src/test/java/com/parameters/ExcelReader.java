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
}



















