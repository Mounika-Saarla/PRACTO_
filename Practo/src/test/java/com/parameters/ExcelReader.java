


package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    private static String filePath;

    public ExcelReader(String filePath) {
        this.filePath = filePath;
    }

    public static String getSpecializationFromExcel() throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Sheet1 = index 0
            Row row = sheet.getRow(0);            // Row 1 = index 0
            Cell cell = row.getCell(0);           // Column A = index 0

            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);
        }
    }
}