package utils;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
public class ExcelDataProvider {
	@DataProvider(name = "loginData")
	public static Object[][] getData() throws IOException{
		String filepath = ConfigReader.get("excelFilePath");
		
		Object[][] data = new Object[1][4];
		
		data[0][0] = ExcelUtils.getCellData(filepath, "Login", 5, 0);
		data[0][1] = ExcelUtils.getCellData(filepath, "Login", 1, 1);
		data[0][2] = ExcelUtils.getCellData(filepath, "Login", 1, 2);
		data[0][3] = ExcelUtils.getCellData(filepath, "Login", 1, 3);
		
		
		return data;
		
	}
	@DataProvider(name = "TrackingReport")
	public static Object[][] getData15() throws IOException{
		String filepath = ConfigReader.get("excelFilePath");
		
		Object[][] data = new Object[1][5];
		
		data[0][0] = ExcelUtils.getCellData(filepath, "Login", 5, 0);
		data[0][1] = ExcelUtils.getCellData(filepath, "Login", 1, 1);
		data[0][2] = ExcelUtils.getCellData(filepath, "Values", 8, 1); //Dropdown Values
		
		data[0][3] = ExcelUtils.getCellData(filepath, "Login", 21, 2);//Start Date
		data[0][4] = ExcelUtils.getCellData(filepath, "Login", 1, 3);//End date
		
		
		return data;
		
	}
	
	@DataProvider(name = "TrackingAlterNateReport")
	public static Object[][] getData16() throws IOException{
		String filepath = ConfigReader.get("excelFilePath");
		
		Object[][] data = new Object[1][6];
		
		data[0][0] = ExcelUtils.getCellData(filepath, "Login", 5, 0);
		data[0][1] = ExcelUtils.getCellData(filepath, "Login", 1, 1);
		data[0][2] = ExcelUtils.getCellData(filepath, "Customers", 2, 0); //Customers
		data[0][3] = ExcelUtils.getCellData(filepath, "Generators", 1, 0); //Generators
		data[0][4] = ExcelUtils.getCellData(filepath, "Login", 1, 2);//Start Date
		data[0][5] = ExcelUtils.getCellData(filepath, "Login", 1, 3);//End date
		
		
		return data;
		
	}
	@DataProvider(name = "ScannedReport")
	public static Object[][] getData13() throws IOException{
		String filepath = ConfigReader.get("excelFilePath");
		
		Object[][] data = new Object[1][3];
		
		data[0][0] = ExcelUtils.getCellData(filepath, "Login", 5, 0);
		data[0][1] = ExcelUtils.getCellData(filepath, "Login", 1, 1);
		data[0][2] = ExcelUtils.getCellData(filepath, "Login", 1, 2);
		
		
		
		return data;
		
	}
	
	@DataProvider(name = "SolidReport")
	public static Object[][] getData14() throws IOException{
		String filepath = ConfigReader.get("excelFilePath");
		
		Object[][] data = new Object[1][5];
		
		data[0][0] = ExcelUtils.getCellData(filepath, "Login", 5, 0);
		data[0][1] = ExcelUtils.getCellData(filepath, "Login", 1, 1);
		data[0][2] = ExcelUtils.getCellData(filepath, "Facilities", 7, 0); //Facilities
		data[0][3] = ExcelUtils.getCellData(filepath, "Login", 1, 2);
		data[0][4] = ExcelUtils.getCellData(filepath, "Login", 1, 3);
		
		
		
		
		return data;
		
	}
	
	@DataProvider(name = "login")
	public static Object[][] getData7() throws IOException{
		String filepath = ConfigReader.get("excelFilePath");
		
		Object[][] data = new Object[1][2];
		
		data[0][0] = ExcelUtils.getCellData(filepath, "Login", 5, 0);
		data[0][1] = ExcelUtils.getCellData(filepath, "Login", 1, 1);
		
		return data;
		
	}
	
	@DataProvider(name = "CustomerReport")
	public static Object[][] getData10() throws IOException{
		String filepath = ConfigReader.get("excelFilePath");
		
		Object[][] data = new Object[1][3];
		
		data[0][0] = ExcelUtils.getCellData(filepath, "Login", 5, 0);
		data[0][1] = ExcelUtils.getCellData(filepath, "Login", 1, 1);
		data[0][2] = ExcelUtils.getCellData(filepath, "Customers", 3, 0);//Customers
		
		
		return data;
		
	}
	
	@DataProvider(name = "Addgen")
	public static Object[][] getData20() throws IOException{
		String filepath = ConfigReader.get("excelFilePath");
		
		Object[][] data = new Object[1][5];
		
		data[0][0] = ExcelUtils.getCellData(filepath, "Login", 5, 0);
		data[0][1] = ExcelUtils.getCellData(filepath, "Login", 1, 1);
		data[0][2] = ExcelUtils.getCellData(filepath, "Countries", 1, 0);//Countries
		data[0][3] = ExcelUtils.getCellData(filepath, "Countries", 1, 1);//State
		data[0][4] = ExcelUtils.getCellData(filepath, "Countries", 2, 2);//County
		
		
		
		return data;
		
	}
	
