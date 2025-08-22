package CorePages;



import com.microsoft.playwright.Download;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import utils.DropdownUtils;
import utils.FileUtils;



public class ProfileRecertPage {
	
	//String desiredmonthyear = "August 2025";
	
	
	private static final Logger logger = Logger.getLogger(ProfileRecertPage.class.getName());
	
	private Page page;
	
	//private static final Logger logger = LoggerFactory.getLogger(ProfileRecertPage.class);
	
	private Locator Reporting;
	private Locator Reports;
	private Locator prrcrtttle;
	private String cstmr;
	private Locator startDate;
	private Locator next;
	private Locator search;
	private Locator expexl;
	
	
	
	public ProfileRecertPage(Page page) {
		
		Reporting = page.locator("//span[contains(text(),'Reporting')]");
		Reports = page.locator("//li[@class = 'rmItem rmFirst']/a[contains(text(),'Reports')]");
		prrcrtttle = page.locator("//a[@title = 'Profile Needing Recert (Searchable)']");
		startDate = page.locator("//a[@id = 'ctl00_MainContent_rdpStartDate_popupButton']");
		next = page.locator("//a[@id = 'ctl00_MainContent_rdpStartDate_calendar_NN']//span[@class = 't-font-icon t-i-arrow-right']");
		search = page.locator("//input[@id = 'btnSearch']");
		expexl = page.locator("//button[@id = 'btnExportToExcel']");
		
		
		this.page = page;
	}
	
	public void recert() {
		Reporting.hover();
		logger.info("Reporting hovered");
		Reports.click();
		logger.info("Reports clicked");
		prrcrtttle.click();
		logger.info("Title Clicked");
		
	}
	
	public void dropdown(String salesrep) {
		DropdownUtils.selectDropdownValue(page, salesrep);
		logger.info("SalesRep Selected");
	}
	
	public void customer(String customer) {
		page.locator("[name = 'ctl00$MainContent$ucCustomerAjax$racbCustomerAjax']").fill(customer);
		page.waitForTimeout(5000);
	    page.keyboard().press("ArrowDown");
	    
	    page.keyboard().press("Enter");
	    logger.info("Customer Selected and entered");
	    page.waitForTimeout(5000);
	}
	
	public void srch() throws IOException {
		search.click();
		logger.info("Search clicked");
		
		/*Download download = page.waitForDownload(() -> {
		expexl.click();
		logger.info("Excel Downloaded");
		});*/
		 Path downloadedFile = FileUtils.downloadFile(page, () -> expexl.click());
		    logger.info("Excel Downloaded to: " + downloadedFile.toString());
		}
	
}
