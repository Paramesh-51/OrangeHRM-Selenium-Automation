package ExcelFiles;
  
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData_SingleCell {

	public static void main(String[] args) throws IOException {

		FileInputStream filein = new FileInputStream("C:\\Users\\ratho\\OneDrive\\Desktop\\ExcelFiles\\WriteData_SingleCell.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(filein);

		XSSFSheet sheet1 = workbook.getSheet("DataSheet");
		XSSFRow row = sheet1.getRow(11);                 
		
		String celldata = row.getCell(11).getStringCellValue(); //  Current Excel file lo L11   getStringCellValue();   two undali
		//double celldata = row.getCell(11).getNumericCellValue();                   //Current Excel file lo L12 ="two"kabatti double tho run cheyyadam 
		                                                                             //possible kaadu.double kavali ante L12 lo numeric value pettali.200.0 
		//int celldata = (int)row.getCell(11).getNumericCellValue();

		System.out.println(celldata);
		workbook.close();
		filein.close();
	}
}