	@DataProvider(name = "Facilities")
	public static Object[][] getData18() throws IOException{
		String filepath = ConfigReader.get("excelFilePath");
		
		Object[][] data = new Object[1][5];
		
		data[0][0] = ExcelUtils.getCellData(filepath, "Login", 5, 0);
		data[0][1] = ExcelUtils.getCellData(filepath, "Login", 1, 1);
		data[0][2] = ExcelUtils.getCellData(filepath, "Facilities", 13, 0);//Facilities
		data[0][3] = ExcelUtils.getCellData(filepath, "Login", 1, 2);//Start Date
		data[0][4] = ExcelUtils.getCellData(filepath, "Login", 1, 3);//End Date
		
		
		
		return data;
		
	}
	
	@DataProvider(name = "GeneratorReport")
	public static Object[][] getData11() throws IOException{
		String filepath = ConfigReader.get("excelFilePath");
		
		Object[][] data = new Object[1][3];
		
		data[0][0] = ExcelUtils.getCellData(filepath, "Login", 5, 0);
		data[0][1] = ExcelUtils.getCellData(filepath, "Login", 1, 1);
		data[0][2] = ExcelUtils.getCellData(filepath, "Generators", 3, 0);//Generators
		
		
		return data;
		
	}
	
	@DataProvider(name = "Invoice")
	public static Object[][] getData8() throws IOException{
		String filepath = ConfigReader.get("excelFilePath");
		
		Object[][] data = new Object[1][4];
		
		data[0][0] = ExcelUtils.getCellData(filepath, "Login", 1, 0);
		data[0][1] = ExcelUtils.getCellData(filepath, "Login", 1, 1);
		data[0][2] = ExcelUtils.getCellData(filepath, "Customers", 1, 0); // Customers
		data[0][3] = ExcelUtils.getCellData(filepath, "Generators", 4, 0); // Generators
		
		
		
		return data;
		
	}
	
	@DataProvider(name = "PricingReport")
	public static Object[][] getData12() throws IOException{
		String filepath = ConfigReader.get("excelFilePath");
		
		Object[][] data = new Object[1][5];
		
		data[0][0] = ExcelUtils.getCellData(filepath, "Login", 5, 0);
		data[0][1] = ExcelUtils.getCellData(filepath, "Login", 1, 1);
		data[0][2] = ExcelUtils.getCellData(filepath, "Customers", 1, 0); // Customers
		data[0][3] = ExcelUtils.getCellData(filepath, "Generators", 4, 0); // Generators
		data[0][4] = ExcelUtils.getCellData(filepath, "Values", 6, 0); // Status  
		
		
		return data;
		
	}
	
	@DataProvider(name = "PInvoice")
	public static Object[][] getData9() throws IOException{
		String filepath = ConfigReader.get("excelFilePath");
		
		Object[][] data = new Object[1][6];
		
		data[0][0] = ExcelUtils.getCellData(filepath, "Login", 1, 0);
		data[0][1] = ExcelUtils.getCellData(filepath, "Login", 1, 1);
		data[0][2] = ExcelUtils.getCellData(filepath, "Customers", 1, 0); // Customers
		data[0][3] = ExcelUtils.getCellData(filepath, "Generators", 4, 0); // Generators
		data[0][4] = ExcelUtils.getCellData(filepath, "Invoices", 1, 0); // Invoices
		data[0][5] = ExcelUtils.getCellData(filepath, "Invoices", 1, 1); //Doc Types
		
		
		
		
		
		return data;
		
	}
	
	@DataProvider(name = "loginData2")
	public static Object[][] getData6() throws IOException{
		String filepath = ConfigReader.get("excelFilePath");
		
		Object[][] data = new Object[1][10];
		
		data[0][0] = ExcelUtils.getCellData(filepath, "Login", 5, 0); //User Name
		data[0][1] = ExcelUtils.getCellData(filepath, "Login", 1, 1);
		data[0][2] = ExcelUtils.getCellData(filepath, "Customers",2,0); // Customers
		data[0][3] = ExcelUtils.getCellData(filepath, "Generators",1,0); //Generators
		data[0][4] = ExcelUtils.getCellData(filepath, "SalesRep",1,0); //Salesrep
		data[0][5] = ExcelUtils.getCellData(filepath, "InsideSalesRep",2,0); //InsideSalesRep
		data[0][6] = ExcelUtils.getCellData(filepath, "CSR",4,0); //CSR
		data[0][7] = ExcelUtils.getCellData(filepath, "Facilities",16,0); //Facilities
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
		data[0][5] = ExcelUtils.getCellData(filepath, "TankNumber", 3, 3); //JobId
		
		
		
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
		
		data[0][0] = ExcelUtils.getCellData(filepath, "Login", 5, 0);
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
		
		data[0][0] = ExcelUtils.getCellData(filepath, "Login", 5, 0);
		data[0][1] = ExcelUtils.getCellData(filepath, "Login", 1, 1);
		data[0][2] = ExcelUtils.getCellData(filepath, "Customers", 2, 0);
		data[0][3] = ExcelUtils.getCellData(filepath, "Generators", 1, 0);
		
		//data[0][2] = ExcelUtils.getCellData(filepath, "Facilities", 1, 0);//Facilities
		
		
		return data;
		
	}
	
