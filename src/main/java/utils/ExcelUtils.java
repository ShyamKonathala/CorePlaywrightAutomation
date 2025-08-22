package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {

	 public static int getRowCount(String filepath, String sheetName) throws IOException {
	        try (FileInputStream fi = new FileInputStream(filepath);
	             XSSFWorkbook wb = new XSSFWorkbook(fi)) {
	            return wb.getSheet(sheetName).getLastRowNum();
	        }
	    }

	    public static int getCellCount(String filepath, String sheetName, int rowNum) throws IOException {
	        try (FileInputStream fi = new FileInputStream(filepath);
	             XSSFWorkbook wb = new XSSFWorkbook(fi)) {
	            return wb.getSheet(sheetName).getRow(rowNum).getLastCellNum();
	        }
	    }

	    public static String getCellData(String filepath, String sheetName, int rowNum, int colNum) throws IOException {
	        try (FileInputStream fi = new FileInputStream(filepath);
	             XSSFWorkbook wb = new XSSFWorkbook(fi)) {

	            XSSFSheet sheet = wb.getSheet(sheetName);
	            if (sheet == null) {
	                System.out.println("Sheet not found: " + sheetName);
	                return "";
	            }

	            XSSFRow row = sheet.getRow(rowNum);
	            if (row == null) {
	                System.out.println("Row is null at index: " + rowNum);
	                return "";
	            }

	            if (row.getCell(colNum) == null) {
	                System.out.println("Cell is null at row: " + rowNum + ", col: " + colNum);
	                return "";
	            }

	            String value = new DataFormatter().formatCellValue(row.getCell(colNum));
	            return value.trim();  // Trim to avoid extra spaces
	        }
	    }
	    
	    public static void setCellData(String filepath, String sheetName, int rowNum, int colNum, String data) throws IOException {
	        FileInputStream fi = new FileInputStream(filepath);
	        XSSFWorkbook wb = new XSSFWorkbook(fi);
	        XSSFSheet sheet = wb.getSheet(sheetName);

	        if (sheet == null) {
	            sheet = wb.createSheet(sheetName);
	        }

	        XSSFRow row = sheet.getRow(rowNum);
	        if (row == null) {
	            row = sheet.createRow(rowNum);
	        }

	        XSSFCell cell = row.getCell(colNum);
	        if (cell == null) {
	            cell = row.createCell(colNum);
	        }

	        cell.setCellValue(data);

	        fi.close();
	        FileOutputStream fo = new FileOutputStream(filepath);
	        wb.write(fo);
	        wb.close();
	        fo.close();
	    }

	    public static void fillGreenColor(String filepath, String sheetName, int rowNum, int colNum) throws IOException {
	        FileInputStream fi = new FileInputStream(filepath);
	        XSSFWorkbook wb = new XSSFWorkbook(fi);
	        XSSFSheet sheet = wb.getSheet(sheetName);

	        if (sheet == null) {
	            sheet = wb.createSheet(sheetName);
	        }

	        XSSFRow row = sheet.getRow(rowNum);
	        if (row == null) {
	            row = sheet.createRow(rowNum);
	        }

	        XSSFCell cell = row.getCell(colNum);
	        if (cell == null) {
	            cell = row.createCell(colNum);
	        }

	        // Create a cell style with green background
	        CellStyle style = wb.createCellStyle();
	        style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
	        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        cell.setCellStyle(style);

	        fi.close();
	        FileOutputStream fo = new FileOutputStream(filepath);
	        wb.write(fo);
	        wb.close();
	        fo.close();
	    }
}
