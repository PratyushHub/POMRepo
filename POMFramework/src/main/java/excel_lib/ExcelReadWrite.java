package excel_lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadWrite {
	
	FileInputStream fis;
	XSSFWorkbook wb;
	
	//constructor recieve the Excel path
	public ExcelReadWrite(String xlPath) throws IOException
	{
		 fis= new FileInputStream(xlPath);
		
		//workbook object
		 wb= new XSSFWorkbook(fis);
		
	}
	
	//Set the Sheet
		public XSSFSheet Setsheet(String sheetname)
		{
			XSSFSheet Sheet = wb.getSheet(sheetname);
			return Sheet;
			
		}
		
		//Get the row Count
		public int getrowcount(XSSFSheet Sheet)
		{
			int lastRowNum = Sheet.getLastRowNum();
			return lastRowNum;
			
		}
		
		//Get the Col count
		public int getcolcount(XSSFSheet Sheet,int rowIndex)
		{
			int lastcolnum  = Sheet.getRow(rowIndex).getLastCellNum();
			return lastcolnum;
			
		}
		
		//Read the value-- method overloading using cell num
	public String Readvalue(XSSFSheet Sheet,int rowIndex, int cellnum)
		{
			XSSFCell cell = Sheet.getRow(rowIndex).getCell(cellnum);
			
			String celltext=null;
			
			if(cell==null)
			celltext="";
			
			else if(cell.getCellType()==cell.CELL_TYPE_STRING)
			celltext=cell.getStringCellValue();
			
			else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
			celltext=String.valueOf(cell.getNumericCellValue());
			
			else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
			celltext="";
			
			return celltext;
		}
	//Read the value-- method overloading using colname
		public String Readvalue(XSSFSheet Sheet,int rowIndex, String colname){
			
			int colindex = 0;
			for(int i=0;i<getcolcount(Sheet,0);i++){
				
				
				//System.out.println(row.getCell(i).getStringCellValue().trim());
				if(Sheet.getRow(0).getCell(i).getStringCellValue().trim().equalsIgnoreCase(colname))
					colindex=i;
			}
			

			
			return Readvalue(Sheet,rowIndex, colindex);
			
			
		}
		
		//write the value-- method overloading using cellnum
		public void writecell(XSSFSheet Sheet,int rowIndex,int cellnum, String wvalue )
		{
			//writing the cell
			XSSFCell writecell = Sheet.getRow(rowIndex).getCell(cellnum);
			if(writecell==null)
			{
				writecell=Sheet.getRow(rowIndex).createCell(cellnum);
			}
			
			writecell.setCellValue(wvalue);
		}
		
		//write the value-- method overloading using colname
		public void writecell(XSSFSheet Sheet,int rowIndex,String colname, String wvalue ){
			int colindex = 0;
			for(int i=0;i<getcolcount(Sheet,0);i++){
								
				//System.out.println(row.getCell(i).getStringCellValue().trim());
				if(Sheet.getRow(0).getCell(i).getStringCellValue().trim().equalsIgnoreCase(colname))
					colindex=i;
			}
			

			writecell(Sheet,rowIndex,colindex, wvalue );
			
			
			
			
		}
		
		//Save the Excel
		public void save_excel(String xlPath) throws IOException
		{
			fis.close();
			FileOutputStream fos= new FileOutputStream(xlPath);		
			wb.write(fos);
			fos.close();
			
		}
	

}
