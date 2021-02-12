package Utility;

public class Exceldemo {
public static void main(String[] args) {
	String projectpath = System.getProperty("user.dir");
	Excelutility excel = new Excelutility(projectpath+"/excel/data.xlsx","Sheet1");
	
	excel.getRowCount();
	excel.getCellData(1,0);
	
}
	
}
