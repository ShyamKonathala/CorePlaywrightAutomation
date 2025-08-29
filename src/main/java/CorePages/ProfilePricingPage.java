package CorePages;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import base.basetest;
import utils.FileUtils;

public class ProfilePricingPage {
	
private static final Logger logger = Logger.getLogger(ProfilePricingPage.class.getName());
	
	
	private Page page;

	private Locator Reporting;
	private Locator Reports;
	private Locator prcngttle;
	private Locator cstmr;
	private Locator genrtr;
	private Locator Arrow;
	private Locator srchbtn;
	private Locator excel;
	private Locator next;
	private Locator previous;
	
	public ProfilePricingPage(Page page) {
		this.page = page;
		
		Reporting = page.locator("//span[contains(text(),'Reporting')]");
		 Reports = page.locator("//li[@class = 'rmItem rmFirst']/a[contains(text(),'Reports')]");
		 prcngttle = page.locator("//a[@title = 'Profiles With Pricing']");
		 cstmr = page.locator("//input[@name = 'ctl00$MainContent$ucCustomerAjax$racbCustomerAjax']");
		 genrtr = page.locator("//input[@name = 'ctl00$MainContent$ucGeneratorAjax$racbGeneratorAjax']");
		 Arrow = page.locator("#ctl00_MainContent_rcbStatus button.rcbActionButton");
		 srchbtn = page.locator("#MainContent_btnSearch");
		 excel = page.locator("//a[contains(@id,'lbExport')]");
		 next = page.locator("//div[@class = 'rgWrap rgArrPart2']/button[1]");
		 previous = page.locator("//div[@class = 'rgWrap rgArrPart1']/button[2]");
		 
	}
public void pricing() {
	Reporting.hover();
	logger.info("Reports Hovered");
	Reports.click();
	logger.info("Reports Clicked");
	prcngttle.click();
	logger.info("Pricing Title Clicked");
	
}

public void cusgen(String customer,String generator) {
	cstmr.fill(customer);
	page.waitForTimeout(5000);
	page.keyboard().press("ArrowDown");
	page.waitForTimeout(5000);
	page.keyboard().press("Enter");
	page.waitForTimeout(5000);
	
	genrtr.fill(generator);
	page.waitForTimeout(20000);
	page.keyboard().press("ArrowDown");
	page.keyboard().press("ArrowDown");
	page.waitForTimeout(5000);
	page.keyboard().press("Enter");
	page.waitForTimeout(5000);
	
	}
public void status(String svalue) {
	Arrow.click();
	logger.info("Arrow Clicked");
	
	String value = "//div[@id = 'ctl00_MainContent_rcbStatus_DropDown']/div/ul/li[contains(text(),'"+ svalue +"')]";
	page.click(value);
	logger.info("Status Value Selected");
}

public void srch() {
	srchbtn.click();
	logger.info("Search button clicked");
	
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
