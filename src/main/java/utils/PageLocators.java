package utils;

public class PageLocators {
	
	public static final String Facility_Arrow = "#ctl00_MainContent_PlantId button.rcbActionButton";
	public static final String FACILITY_LIST = "//div[@id='ctl00_MainContent_PlantId_DropDown']/div/ul/li[contains(text(),'%s')]";
	
	public static final String Facility_Arrow1 = "#ctl00_MainContent_rcbRevenuePlant button.rcbActionButton";
	public static final String Facility_LIST1 = "//div[@id='ctl00_MainContent_rcbRevenuePlant_DropDown']/div/ul/li[contains(text(),'%s')]";
	
	public static final String dropdown_Arrow = "#ctl00_MainContent_RadGrid1_ctl00_ctl03_ctl01_PageSizeComboBox button.rcbActionButton";
	public static final String dropdown_size = "//div[@id = 'ctl00_MainContent_RadGrid1_ctl00_ctl03_ctl01_PageSizeComboBox_DropDown']/div/ul/li[contains(text(),'%s')]";
	
	public static final String prfleexcel_Arrow = "#ctl00_MainContent_PlantId button.rcbActionButton";
	public static final String prfleexcel_list = "//div[@id = 'ctl00_MainContent_PlantId_DropDown']/div/ul/li[contains(text(),'%s')]";
	
	public static final String page_Arrow = "//span[contains(@id,'PageSizeComboBox_Arrow')]";
	public static final String page_size = "//div[contains(@id,'PageSizeComboBox_DropDown')]//div//ul//li[contains(text(),'%s')]";
	
	public static final String customer_Arrow = "//input[contains(@id,'PageSizeComboBox')]/following-sibling::button[contains(@class,'rcbActionButton')]";
	public static final String customer_size = "//div[contains(@id,'PageSizeComboBox_DropDown')]/div/ul/li[contains(text(),'%s')]";
	
	public static final String slsrp_Arrow = "//input[contains(@id,'rcbSalesRep')]/following-sibling::button[contains(@class,'rcbActionButton')]";
	public static final String slsrp_size = "//div[contains(@id,'rcbSalesRep_DropDown')]/div/ul/li[contains(text(),'%s')]";
	
	public static final String plant_Arrow = "#ctl00_MainContent_PlantId button.rcbActionButton";
	public static final String plant_size = "//div[@id = 'ctl00_MainContent_PlantId_DropDown']/div/ul/li[contains(text(),'%s')]";
	
	public static final String user_Arrow = "//span[@class = 'ag-icon ag-icon-small-down']";
	public static final String user_size = "//span[@class = 'ag-icon ag-icon-small-down']";
	
}
