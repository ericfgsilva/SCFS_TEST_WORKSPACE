package util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	private static String path;

	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

	public static void setExcelFile(String Path, String SheetName) throws Exception {

		try {
			path = Path;
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e){

			throw (e);
		}

	}

	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

	public static String getCellData(int RowNum, int ColNum) throws Exception{

		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		String CellData = Cell.getStringCellValue();
		return CellData;
	}

	//This method is to write in the Excel cell, Row num and Col num are the parameters

	public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception    {

		try{

			Row  = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}

			// Constant variables Test Data path and Test Data file name

			FileOutputStream fileOut = new FileOutputStream(path);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		}catch(Exception e){

			throw (e);
		}

	}

	public static int getRowUsed(){

		return ExcelWSheet.getLastRowNum();
	}

}