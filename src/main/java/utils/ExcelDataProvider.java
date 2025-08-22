package utils;


import java.io.IOException;

import org.testng.annotations.DataProvider;
public class ExcelDataProvider {
	@DataProvider(name = "loginData")
	public static Object[][] getData() throws IOException{
		String filepath = ConfigReader.get("excelFilePath");
		
		Object[][] data = new Object[1][4];
		
		data[0][0] = ExcelUtils.getCellData(filepath, "Login", 1, 0);
		data[0][1] = ExcelUtils.getCellData(filepath, "Login", 1, 1);
		data[0][2] = ExcelUtils.getCellData(filepath, "Login", 1, 2);
		data[0][3] = ExcelUtils.getCellData(filepath, "Login", 1, 3);
		
		
		return data;
		
	}
	
	@DataProvider(name = "loginData2")
	public static Object[][] getData6() throws IOException{
		String filepath = ConfigReader.get("excelFilePath");
		
		Object[][] data = new Object[1][10];
		
		data[0][0] = ExcelUtils.getCellData(filepath, "Login", 1, 0);
		data[0][1] = ExcelUtils.getCellData(filepath, "Login", 1, 1);
		data[0][2] = ExcelUtils.getCellData(filepath, "Customers",2,0); // Customers
		data[0][3] = ExcelUtils.getCellData(filepath, "Generators",1,0); //Generators
		data[0][4] = ExcelUtils.getCellData(filepath, "SalesRep",1,0); //Salesrep
		data[0][5] = ExcelUtils.getCellData(filepath, "InsideSalesRep",2,0); //InsideSalesRep
		data[0][6] = ExcelUtils.getCellData(filepath, "CSR",4,0); //CSR
		data[0][7] = ExcelUtils.getCellData(filepath, "Facilities",6,0); //Facilities
		data[0][8] = ExcelUtils.getCellData(filepath, "Container",2,0);//Container Type
		data[0][9] = ExcelUtils.getCellData(filepath, "Container",1,1);//Unit
		return data;
		
	}
	
	@DataProvider(name = "Tanks")
	public static Object[][] getData4() throws IOException{
		String filepath = ConfigReader.get("excelFilePath");
		
		Object[][] data = new Object[1][6];
		
		data[0][0] = ExcelUtils.getCellData(filepath, "Login", 1, 0);
		data[0][1] = ExcelUtils.getCellData(filepath, "Login", 1, 1);
		data[0][2] = ExcelUtils.getCellData(filepath, "TankNumber", 1, 0);//Tank
		
		data[0][3] = ExcelUtils.getCellData(filepath, "TankNumber", 3, 2);//ManifestId
		data[0][4] = ExcelUtils.getCellData(filepath, "TankNumber", 2, 1);//Record
		data[0][5] = ExcelUtils.getCellData(filepath, "TankNumber", 1, 3); //JobId
		
		
		
		System.out.println("Manifest Id : " + ExcelUtils.getCellData(filepath, "TankNumber", 3, 2));
		
		
		
		return data;
		
	}
	
	
	@DataProvider(name = "loginData1")
	public static Object[][] getData1() throws IOException {
	    String filepath = ConfigReader.get("excelFilePath");
	    
	    int rowCount = ExcelUtils.getRowCount(filepath, "Login"); // e.g., returns 3 if 3 data rows
	    int colCount = 4;

	    Object[][] data = new Object[rowCount - 1][colCount]; // Skip header

	    for (int i = 1; i < rowCount; i++) {
	        for (int j = 0; j < colCount; j++) {
	            data[i - 1][j] = ExcelUtils.getCellData(filepath, "Login", i, j);
	        }
	    }
	    return data;
	}
	
	@DataProvider(name = "RecertReport")
	public static Object[][] getData2() throws IOException{
		String filepath = ConfigReader.get("excelFilePath");
		
		Object[][] data = new Object[1][4];
		
		data[0][0] = ExcelUtils.getCellData(filepath, "Login", 1, 0);
		data[0][1] = ExcelUtils.getCellData(filepath, "Login", 1, 1);
		data[0][2] = ExcelUtils.getCellData(filepath, "SalesRep", 1, 0);
		data[0][3] = ExcelUtils.getCellData(filepath, "Customers", 1, 0);
		
		System.out.println("Sales Rep : " + ExcelUtils.getCellData(filepath, "SalesRep", 1, 0));
		
		
		return data;
		
	}
	
	@DataProvider(name = "TonnageReport")
	public static Object[][] getData5() throws IOException{
		String filepath = ConfigReader.get("excelFilePath");
		
		Object[][] data = new Object[1][4];
		
		data[0][0] = ExcelUtils.getCellData(filepath, "Login", 1, 0);
		data[0][1] = ExcelUtils.getCellData(filepath, "Login", 1, 1);
		data[0][2] = ExcelUtils.getCellData(filepath, "Customers", 2, 0);
		data[0][3] = ExcelUtils.getCellData(filepath, "Generators", 1, 0);
		
		//data[0][2] = ExcelUtils.getCellData(filepath, "Facilities", 1, 0);//Facilities
		
		
		return data;
		
	}
	
	
	
	
}
