package CorePages;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import base.basetest;
import utils.FileUtils;

public class ReceivingLogsPage {
private static final Logger logger = Logger.getLogger(ReceivingLogsPage.class.getName());
	
	
	private Page page;

	private Locator Reporting;
	private Locator Reports;
	private Locator lgsttle;
	private Locator strt;
	private Locator end;
	private Locator srchbtn;
	private Locator excel;
	private Locator next;
	private Locator previous;
	
	public ReceivingLogsPage(Page page) {
		this.page = page;
		Reporting = page.locator("//span[contains(text(),'Reporting')]");
		 Reports = page.locator("//li[@class = 'rmItem rmFirst']/a[contains(text(),'Reports')]");
		 lgsttle = page.locator("//a[@title = 'Receiving Logs Missing Data']");
		 strt = page.locator("//div[@id = 'ctl00_MainContent_rdpStartDate_dateInput_wrapper']/input[1]");
		 end = page.locator("//div[@id = 'ctl00_MainContent_rdpEndDate_dateInput_wrapper']/input[1]");
		 srchbtn = page.locator("#searchButton");
		 excel = page.locator("//a[contains(@id,'lbExport')]");
		 next = page.locator("//div[@class = 'rgWrap rgArrPart2']/button[1]");
		 previous = page.locator("//div[@class = 'rgWrap rgArrPart1']/button[2]");
	}
	
	public void logs() {
		page.waitForTimeout(5000);
		Reporting.hover();
		logger.info("Reporting hovered");
		page.waitForTimeout(5000);
		Reports.click();
		logger.info("Reports Clicked");
		page.waitForTimeout(5000);
		lgsttle.click();
		logger.info("Title Clicked");
	}
	public void start(String startDate) {
		page.waitForTimeout(5000);
		strt.fill(startDate);
	}
	
	public void enddte(String endDate) {
		page.waitForTimeout(5000);
		end.fill(endDate);
	}
	public void srch() {
		page.waitForTimeout(5000);
		srchbtn.click();
		logger.info("Search button clicked");
		page.waitForTimeout(5000);
		
	}
	
	public void expexl() throws IOException {
		Path downloadedFile = FileUtils.downloadFile(page, () -> excel.click());
	    logger.info("Excel Downloaded to: " + downloadedFile.toString());
	}
	
	public void buttons() {
		next.click();
		logger.info("Next Button Clicked");
		page.waitForTimeout(5000);
		previous.click();
		logger.info("Previous Button Clicked");
		page.waitForTimeout(5000);
		
	}
}
