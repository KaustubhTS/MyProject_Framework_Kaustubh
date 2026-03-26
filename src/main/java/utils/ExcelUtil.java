package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	
	public void readDataFromExcelOnly1Sheet() throws IOException {
		// Read the data from the excel
		FileInputStream file = new FileInputStream("src/test/resources/testdata/TestData.xlsx");

		// Excel workbook
	Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("Sheet1");

		int totalRows = sheet.getLastRowNum(); // 0-based
		int totalCells = sheet.getRow(0).getLastCellNum(); // 1-based count

		System.out.println("Total Rows: " + (totalRows + 1));
		System.out.println("Total cells: " + totalCells);

		DataFormatter formatter = new DataFormatter();

		for (int r = 0; r <= totalRows; r++) {
		Row currentRow = sheet.getRow(r);
			for (int c = 0; c < totalCells; c++) {
				String value = "";
				if (currentRow != null && currentRow.getCell(c) != null) {
					value = formatter.formatCellValue(currentRow.getCell(c));
				}
				System.out.print(value + "  \t");
			}
			System.out.println();
		}

		workbook.close();
		file.close();
	}

	
	
	
	public void readDataFromExcelMultipleSheets() throws IOException {

		FileInputStream file = new FileInputStream("src/test/resources/testdata/TestData.xlsx");

		Workbook workbook = WorkbookFactory.create(file);
		DataFormatter formatter = new DataFormatter();

		int totalSheets = workbook.getNumberOfSheets();

		for (int s = 0; s < totalSheets; s++) {

			Sheet sheet = workbook.getSheetAt(s);

			System.out.println("\n===============================");
			System.out.println("Sheet: " + sheet.getSheetName());
			System.out.println("===============================");

			int totalRows = sheet.getLastRowNum();
			int totalCells = sheet.getRow(0).getLastCellNum();

			// Print Header Line
			for (int c = 0; c < totalCells; c++) {
				System.out.printf("%-20s", "Column" + (c + 1));
			}
			System.out.println();

			System.out.println("------------------------------------------------------------");

			// Print Data
			for (int r = 0; r <= totalRows; r++) {
			Row row = sheet.getRow(r);

				for (int c = 0; c < totalCells; c++) {
					String value = "";

					if (row != null && row.getCell(c) != null) {
						value = formatter.formatCellValue(row.getCell(c));
					}

					System.out.printf("%-20s", value); // left aligned with fixed width
				}
				System.out.println();
			}
		}

		workbook.close();
		file.close();
	}

	
	
	public void readDataFromSpecificRowandColumn(String sheetName, int row, int col) throws IOException {
		// Read the data from the excel
		FileInputStream file = new FileInputStream("src/test/resources/testdata/TestData.xlsx");

		// Excel workbook
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetName);

		int totalRows = sheet.getLastRowNum(); // 0-based
		int totalCells = sheet.getRow(0).getLastCellNum(); // 1-based count

		System.out.println("Total Rows: " + (totalRows + 1));
		System.out.println("Total cells: " + totalCells);

		DataFormatter formatter = new DataFormatter();

		Row currentRow = sheet.getRow(row);
		String value = "";
		if (currentRow != null && currentRow.getCell(col) != null) {
			value = formatter.formatCellValue(currentRow.getCell(col));
		}
		System.out.println("Value at Row " + row + ", Column " + col + ": " + value);

		workbook.close();
		file.close();
	}

}
