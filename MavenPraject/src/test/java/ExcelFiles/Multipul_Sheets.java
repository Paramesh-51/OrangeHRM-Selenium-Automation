package ExcelFiles;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Multipul_Sheets {

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet1 = workbook.createSheet("FirstSheet");
		XSSFSheet sheet2 = workbook.createSheet("SecondSheet");
		XSSFSheet sheet3 = workbook.createSheet("ThairdSheet");
		XSSFSheet sheet4 = workbook.createSheet("FourthSheet");
		
		FileOutputStream fileOut = new FileOutputStream("C:\\Users\\ratho\\OneDrive\\Desktop\\ExcelFiles\\multipulsheet.xlsx");
		workbook.write(fileOut);
		
		
		
		System.out.println("Sheet created SuccessFully");

	}

}
