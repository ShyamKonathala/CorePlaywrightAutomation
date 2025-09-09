package CorePages;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import utils.FileUtils;

public class TrackingAlternatePage {
	
private static final Logger logger = Logger.getLogger(TrackingAlternatePage.class.getName());
	
	private Page page;
	
	private Locator Reporting;
	private Locator Reports;
	private Locator trttle;
	private Locator cstmr;
	private Locator genertr;
	private Locator startDate;
	private Locator endDate;
	private Locator srchbtn;
	private Locator excel;
	private Locator next;
	private Locator previous;
	private Locator rstbtn;
	
	public TrackingAlternatePage(Page page) {
		this.page = page;
		Reporting = page.locator("//span[contains(text(),'Reporting')]");
		 Reports = page.locator("//li[@class = 'rmItem rmFirst']/a[contains(text(),'Reports')]");
		 trttle = page.locator("//a[@title = 'Tracking Report - Alternate View']");
		 cstmr = page.locator("//input[@name = 'ctl00$MainContent$racbCustomerAjax']");
		 genertr = page.locator("//input[@name = 'ctl00$MainContent$racbGeneratorAjax']");
		 startDate = page.locator("//div[@id = 'ctl00_MainContent_rdpStartDate_dateInput_wrapper']/input[1]");
			endDate = page.locator("//div[@id = 'ctl00_MainContent_rdpEndDate_dateInput_wrapper']/input[1]");
			srchbtn = page.locator("//input[@id = 'MainContent_btnSearch']");
			excel = page.locator("//a[contains(@id,'lbExport')]");
			next = page.locator("//div[@class = 'rgWrap rgArrPart2']/button[2]");
			previous = page.locator("//div[@class = 'rgWrap rgArrPart1']/button[1]");
			rstbtn = page.locator("#MainContent_btnReset");
	}
	public void traltnte() {
		page.waitForTimeout(5000);
		Reporting.hover();
		page.waitForTimeout(3000);
		logger.info("Reporting hovered");
		Reports.click();
		logger.info("Reports Clicked");
		page.waitForTimeout(3000);
		trttle.click();
		
		logger.info("Title Clicked");
		
	}
public void cusgen(String customer,String generator) {
	cstmr.fill(customer);
	page.waitForTimeout(5000);
	page.keyboard().press("ArrowDown");
	page.waitForTimeout(5000);
	page.keyboard().press("Enter");
	logger.info("Customer Entered");
	page.waitForTimeout(5000);
	
	genertr.fill(generator);
	page.waitForTimeout(5000);
	page.keyboard().press("ArrowDown");
	page.keyboard().press("ArrowDown");
	page.waitForTimeout(5000);
	page.keyboard().press("Enter");
	logger.info("Generator Entered");
	page.waitForTimeout(5000);
}
public void start(String startdate) {
	
	startDate.fill(startdate);
	page.waitForTimeout(5000);
}

public void end(String enddate) {
	endDate.fill(enddate);
	page.waitForTimeout(5000);
}
public void srch() {
	srchbtn.click();
	page.waitForTimeout(5000);
	logger.info("Search button Clicked");
}
public void expexl() throws IOException {
	Path downloadedFile = FileUtils.downloadFile(page, () -> excel.click());
    logger.info("Excel Downloaded to: " + downloadedFile.toString());
    page.waitForTimeout(5000);
}

public void buttons() {
	next.click();
	logger.info("Next Button Clicked");
	page.waitForTimeout(5000);
	previous.click();
	logger.info("Previous Button Clicked");
	page.waitForTimeout(5000);
	
}

public void reset() {
	 page.waitForTimeout(5000);
	 rstbtn.click();
	 logger.info("Page Reset");
	 page.waitForTimeout(5000);
}

}
