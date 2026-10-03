package ExcelFiles;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData_SingleCell {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		//XSSFSheet sheet1=workbook.getSheetAt(0);
		XSSFSheet sheet1=workbook.createSheet("DataSheet");
		XSSFRow row=sheet1.createRow(11);
		XSSFCell cell=row.createCell(11);
		cell.setCellValue("two");
		
		FileOutputStream fileout=new FileOutputStream("C:\\Users\\ratho\\OneDrive\\Desktop\\ExcelFiles\\WriteData_SingleCell.xlsx");
		workbook.write(fileout);
		
		System.out.println("Data written successfully");
		workbook.close();
	}

}
