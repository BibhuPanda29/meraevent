package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static String projectPath ;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath, String sheetName) {
		try {		
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		
	}
	
//	public static void main(String args[]) throws IOException {
//		getData(0,0);
//		getNumericData(1,0);
//		
//		
//	}
	public static String getData(int rownum, int cellnum) throws IOException {
			String Data= null;
		
		try {
			Data = sheet.getRow(rownum).getCell(cellnum).getStringCellValue();
//			System.out.println(Data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		return Data;
	}
	public static double getNumericData(int rownum, int cellnum) throws IOException {
		double Data=0;
	
	try {
		Data = sheet.getRow(rownum).getCell(cellnum).getNumericCellValue();
//		System.out.println(Data);
	} catch (Exception e) {
		System.out.println(e.getMessage());
		System.out.println(e.getCause());
	}
	return Data;
}

	
	

}
