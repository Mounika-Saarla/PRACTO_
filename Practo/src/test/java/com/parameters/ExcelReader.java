package com.parameters;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {
    public static Map<String, String> getRowData(String filePath, int rowIndex) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        Row headerRow = sheet.getRow(0);
        Row row = sheet.getRow(rowIndex);

        Map<String, String> dataMap = new HashMap<>();
        for (int j = 0; j < headerRow.getLastCellNum(); j++) {
            String key = headerRow.getCell(j).getStringCellValue();
            String value = row.getCell(j) != null ? row.getCell(j).toString() : "";
            dataMap.put(key, value);
        }

        workbook.close();
        fis.close();
        return dataMap;
    }
}
	
