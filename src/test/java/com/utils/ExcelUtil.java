package com.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtil {

    private static final String TESTDATA_PATH = "src/test/resources/testdata/";

    /**
     * Reads data from an Excel sheet and returns it as a list of lists.
     * If the sheet name is null or empty, the first sheet in the workbook is used.
     * Each inner list represents a row, and each element in the inner list represents a cell value.
     *
     * @param fileName  the name of the Excel file (located in the testdata directory)
     * @param sheetName the name of the sheet to read (optional, can be null or empty)
     * @return a list of rows, where each row is a list of cell values
     * @throws IOException if an I/O error occurs
     */
    public static List<List<String>> readExcelData(String fileName, String sheetName) throws IOException {
        String filePath = TESTDATA_PATH + fileName;
        List<List<String>> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet;
            if (sheetName == null || sheetName.isEmpty()) {
                sheet = workbook.getSheetAt(0); // Use the first sheet if no sheet name is provided
            } else {
                sheet = workbook.getSheet(sheetName);
                if (sheet == null) {
                    throw new IllegalArgumentException("Sheet with name " + sheetName + " does not exist in " + filePath);
                }
            }

            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                List<String> rowData = new ArrayList<>();

                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    rowData.add(getCellValueAsString(cell));
                }
                data.add(rowData);
            }
        }

        return data;
    }

    /**
     * Converts a cell value to a string.
     *
     * @param cell the cell to convert
     * @return the cell value as a string
     */
    private static String getCellValueAsString(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "";
        }
    }
}
