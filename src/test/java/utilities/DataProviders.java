package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException {
		
		
		String path =".\\testData\\Opencart_Login_Data.xlsx";     //taking XL file from testData
		
		ExcelUtility xlutil = new ExcelUtility(path);          //Creating an Object for XLUtility
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1", 1);
		
		
		String logindata[][]= new String[totalrows][totalcols]; //created for 2 dimension array
		
		for(int i=0;i<=totalrows;i++) {        //1 read the data from XL storing in 2 dimensional array
			for(int j=0;j<=totalcols;j++) {    // 0 i is rows and j is Columns in 2 dimensional array
				
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
		}
		
		return logindata;   //returning 2 dimension array
		
		
		//Data Provider 2
		
		//Data Provider 3
		
		//Data Provider 4
		

		
		
	}

}