	@DataProvider(name = "InterCompany")
	public static Object[][] Inter() throws Exception {
	    String filepath = ConfigReader.get("excelFilePath");
	    String userid = ExcelUtils.getCellData(filepath, "Login", 1, 0);
	    String pwd = ExcelUtils.getCellData(filepath, "Login", 1, 1);
	    String customer = ExcelUtils.getCellData(filepath, "Customers", 6, 0);
	    String type = ExcelUtils.getCellData(filepath, "Container",2,0);//Container Type
	    String UNT = ExcelUtils.getCellData(filepath, "Container",1,1);//Unit

	    String query1 = "select vendor_name from base_vendor where vendor_id = 1";
	    String query2 = "select vendor_name from base_vendor where vendor_id = 14";

	    List<Object[]> dataList = new ArrayList<>();
	    ResultSet rs1 = null, rs2 = null;
	    Statement stmt1 = null, stmt2 = null;

	    try {
	        stmt1 = DBUtils.getConnection().createStatement();
	        rs1 = stmt1.executeQuery(query1);

	        stmt2 = DBUtils.getConnection().createStatement();
	        rs2 = stmt2.executeQuery(query2);

	        String vendor1 = null, vendor2 = null;

	        if (rs1.next()) {
	            vendor1 = rs1.getString("vendor_name");
	        }
	        if (rs2.next()) {
	            vendor2 = rs2.getString("vendor_name");
	        }

	        // Add test data
	        dataList.add(new Object[] { userid, pwd, customer, vendor1, vendor2,type,UNT });

	    } finally {
	        DBUtils.closeResources(rs1, stmt1);
	        DBUtils.closeResources(rs2, stmt2);
	        DBUtils.closeConnection();
	    }

	    return dataList.toArray(new Object[0][]);
	}
	@DataProvider(name = "InboundsDB")
	public static Object[][] getManifestData() throws Exception {
	    String filepath = ConfigReader.get("excelFilePath");
	    String userid = ExcelUtils.getCellData(filepath, "Login", 1, 0);
	    String pwd = ExcelUtils.getCellData(filepath, "Login", 1, 1);
	    String gendte = ExcelUtils.getCellData(filepath, "Login", 95, 2);
	    String trndate = ExcelUtils.getCellData(filepath, "Login", 94, 2);

	    String query = "SELECT TOP 1 m.manifest_tracking_number FROM base_waste_manifest m INNER JOIN base_waste_manifest_detail d ON m.manifest_id = d.manifest_id WHERE m.received_date IS NULL AND m.vendor_id = '257' and allow_receive_ind = '1';";

	    List<Object[]> dataList = new ArrayList<>();
	    ResultSet rs = null;
	    Statement stmt = null;

	    try {
	        stmt = DBUtils.getConnection().createStatement();
	        rs = stmt.executeQuery(query);

	        while (rs.next()) {
	            dataList.add(new Object[] {
	                userid,
	                pwd,
	                rs.getString("manifest_tracking_number"),
	                gendte,trndate
	            });
	        }
	    } finally {
	        DBUtils.closeResources(rs, stmt);
	        DBUtils.closeConnection();
	    }

	    return dataList.toArray(new Object[0][]);
	}
	
	@DataProvider(name = "GeneratorDB")
	public static Object[][] getGenData() throws Exception {
	    String filepath = ConfigReader.get("excelFilePath");
	    String userid = ExcelUtils.getCellData(filepath, "Login", 1, 0);
	    String pwd = ExcelUtils.getCellData(filepath, "Login", 1, 1);
	   

	    String query = "select * from generator where generatorid = '582'";

	    List<Object[]> dataList = new ArrayList<>();
	    ResultSet rs = null;
	    Statement stmt = null;

	    try {
	        stmt = DBUtils.getConnection().createStatement();
	        rs = stmt.executeQuery(query);

	        while (rs.next()) {
	            dataList.add(new Object[] {
	                userid,
	                pwd,
	                rs.getString("generatorid")
	                
	            });
	        }
	    } finally {
	        DBUtils.closeResources(rs, stmt);
	        DBUtils.closeConnection();
	    }

	    return dataList.toArray(new Object[0][]);
	}
}