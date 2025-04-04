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

}
