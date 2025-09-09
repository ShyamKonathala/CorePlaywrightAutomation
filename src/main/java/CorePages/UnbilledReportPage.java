package CorePages;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import utils.FileUtils;

public class UnbilledReportPage {
	
private static final Logger logger = Logger.getLogger(UnbilledReportPage.class.getName());
	
	private Page page;
	
	private Locator Reporting;
	private Locator Reports;
	private Locator unbttle;
	private Locator Date;
	private Locator runrprt;
	private Locator excel;
	private Locator next;
	private Locator previous;
	
	public UnbilledReportPage(Page page) {
		this.page = page;
		Reporting = page.locator("//span[contains(text(),'Reporting')]");
		 Reports = page.locator("//li[@class = 'rmItem rmFirst']/a[contains(text(),'Reports')]");
		 unbttle = page.locator("//a[@title = 'Unbilled Report']");
		 Date = page.locator("//div[@id = 'ctl00_MainContent_rdpDate_dateInput_wrapper']//input[@id = 'ctl00_MainContent_rdpDate_dateInput']");
		 runrprt = page.locator("#MainContent_btnSearch");
		 excel = page.locator("//a[contains(@id,'lbExport')]");
		 next = page.locator("//div[@class = 'rgWrap rgArrPart2']/button[2]");
			previous = page.locator("//div[@class = 'rgWrap rgArrPart1']/button[1]");
	}
	
	public void Unbilled() {
		page.waitForTimeout(5000);
		Reporting.hover();
		page.waitForTimeout(3000);
		logger.info("Reporting hovered");
		Reports.click();
		logger.info("Reports Clicked");
		page.waitForTimeout(3000);
		unbttle.click();
		logger.info("Unbilled Report Clicked");
		page.waitForTimeout(3000);
		
	}
	public void date() {
		Date.fill("6/1/2025");
		page.waitForTimeout(5000);
	}
	
	public void rrprt() {
		runrprt.click();
		page.waitForTimeout(10000);
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
