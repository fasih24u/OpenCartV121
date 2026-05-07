package TestCases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadingExcelsheet {
 @Test
	public static void main(String[] args) throws IOException {
	FileInputStream file=new FileInputStream("C:\\Users\\fasih\\eclipse-workspace\\OpencartV121\\testData\\TestDataLogin.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(file);
     XSSFSheet sheet=wb.getSheet("Sheet1");
     int totalrows=sheet.getLastRowNum();
     int totalcells=sheet.getRow(1).getLastCellNum();
     System.out.println(totalrows);
     System.out.println(totalcells);
     
     for(int i=0;i<=totalrows;i++) {
    	 XSSFRow row=sheet.getRow(i);
    	 for(int j=0;j<totalcells;j++) {
    		  XSSFCell cell=row.getCell(j);
    		  System.out.print(cell.toString()+"                 \t");
    	 }
    	System.out.println();
     }
     wb.close();
	 file.close();
	}

}
