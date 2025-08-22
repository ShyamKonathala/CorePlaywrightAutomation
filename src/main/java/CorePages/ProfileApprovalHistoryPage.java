package CorePages;

import java.nio.file.Paths;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitForSelectorState;

import utils.DropdownUtils;

import java.util.logging.Logger;

public class ProfileApprovalHistoryPage {
	
	private static final Logger logger = Logger.getLogger(ProfileApprovalHistoryPage.class.getName());
	
	
	private Page page;
	
	private Locator Reporting;
	private Locator Reports;
	private Locator apprttle;
	private Locator startDate;
	private Locator endDate;
	private Locator searchButton;
	private Locator thirdbtn;
	private Locator ffthbtn;
	private Locator frstbtn;
	
	 private String Excel = "#ctl00_MainContent_RadGrid1_ctl00_ctl02_ctl00_lbExport";
	 
	
	
	
	 
	
	public ProfileApprovalHistoryPage(Page page) {
		
		this.page = page;
	
		
		Reporting = page.locator("//span[contains(text(),'Reporting')]");
		 Reports = page.locator("//li[@class = 'rmItem rmFirst']/a[contains(text(),'Reports')]");
		 apprttle = page.locator("//a[@title = 'Profile Approval History']");
		 startDate = page.locator("//div[@id = 'ctl00_MainContent_rdpStartDate_dateInput_wrapper']/input[1]");
		endDate = page.locator("//div[@id = 'ctl00_MainContent_rdpEndDate_dateInput_wrapper']/input[1]");
		 searchButton= page.locator("#MainContent_btnSearch");
		 thirdbtn = page.locator("//div[@class = 'rgWrap rgNumPart']/a[3]");
		 ffthbtn = page.locator("//div[@class = 'rgWrap rgNumPart']/a[5]");
		 frstbtn = page.locator("//div[@class = 'rgWrap rgNumPart']/a[1]");
		
	}
	
public void Approval() throws InterruptedException {
	Reporting.hover();
	
	Reports.click();
	apprttle.click();
	
	}

public void start(String startdate) {
	
	startDate.fill(startdate);
}

public void end(String enddate) {
	endDate.fill(enddate);
}
public void srch() {
	searchButton.click();
}
public void expexcel() {
	  Download download = page.waitForDownload(() -> {
	        page.click(Excel);  // Trigger the download
	        try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	    });
	  
	 // download.saveAs(Paths.get("C:\\Users\\kshyamsai\\Downloads"));
}

public void btn() {
	thirdbtn.click();
	logger.info("Third button clicked");
	ffthbtn.click();
	logger.info("Fifth button clicked");
	frstbtn.click();
	logger.info("First button clicked");
}

public void dropdown() throws InterruptedException {
	DropdownUtils.selectCustomDropdownValue(page, "50");
	logger.info("50 Selected");
	DropdownUtils.selectCustomDropdownValue(page, "10");
	logger.info("10 Selected");
	Thread.sleep(5000);
}
public void waitForAjaxToFinish() {
    page.waitForSelector(".RadAjax", new Page.WaitForSelectorOptions().setState(WaitForSelectorState.HIDDEN));
    
}

}
