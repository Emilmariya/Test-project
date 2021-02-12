package Utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutility {
	static String projectpath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	
	public Excelutility(String excelpath,String sheetname) {
		try {
			projectpath = System.getProperty("user.dir");
			 workbook = new XSSFWorkbook(excelpath);
			 sheet = workbook.getSheet(sheetname);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String [] args) {
	getRowCount();
		getCellData(1,0);
	}

	public static void getRowCount() {
		try {
		 
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("No of rows :"+rowCount);
		}catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
	
	public static void getCellData(int rowNum,int colNum ) {
		try {
		 projectpath = System.getProperty("user.dir");
		 workbook = new XSSFWorkbook(projectpath+"/excel/data.xlsx");
		 sheet = workbook.getSheet("Sheet1");
		 
		 String celldata = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		 //String double = sheet.getRow(0).getCell(0).getNumberCellValue();
		 System.out.println(celldata);
		 
		}catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
}
