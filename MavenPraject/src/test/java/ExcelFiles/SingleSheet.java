package ExcelFiles;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SingleSheet {

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet1 = workbook.createSheet("FirstSheet");
		FileOutputStream fileout = new FileOutputStream("C:/Users/ratho/OneDrive/Desktop/ExcelFiles/SingleSheet.xlsx");
		workbook.write(fileout);
				
				System.out.println("Sheet Created SuccessFull");
		
	}

}