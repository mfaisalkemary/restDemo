package com.spring.rest.restdemo.utils;

import java.io.*;
import org.apache.poi.ss.usermodel.*;
import java.util.Iterator;

import com.opencsv.CSVWriter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToCsv {

	public void convertToCsv(String inputFilePath, String outputFilePath) throws Exception {
		// First we read the Excel file in binary format into FileInputStream
		FileInputStream input_document = new FileInputStream(new File(inputFilePath));
		// Read workbook into HSSFWorkbook
		XSSFWorkbook my_xls_workbook = new XSSFWorkbook(input_document);
		// Read worksheet into HSSFSheet
		XSSFSheet my_worksheet = my_xls_workbook.getSheet("Tests");
		// To iterate over the rows
		Iterator<Row> rowIterator = my_worksheet.iterator();
		// OpenCSV writer object to create CSV file
		FileWriter my_csv = new FileWriter(outputFilePath);
		CSVWriter my_csv_output = new CSVWriter(my_csv);
		// Loop through rows.
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			int i = 0;// String array
			// change this depending on the length of your sheet
			String[] csvdata = new String[5];
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next(); // Fetch CELL
				switch (cell.getCellType()) { // Identify CELL type
				// you need to add more code here based on
				// your requirement / transformations
				case STRING:
					csvdata[i] = cell.getStringCellValue();
					break;
				}

				i = i + 1;
			}
			my_csv_output.writeNext(csvdata);
		}
		my_csv_output.close(); // close the CSV file
		// we created our file..!!
		input_document.close(); // close xls
	}
}
