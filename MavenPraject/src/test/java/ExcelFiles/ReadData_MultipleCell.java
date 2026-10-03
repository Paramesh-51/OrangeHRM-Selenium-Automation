package ExcelFiles;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadData_MultipleCell {

	public static void main(String[] args) throws IOException {
		FileInputStream filein = new FileInputStream("C:\\Users\\ratho\\OneDrive\\Desktop\\ExcelFiles\\WriteData_MultipleCells.xlsx");


		XSSFWorkbook workbook = new XSSFWorkbook(filein);
		XSSFSheet sheet1=workbook.getSheetAt(0);
		
		for(int r=0;r<=sheet1.getLastRowNum();r++) 
		//for(int r=0;r<=2;r++)
		{
			XSSFRow row=sheet1.getRow(r);
			
			for(int c=0;c<=row.getLastCellNum()-1;c++)
			{
				String celldata=row.getCell(c).getStringCellValue();
				System.out.print(celldata+" ");
			}
			System.out.println();
			workbook.close();
		}
			
			
		}

	}
