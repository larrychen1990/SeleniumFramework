package com.BISPL.libraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.IllegalFormatException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {

	/**
	 * @param args
	 */	
	public String getExcelData(String sheetName, int rowNum, int cellNum){
		String retVal=null;
		try {
			//Get the excel file as an object of FIS
			FileInputStream fis = new FileInputStream("D:/SeAutomation/hybridframework/data/data.xls");
			//Get the workbook object from the FIS using create() method
			//of WorkbookFactory
			Workbook wb = WorkbookFactory.create(fis);
			//Get a particular sheet from the workbook [Sheet Name is case
			//sensitive]
			Sheet s = wb.getSheet(sheetName);
			//Get a particular row from the sheet [Row is zero based index]
			Row r =s.getRow(rowNum);
			//Get a particular cell from the row [Cell is zero based index]
			Cell c = r.getCell(cellNum);
			//Get the string value from the cell
			retVal = c.getStringCellValue();			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	public int getRowCount(String sheetName){
		int rowCount=0;
		try {
			//Get the excel file as an object of FIS
			FileInputStream fis = new FileInputStream("D:/SeAutomation/hybridframework/data/data.xls");
			//Get the workbook object from the FIS using create() method
			//of WorkbookFactory
			Workbook wb = WorkbookFactory.create(fis);
			//Get a particular sheet from the workbook [Sheet Name is case
			//sensitive]
			Sheet s = wb.getSheet(sheetName);
			//Get last row number for the sheet = number of rows
			//in that sheet
			rowCount = s.getLastRowNum();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowCount;
	}
}




