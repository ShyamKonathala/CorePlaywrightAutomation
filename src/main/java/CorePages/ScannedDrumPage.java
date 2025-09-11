package CorePages;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import base.basetest;
import utils.FileUtils;

public class ScannedDrumPage {
private static final Logger logger = Logger.getLogger(ScannedDrumPage.class.getName());
	
	
	private Page page;

	private Locator Reporting;
	private Locator Reports;
	private Locator scnttle;
	private Locator strt;
	private Locator srchbtn;
	private Locator excel;
	private Locator next;
	private Locator previous;
	
	public ScannedDrumPage(Page page) {
		this.page = page;
		Reporting = page.locator("//span[contains(text(),'Reporting')]");
		 Reports = page.locator("//li[@class = 'rmItem rmFirst']/a[contains(text(),'Reports')]");
		 scnttle = page.locator("//a[@title = 'Scanned Drum Discrepancy']");
		 strt = page.locator("//div[@id = 'ctl00_MainContent_rdpDate_dateInput_wrapper']/input[1]");
		 srchbtn = page.locator("#searchButton");
		 excel = page.locator("//a[contains(@id,'lbExport')]");
		 next = page.locator("//div[@class = 'rgWrap rgArrPart2']/button[2]");
		 previous = page.locator("//div[@class = 'rgWrap rgArrPart1']/button[1]");
	}
	
	public void Scndrm() {
		page.waitForTimeout(5000);
		Reporting.hover();
		logger.info("Reporting hovered");
		page.waitForTimeout(5000);
		Reports.click();
		logger.info("Reports Clicked");
		page.waitForTimeout(5000);
		scnttle.click();
		logger.info("Scanned Drum Title clicked");
	}
	public void start(String startDate) {
		page.waitForTimeout(5000);
		strt.fill(startDate);
	
	}
	public void srch() {
		page.waitForTimeout(5000);
		srchbtn.click();
		page.waitForTimeout(5000);
		
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
}
