package CorePages;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import base.basetest;
import utils.FileUtils;

public class RevenueOutboundPage {
private static final Logger logger = Logger.getLogger(RevenueOutboundPage.class.getName());
	
	
	private Page page;

	private Locator Reporting;
	private Locator Reports;
	private Locator rvnettle;
	private Locator outwkdr;
	private Locator rrprt;
	private Locator excel;
	private Locator next;
	private Locator previous;
	
	
	public RevenueOutboundPage(Page page) {
		this.page = page;
		Reporting = page.locator("//span[contains(text(),'Reporting')]");
		 Reports = page.locator("//li[@class = 'rmItem rmFirst']/a[contains(text(),'Reports')]");
		 rvnettle = page.locator("//a[@title = 'Revenue Detail By Outbound']");
		 outwkdr = page.locator("//span[@id = 'ctl00_MainContent_rtbWorkorder_wrapper']/input[1]");
		 rrprt = page.locator("#MainContent_btnSearch");
		 excel = page.locator("//a[contains(@id,'lbExport')]");
		 next = page.locator("//div[@class = 'rgWrap rgArrPart2']/button[1]");
		 previous = page.locator("//div[@class = 'rgWrap rgArrPart1']/button[2]");
	}
	
	public void outbound() {
		page.waitForTimeout(5000);
		Reporting.hover();
		logger.info("Reporting hovered");
		page.waitForTimeout(5000);
		Reports.click();
		logger.info("Reports Clicked");
		page.waitForTimeout(5000);
		rvnettle.click();
		logger.info("Title Clicked");
	}
	public void workodr() {
		outwkdr.fill("3158967");
		logger.info("Value entered");
		rrprt.click();
		logger.info("Run Report Clicked");
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
