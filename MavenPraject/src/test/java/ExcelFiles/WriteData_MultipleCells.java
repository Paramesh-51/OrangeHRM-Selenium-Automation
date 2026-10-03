package ExcelFiles;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData_MultipleCells {

	public static void main(String[] args) throws IOException {
	
			XSSFWorkbook workbook = new XSSFWorkbook();
			//XSSFSheet sheet1=workbook.getSheetAt(0);
			XSSFSheet sheet1=workbook.createSheet ("FirstSheet");
			
			XSSFRow row1=sheet1.createRow(0);
			
			XSSFCell cell= row1.createCell(0);
			XSSFCell cell2=row1.createCell(1);
			XSSFCell cell3=row1.createCell(2);
			XSSFCell cell4=row1.createCell(3);
			
			cell.setCellValue("One");
			cell2.setCellValue("Two");
			cell3.setCellValue("Three");
			cell4.setCellValue("Four");	
			
			XSSFRow row2 = sheet1.createRow(1);
			XSSFCell cell5 = row2.createCell(0);
			XSSFCell cell6 = row2.createCell(1);
			XSSFCell cell7 = row2.createCell(2);
			XSSFCell cell8 = row2.createCell(3);
			
			cell5.setCellValue("five");
			cell6.setCellValue("six");
			cell7.setCellValue("seven");
			cell8.setCellValue("Eight");
			
			XSSFSheet sheet2 = workbook.createSheet("SecondSheet");
			
			XSSFRow row3 = sheet2.createRow(0);
			XSSFCell cell9 = row3.createCell(0);
			XSSFCell cell10 = row3.createCell(1);
			XSSFCell cell11 = row3.createCell(2);
			
			cell9.setCellValue("nine");
			cell10.setCellValue("Ten");
			cell11.setCellValue("Eleven");
			
            XSSFSheet sheet3 = workbook.createSheet("ThirdSheet");
			
			XSSFRow row4 = sheet3.createRow(0);
			XSSFCell cell12 = row4.createCell(0);
			XSSFCell cell13 = row4.createCell(1);
			XSSFCell cell14 = row4.createCell(2);
			
			cell12.setCellValue   (1);      //("Twelve");    
			cell13.setCellValue   (2);     //("Thirteen");  
			cell14.setCellValue   (3) ;   //("Fourteen");  
			
			
					
			
			
			FileOutputStream fileout=new FileOutputStream("C:\\Users\\ratho\\OneDrive\\Desktop\\ExcelFiles\\WriteData_MultipleCells.xlsx");
			workbook.write(fileout);
			
			System.out.println("Data written successfully");
			workbook.close();
		
	}
	}

	