package testcodes;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




public class Exexutescodes {
	static Keyword k;
	
	
   @Test
	public void contact_creation_test() throws IOException {
		 k=new Keyword();
		 ArrayList<Comparable> a=new ArrayList<>();
		FileInputStream f=new FileInputStream("C:\\Users\\zahid\\Downloads\\LeadSuite.xlsx");
		XSSFWorkbook w=new XSSFWorkbook(f);
		XSSFSheet s= w.getSheet("TestSteps");
		Iterator<Row> it= s.iterator();
		while(it.hasNext()) {
			Row rt=(Row)it.next();
			Iterator<Cell> ct=rt.cellIterator();
			while(ct.hasNext()) {
				Cell cd=(Cell)ct.next();
				switch (cd.getCellType()) {
				case NUMERIC:
					a.add(cd.getNumericCellValue());
					break;
				case BOOLEAN:
					a.add(cd.getBooleanCellValue());
					break;
				case STRING:
					a.add(cd.getStringCellValue());
					
				}
			}
		}
		
		
		for(int i=0;i<a.size();i++) {
			
	
			if(a.get(i).equals("openbrowser")) {
				String Keyword=(String) a.get(i);
				String data=(String) a.get(i+1);
				String ObjectName=(String) a.get(i+2);
				String runmode=(String) a.get(i+3);

				if(runmode.equals("no")) {
					k.openbrowser();
					

				}
			
			}

			if(a.get(i).equals("navigate")) {
				String Keyword=(String) a.get(i);
				String data=(String) a.get(i+1);
				String ObjectName=(String) a.get(i+2);
				String runmode=(String) a.get(i+3);
//				System.out.println(data);
//				System.out.println(Keyword);
//				System.out.println(ObjectName);
				if(runmode.equals("yes")) {
					k.navigate(data);
					

				}
	
			}
			if(a.get(i).equals("input")) {
				String Keyword=(String) a.get(i);
				String data=(String) a.get(i+1).toString();
				
				String ObjectName=(String) a.get(i+2);
				String runmode=(String) a.get(i+3);
//				System.out.println(ObjectName);
//				System.out.println(data);
			
				if(runmode.equals("yes")) {
					k.input(data, ObjectName);
			
				}
				
				
				
			}
			if(a.get(i).equals("click")){
				String keyword = (String) a.get(i);
				String data = (String) a.get(i+1);
				String objectName = (String) a.get(i+2);
				String runmode = (String) a.get(i+3);
//				System.out.println(keyword);
//				System.out.println(data);
//				
//				System.out.println(runmode);
				
				if(runmode.equals("yes")) {
					k.click(objectName);
					
			
				}
		}
			if(a.get(i).equals("dropdown")) {
				String Keyword=(String) a.get(i);
				String data=(String) a.get(i+1);
				String ObjectName=(String) a.get(i+2);
				String runmode=(String) a.get(i+3);
//				System.out.println(data);
//				System.out.println(Keyword);
//				System.out.println(ObjectName);
        			if(runmode.equals("yes")) {
					k.dropdown(ObjectName, data);
					

				}
	}
			if(a.get(i).equals("verify")) {
				String Keyword=(String) a.get(i);
				String data=(String) a.get(i+1);
				String ObjectName=(String) a.get(i+2);
				String runmode=(String) a.get(i+3);
//				System.out.println(data);
//				System.out.println(Keyword);
//				System.out.println(ObjectName);
        			if(runmode.equals("yes")) {
					String actual=k.verify();
					Assert.assertEquals(actual, data);
					

				}
	}
           
       
			
		
	}
		
}
   @AfterTest
   public void close() {
	   k.close();
   }
}
