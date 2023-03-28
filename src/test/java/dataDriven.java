import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	public ArrayList<String> getData(String testcasename) throws IOException {

		// TODO Auto-generated method stub
		//XSSFWorkbook method need to pass the arguments as file(excel) location 
		// argument its accept FileInputstream argument and expection to that class
		//pass the filr location as argument into FIS
		FileInputStream fis=new FileInputStream("C:\\Users\\SV58TR744\\Documents\\demodata.xlsx");
		//pass the fis object into workbook constructor method 
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		//before proceed count the number of sheets and store into local integer
	    
		ArrayList<String> tcv = new ArrayList<String>();   // to print the purchase testcase cell value
		
		int sheets = workbook.getNumberOfSheets();
	      for(int i=0; i<sheets; i++) 
	    {
	     if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
	     {
	    	 XSSFSheet sheet = workbook.getSheetAt(i);
	    	 //Identity testcases column by scanning the entire 1st row
	    	 Iterator<Row> rows = sheet.iterator();  // sheet is collection of rows
	    	 
	    	 Row firstrow = rows.next();   // to move the next row  
	    	 
	    	 Iterator<Cell> ce = firstrow.cellIterator(); //  row is collection of `cells
	    	 int k = 0;  // column traves declaring this variable
	    	 int coloumn = 0; // to get the column index  
	    	 while(ce.hasNext())
	    	 {
	    		 Cell value = ce.next();
	    		//
	    		 if(value.getStringCellValue().equalsIgnoreCase("Testcases"))
	         	{
	    			 coloumn = k;
	    			
	    		}
	    	   k++;
	    	 }
	    	 System.out.println(coloumn);
	    	 
	    	 //once coloumn is identified then scan entire Testcases coloumn(index which get) to identify the purchase row.
	    	 
	    	 while(rows.hasNext())
	    	 {
	    		 
	    		 
	    		 Row r = rows.next();
	    		 if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcasename))  // passing the method argument
	    		 {
	    			 Iterator<Cell> cv= r.cellIterator();
	    			 while(cv.hasNext())
	    			 {
	    				Cell c = cv.next();
	    				 // System.out.println(cv.next().getStringCellValue()); // to print by using sop
	    				// put in the Arraylist object and do print 
	    				if(c.getCellType()== CellType.STRING)
	    				{
	    				tcv.add(c.getStringCellValue());
	    				}
	    				 // going forward to customize the code put all these entire code in a method and 
	    				 //access the method in some other class
	    				 
	    				 //if testdata have combination of String and numeric how to access
	    				else
	    				{   
	    					tcv.add(NumberToTextConverter.toText(c.getNumericCellValue()));
	    					
	    				}
	    				 
	    			 }
	    		}
	    	  	 }
	 	 	     }
	    }
	      return tcv;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		
	}

}
