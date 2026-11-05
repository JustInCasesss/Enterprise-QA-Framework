package com.saucedemo.utils;

import org.apache.poi.ss.formula.functions.Count;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    public static Object[][] getTestData(String sheetName) {
        Object[][] data = null;
        try {
            FileInputStream ip = new FileInputStream("src/test/resources/testdata.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(ip);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();
            data = new Object[rowCount][colCount];
            for (int i = 1; i <= rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}