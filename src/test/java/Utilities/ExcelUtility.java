package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
public FileInputStream fi;
public FileOutputStream fo;
public XSSFWorkbook wb;
public XSSFSheet ws;
public XSSFRow row;
public XSSFCell cell;
public CellStyle style;
String path;
//public ExcelUtility(String path) {
//	this.path=path;
//}
public int getRowCount(String xlfile,String sheetname) throws IOException { 
//  fi=new FileInputStream(path);
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);	
	ws=wb.getSheet(sheetname);
	int rowcount=ws.getLastRowNum();
	wb.close();
	fi.close();
	
	return rowcount;
}
public int getCellcount(String xlfile,String sheetname, int rownum) throws IOException {
	//fi=new FileInputStream(path);
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(sheetname);
	row=ws.getRow(rownum);
	int cellcount=row.getLastCellNum();
	fi.close();
	wb.close();
	
	return cellcount;
}
public String getCellData(String xlfile, String sheetname,int rownum, int colnum) throws IOException {
	//fi=new FileInputStream(path);   //column=cell in excel
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(sheetname);
	row=ws.getRow(rownum); 
	cell=row.getCell(colnum);  
	String data;
	try {
		//data=cell.toString(); //use this or DataFormatter object to extract data from excel sheet
		DataFormatter formatter=new DataFormatter(); 
		data=formatter.formatCellValue(cell);
	}catch(Exception e){
		data="";
	}
	 fi.close();
	 wb.close();
	return data;
}
public void setCellData(String xlfile, String sheetname, int rownum, int clonum, String data) throws IOException {
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(sheetname);
	row=ws.getRow(rownum);
	cell=row.getCell(clonum);
	cell.setCellValue(data);
	fo=new FileOutputStream(xlfile);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();
	

	
}
}