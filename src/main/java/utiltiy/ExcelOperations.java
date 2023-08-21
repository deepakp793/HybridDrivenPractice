package utiltiy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {

	public static Object[][] readExcelData(String filePath, String sheetName) throws IOException {

		File file = new File(filePath);
		FileInputStream input = new FileInputStream(file);

		Workbook wb = new XSSFWorkbook(input);
		Sheet sheet = wb.getSheet(sheetName);

		int totalRows = sheet.getLastRowNum();
		int totalColumn = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[totalRows][totalColumn];
		Row row;
		for (int rowIndex = 0; rowIndex < totalRows; rowIndex++) {
			row = sheet.getRow(rowIndex + 1);
			for (int colIndex = 0; colIndex < totalColumn; colIndex++) {
				Cell cell = row.getCell(colIndex);
				if (cell.getCellType() == CellType.STRING) {
					data[rowIndex][colIndex] = cell.getStringCellValue();
				} else if (cell.getCellType() == CellType.BOOLEAN)
					data[rowIndex][colIndex] = cell.getBooleanCellValue();
			}
		}

		return data;

	}

}
