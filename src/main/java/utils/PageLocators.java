package utils;

public class PageLocators {
	
	public static final String Facility_Arrow = "#ctl00_MainContent_PlantId button.rcbActionButton";
	public static final String FACILITY_LIST = "//div[@id='ctl00_MainContent_PlantId_DropDown']/div/ul/li[contains(text(),'%s')]";
	
	
	public static final String Facility_Arrow1 = "#ctl00_MainContent_rcbRevenuePlant button.rcbActionButton";
	public static final String Facility_LIST1 = "//div[@id='ctl00_MainContent_rcbRevenuePlant_DropDown']/div/ul/li[contains(text(),'%s')]";
	
	public static final String dropdown_Arrow = "#ctl00_MainContent_RadGrid1_ctl00_ctl03_ctl01_PageSizeComboBox button.rcbActionButton";
	public static final String dropdown_size = "//div[@id = 'ctl00_MainContent_RadGrid1_ctl00_ctl03_ctl01_PageSizeComboBox_DropDown']/div/ul/li[contains(text(),'%s')]";
}
