package com.Ecommerce.genericLibrary;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String readDataFromExcel(String excelPath, String sheetNAme, int rowNo, int cellNo)
			throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(excelPath);
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet(sheetNAme);
		return sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
	}
	
	public static Object[][] readMultipleData(String excelPath, String sheetNAme) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream(excelPath);
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet(sheetNAme);
		int row = sheet.getPhysicalNumberOfRows();
		int cell = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] data = new Object[row-1][cell];
		
		for(int i=1;i<row;i++)
		{
			for(int j=0;j<cell;j++)
			{
				data[i-1][j] =sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	}

}
