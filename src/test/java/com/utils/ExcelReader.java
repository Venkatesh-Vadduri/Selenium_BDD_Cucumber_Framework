package com.utils;

import com.base.BaseClass;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    private FileInputStream fis;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private XSSFRow headerRow;
    private int rowcount;
    private XSSFRow row;
    private int colNum;
    private XSSFCell cell;
    private List<String> columndata;


    public ExcelReader() throws IOException {
        try {
            this.fis = new FileInputStream(BaseClass.prop.getProperty("testdata"));
            workbook = new XSSFWorkbook(fis);
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<String> getExcelData(String sheetName, String columnName) {
        columndata = new ArrayList<String>();
        sheet = workbook.getSheet(sheetName);
        headerRow = sheet.getRow(0);
        rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        for (int j=1;j<=rowcount;j++) {
            row = sheet.getRow(j);
            for (int i=0;i<row.getLastCellNum();i++) {
                if (headerRow.getCell(i).getStringCellValue().trim().equalsIgnoreCase(columnName.trim())) {
                    colNum = i;
                }
                cell = row.getCell(colNum);
                String value = cell.getStringCellValue();
                System.out.println(value);
                columndata.add(value);
            }
        }

        return columndata;
    }

}
