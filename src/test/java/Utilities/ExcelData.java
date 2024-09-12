package Utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.DataProvider;
/*
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; */

import java.io.File;
import java.io.FileInputStream;

public class ExcelData {

    @DataProvider(name = "excelData")
    public static Object[][] readExcel(String filePath,String sheetName) throws Exception {
        FileInputStream file = new FileInputStream(new File(filePath));

        XSSFWorkbook excelWorkbook = new XSSFWorkbook(file);
        XSSFSheet Sheet = excelWorkbook.getSheet(sheetName);

        System.out.println(sheetName);

        XSSFRow row;
        int rows = Sheet.getPhysicalNumberOfRows();
        int columns = Sheet.getRow(0).getPhysicalNumberOfCells();

        Object cellValue[][]=new Object[rows][columns];

        for (int r = 0; r < rows; r++) {
            row = Sheet.getRow(r);
            if (row == null){
                break;
            }else{
                for (int c = 0; c < columns; c++) {
                    DataFormatter dataFormatter = new DataFormatter();
                    cellValue[r][c] = dataFormatter.formatCellValue(Sheet.getRow(r).getCell(c));
                }
            }
        }

        excelWorkbook.close();

        return cellValue;
    }
}
