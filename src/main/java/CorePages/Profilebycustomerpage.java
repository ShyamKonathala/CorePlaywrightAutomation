package CorePages;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import base.basetest;
import utils.FileUtils;

public class Profilebycustomerpage {
	
private static final Logger logger = Logger.getLogger(Profilebycustomerpage.class.getName());
	
	
	private Page page;

	private Locator Reporting;
	private Locator Reports;
	private Locator cstttle;
	private Locator cstmr;
	private Locator excel;
	private Locator next;
	private Locator previous;
	
	public Profilebycustomerpage(Page page) {
		this.page = page;
		Reporting = page.locator("//span[contains(text(),'Reporting')]");
		 Reports = page.locator("//li[@class = 'rmItem rmFirst']/a[contains(text(),'Reports')]");
		 cstttle = page.locator("//a[@title = 'Profiles By Customer Report']");
		 cstmr = page.locator("//input[@name = 'ctl00$MainContent$racbCustomerAjax']");
		 excel = page.locator("//a[contains(@id,'lbExport')]");
		 next = page.locator("//div[@class = 'rgWrap rgArrPart2']/button[1]");
		 previous = page.locator("//div[@class = 'rgWrap rgArrPart1']/button[2]");
	}
	
	public void cstmer(String customer) {
		page.waitForTimeout(5000);
		Reporting.hover();
		logger.info("Reports Hovered");
		page.waitForTimeout(5000);
		Reports.click();
		logger.info("Reports Clicked");
		cstttle.click();
		page.waitForTimeout(5000);
		logger.info(" Customer Title Clicked");
		cstmr.fill(customer);
		page.waitForTimeout(5000);
		page.keyboard().press("ArrowDown");
		page.waitForTimeout(5000);
		page.keyboard().press("Enter");
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
