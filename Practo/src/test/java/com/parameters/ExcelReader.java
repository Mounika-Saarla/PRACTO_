package com.parameters;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {

    private String filePath;

    public ExcelReader(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Reads a row from Excel and returns a Map of column header -> cell value.
     * @param sheetIndex Sheet index (0-based)
     * @param rowIndex Row index (0-based, excluding header)
     * @return Map<String, String> where key = header name, value = cell content
     */
    public Map<String, String> getRowData(int sheetIndex, int rowIndex) {
        Map<String, String> rowData = new HashMap<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(sheetIndex);
            Row headerRow = sheet.getRow(0); // First row is header
            Row dataRow = sheet.getRow(rowIndex);

            if (headerRow == null || dataRow == null) {
                throw new RuntimeException("Header or Data row is missing in Excel!");
            }

            int totalCols = headerRow.getLastCellNum();
            for (int colIndex = 0; colIndex < totalCols; colIndex++) {
                Cell headerCell = headerRow.getCell(colIndex);
                Cell dataCell = dataRow.getCell(colIndex);

                String header = (headerCell != null) ? headerCell.toString().trim() : "Column" + colIndex;
                String value = (dataCell != null) ? dataCell.toString().trim() : "";

                rowData.put(header, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rowData;
    }
}