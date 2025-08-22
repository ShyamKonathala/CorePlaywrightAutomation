package utils;

import com.microsoft.playwright.Page;

public class DropdownUtils {
	
	// private final static String arrowXpath = "#ctl00_MainContent_rcbSalesRep_Arrow";
	
	 /**
     * Selects a value from a custom dropdown (like RadComboBox).
     * 
     * @param page        Playwright page instance
     * @param arrowXpath  XPath or CSS selector for the dropdown arrow button
     * @param valueToPick Visible text of the value to select (e.g., "50")
     */
    public static void selectCustomDropdownValue(Page page,  String valueToPick) {
    	
    	 String arrowXpath = "//div[contains(@id,'PageSizeComboBox')]/span[1]";
        // Click the dropdown arrow to show options
        page.click(arrowXpath);
        
        
        
        String valueXpath = "//div[contains(@id,'PageSizeComboBox_DropDown')]/div/ul/li[normalize-space(text())='" + valueToPick + "']";
        
        // Optional: wait for the options list to become visible
        page.waitForSelector(valueXpath).click();
    }
    
    public static void selectDropdownValue(Page page,String salesrep) {
    	
    	String arrowXpath = "#ctl00_MainContent_rcbSalesRep_Arrow";
   	
       // Click the dropdown arrow to show options
       page.click(arrowXpath);
       
       
       
       String valueXpath = "//div[contains(@id, 'rcbSalesRep_DropDown')]//div//ul//li[normalize-space(text())='" + salesrep + "']";
       
       // Optional: wait for the options list to become visible
       page.waitForSelector(valueXpath).click();
   }
public void facilitydropdown(Page page, String Facility) {
	String arrowId = "#ctl00_MainContent_PlantId_Arrow";
	
	page.click(arrowId);
	System.out.println("Arrow Selected");
	
	String value = "//div[@id='ctl00_MainContent_PlantId_DropDown']/div/ul/li[contains(text(),'" + Facility + " ')]";
	
	page.waitForSelector(value).click();
	System.out.println("Facility Clicked");
}
    
}
