package CorePages;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import base.basetest;
import utils.FileUtils;

public class ProfilesbyGeneratorPage {
	
private static final Logger logger = Logger.getLogger(ProfilesbyGeneratorPage.class.getName());
	
	
	private Page page;

	private Locator Reporting;
	private Locator Reports;
	private Locator genttle;
	private Locator genrtr;
	private Locator excel;
	private Locator next;
	private Locator previous;
	
	public ProfilesbyGeneratorPage(Page page) {
		this.page = page;

excel = page.locator("//a[contains(@id,'lbExport')]");
		Reporting = page.locator("//span[contains(text(),'Reporting')]");
		 Reports = page.locator("//li[@class = 'rmItem rmFirst']/a[contains(text(),'Reports')]");
		 genttle = page.locator("//a[@title = 'Profiles By Generator Report']");
		 genrtr = page.locator("//input[@name = 'ctl00$MainContent$racbGeneratorAjax']");
		 next = page.locator("//div[@class = 'rgWrap rgArrPart2']/button[1]");
		 previous = page.locator("//div[@class = 'rgWrap rgArrPart1']/button[2]");
	}
	
	public void gen(String generator) {
		Reporting.hover();
		logger.info("Reports Hovered");
		Reports.click();
		logger.info("Reports Clicked");
		genttle.click();
		logger.info("Gen title clicked");
		genrtr.fill(generator);
		page.waitForTimeout(5000);
		page.keyboard().press("ArrowDown");
		page.waitForTimeout(5000);
		page.keyboard().press("Enter");
		page.waitForTimeout(10000);
		
		}
	
	public void expexl() throws IOException {
		Path downloadedFile = FileUtils.downloadFile(page, () -> excel.click());
	    logger.info("Excel Downloaded to: " + downloadedFile.toString());
	}
	public void buttons() {
		page.waitForTimeout(10000);
		next.click();
		logger.info("Next Button Clicked");
		page.waitForTimeout(5000);
		previous.click();
		logger.info("Previous Button Clicked");
		page.waitForTimeout(5000);
		
	}

}
