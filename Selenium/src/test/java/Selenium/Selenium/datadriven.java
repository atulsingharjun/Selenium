package Selenium.Selenium;

import java.io.*;
import org.apache.poi.xssf.usermodel.*;

public class datadriven {

    public static void main(String[] args) throws IOException {
        XSSFWorkbook ExcelWBook = null;
        XSSFSheet ExcelWsheet;
        XSSFRow Row;
        XSSFCell Cell;

        // File object for the Excel file
        File excelFile = new File("C:\\Users\\dell\\Desktop\\TestDataFile.xlsx");
        FileInputStream input = null;

        // Initialize input stream with try-catch block
        try {
            input = new FileInputStream(excelFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Create XSSFWorkbook object to handle XLSX file
        ExcelWBook = new XSSFWorkbook(input);
        ExcelWsheet = ExcelWBook.getSheetAt(0);

        // Get total number of rows and cells
        int ttlrow = ExcelWsheet.getLastRowNum() + 1;
        int ttlcell = ExcelWsheet.getRow(0).getLastCellNum();

        // Loop through each row and cell, and print data
        for (int currentRow = 0; currentRow < ttlrow; currentRow++) {
            for (int currentCell = 0; currentCell < ttlcell; currentCell++) {
                if (ExcelWsheet.getRow(currentRow) != null && ExcelWsheet.getRow(currentRow).getCell(currentCell) != null) {
                    System.out.print(ExcelWsheet.getRow(currentRow).getCell(currentCell).toString() + "\t");
                } else {
                    System.out.print("\t"); // Handle null cells
                }
            }
            System.out.println();
        }

        // Close the input stream and workbook
        input.close();
        ExcelWBook.close();
    }
}
