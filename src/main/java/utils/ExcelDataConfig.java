package utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {

	XSSFWorkbook wbFile;
	XSSFSheet sheetOne;

	public ExcelDataConfig(String excelPath) {
		try {
			File fileSource = new File(excelPath);
			FileInputStream fis = new FileInputStream(fileSource);
			wbFile = new XSSFWorkbook(fis);

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	public String getData ( int sheetIndex , int row, int column) {
		sheetOne = wbFile.getSheetAt(sheetIndex);

		String data = sheetOne.getRow(row).getCell(column).getStringCellValue();

		return data;
	}

	public int getRowCount(int sheetIndex) {
		int row = wbFile.getSheetAt(sheetIndex).getLastRowNum();

		row = row + 1;
		return row;
	}
}
