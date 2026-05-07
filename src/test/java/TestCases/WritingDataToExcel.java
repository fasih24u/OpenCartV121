package TestCases;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataToExcel {

	public static void main(String[] args) throws IOException {
		FileOutputStream file=new FileOutputStream("C:\\Users\\fasih\\eclipse-workspace\\OpencartV121\\testData\\MYfile.xlsx");
	    XSSFWorkbook workbook=new XSSFWorkbook();
	    XSSFSheet sheet=workbook.createSheet("MData");
	    XSSFRow row1=sheet.createRow(0);
	    row1.createCell(0).setCellValue("java");
	    row1.createCell(1).setCellValue("19");
	    row1.createCell(2).setCellValue("fasih");
	    XSSFRow row2=sheet.createRow(1);
	    row2.createCell(0).setCellValue("c++");
	    row2.createCell(1).setCellValue("15");
	    row2.createCell(2).setCellValue("uddin");
	    XSSFRow row3=sheet.createRow(2);
	    row3.createCell(0).setCellValue("python");
	    row3.createCell(1).setCellValue("123");
	    row3.createCell(2).setCellValue("dia");
	    workbook.write(file);
	    workbook.close();
	    file.close();
	    System.out.println("file is created......");
	    
	
	}
	
public void fillColor() {
	
}
}
