package com.spring.rest.restdemo.utils;

import com.opencsv.CSVWriter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Iterator;

@Component
public class FromExcelToCsv {
	private static  FileInputStream inputStream;
	private static XSSFWorkbook workbook;
	 
	
	
//	@Value("${excelWorkBookPath}")
//	String excelWorkBookPath;



//	public FromExcelToCsv() {
//		try {
//			inputStream = new FileInputStream(excelWorkBookPath);
//			workbook = new XSSFWorkbook(inputStream);
//			convertToCsv();
//			
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//	
	
	
	
	

	public FromExcelToCsv() throws Exception 
	{
		super();
		try {	
			inputStream = new FileInputStream("/resources/ExcelSheetWbook/ControlFile.xlsx");
			workbook = new XSSFWorkbook(inputStream);
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}






	public static FileInputStream getInputStream() {
		return inputStream;
	}






	public static void setInputStream(FileInputStream inputStream) {
		FromExcelToCsv.inputStream = inputStream;
	}






	public static XSSFWorkbook getWorkbook() {
		return workbook;
	}






	public static void setWorkbook(XSSFWorkbook workbook) {
		FromExcelToCsv.workbook = workbook;
	}


	public static int retrieveNoOfCols(String wsName) throws Exception{
		int SheetIndex = workbook.getSheetIndex(wsName);
		if (SheetIndex == -1) {
			return 0;
		} else {
			XSSFSheet sheet = workbook.getSheetAt(SheetIndex);
			int Colnum = sheet.getRow(0).getLastCellNum();
			return Colnum;
		}
	}

	public int retrieveNoOfRows(String wsName)  throws Exception{
		int SheetIndex = workbook.getSheetIndex(wsName);
		if (SheetIndex == -1) {
			return 0;
		} else {
			XSSFSheet sheet = workbook.getSheetAt(SheetIndex);
			int RowCount = sheet.getLastRowNum();
			return RowCount + 1;
		}

	}

	public  void convertToCsv(){
        try {

           // FileInputStream inputStream;
            //inputStream = new FileInputStream(excelPath);
            //workbook = new XSSFWorkbook(inputStream);
            for (int i = 0 ;i< workbook.getNumberOfSheets();i++){
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row>rowIterator=sheet.iterator();
                FileWriter fileWriter = new FileWriter("/Resources/CSVfiles/"+sheet.getSheetName()+".csv");
                CSVWriter csvWriter = new CSVWriter(fileWriter);
                while (rowIterator.hasNext()){
                    Row row = rowIterator.next();
                    int s=0;
                    String [] csvData = new String[retrieveNoOfCols(sheet.getSheetName())];

                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()){
                        Cell cell = cellIterator.next();

                        switch (cell.getCellType()){
                            case STRING:
                                csvData[s]= cell.getStringCellValue();
                                break;

                            case NUMERIC:
                                   // csvData[s]= Double.toString(cell.getNumericCellValue());
                                csvData[s]=Integer.toString((int) cell.getNumericCellValue());
                                    break;

                        }

                        s=s+1;
                    }
                    csvWriter.writeNext(csvData);
                }
                csvWriter.close();
                inputStream.close();
            }
            System.out.printf("Sheets were converted successfully");


                //System.out.println(workbook.getNumberOfSheets());
//            for (int w=0;w<workbook.getNumberOfSheets();w++){
//                System.out.println(workbook.getSheetAt(w).getSheetName());
//
        } catch (Exception e){
            e.printStackTrace();

        }
        
	}
}
    
    

