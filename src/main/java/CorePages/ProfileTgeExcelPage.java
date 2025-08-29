package CorePages;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import base.basetest;
import utils.FileUtils;

public class ProfileTgeExcelPage {
	
private static final Logger logger = Logger.getLogger(PInvoicePage.class.getName());
	
	private Page page;
	
	private Locator Reporting;
	private Locator Reports;
	private Locator ttle;
	private Locator startDate;
	private Locator endDate;
	private Locator srchbtn;
	private Locator excelbtn;
	private Locator frstbtn;
	private Locator scndbtn;
	private Locator thrdbtn;
	
	
	
	public ProfileTgeExcelPage(Page page) {
		this.page = page;
		Reporting = page.locator("//span[contains(text(),'Reporting')]");
		 Reports = page.locator("//li[@class = 'rmItem rmFirst']/a[contains(text(),'Reports')]");
		 ttle = page.locator("//a[@title = 'Profile Tonnage Report (Excel Export)']");
		 startDate = page.locator("//div[@id = 'ctl00_MainContent_rdpStartDate_dateInput_wrapper']/input[1]");
		 endDate = page.locator("//div[@id = 'ctl00_MainContent_rdpEndDate_dateInput_wrapper']/input[1]");
		 excelbtn = page.locator("#ctl00_MainContent_RadGrid1_ctl00_ctl02_ctl00_lbExport");
		 srchbtn = page.locator("#MainContent_btnSearch");
		 frstbtn = page.locator("//div[@class = 'rgWrap rgNumPart']//a[1]");
		 scndbtn = page.locator("//div[@class = 'rgWrap rgNumPart']//a[2]");
		 thrdbtn = page.locator("//div[@class = 'rgWrap rgNumPart']//a[3]");
	}
	
	public void excel() {
		Reporting.hover();
		logger.info("Reporting hovered");
		Reports.click();
		logger.info("Reports clicked");
		ttle.click();
		logger.info("Title Clicked");
		
	}
	
	public void strtdte(String start) {
		startDate.fill(start);
	}
public void enddte(String end) {
	endDate.fill(end);
}
public void search() {
	srchbtn.click();
	logger.info("Search button clicked");
	page.waitForTimeout(10000);
}
public void expexl() throws IOException {
	Path downloadedFile = FileUtils.downloadFile(page, () -> excelbtn.click());
    logger.info("Excel Downloaded to: " + downloadedFile.toString());
    page.waitForTimeout(10000);
}

public void button() {
	frstbtn.click();
	logger.info("First button clicked");
	page.waitForTimeout(10000);
	scndbtn.click();
	logger.info("Second button clicked");
	page.waitForTimeout(10000);
	thrdbtn.click();
	logger.info("Third button clicked");
}
}
