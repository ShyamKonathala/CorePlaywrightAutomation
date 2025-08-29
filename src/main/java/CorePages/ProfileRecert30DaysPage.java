package CorePages;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import base.basetest;
import utils.FileUtils;

public class ProfileRecert30DaysPage {
	
private static final Logger logger = Logger.getLogger(ProfileRecert30DaysPage.class.getName());
	
	
	private Page page;

	private Locator Reporting;
	private Locator Reports;
	private Locator daysttle;
	private Locator excel;
	
	public ProfileRecert30DaysPage(Page page) {
this.page = page;

excel = page.locator("//a[contains(@id,'lbExport')]");
		Reporting = page.locator("//span[contains(text(),'Reporting')]");
		 Reports = page.locator("//li[@class = 'rmItem rmFirst']/a[contains(text(),'Reports')]");
		 daysttle = page.locator("//a[@title = 'Profiles Needing Recert in Next 30 Days']");
	}
	
	public void recrt() {
		Reporting.hover();
		logger.info("Reports Hovered");
		Reports.click();
		logger.info("Reports Clicked");
		daysttle.click();
		logger.info("Title Clicked");
	}
	
	public void expexl() throws IOException {
		Path downloadedFile = FileUtils.downloadFile(page, () -> excel.click());
	    logger.info("Excel Downloaded to: " + downloadedFile.toString());
	    page.waitForTimeout(5000);
	}

}
