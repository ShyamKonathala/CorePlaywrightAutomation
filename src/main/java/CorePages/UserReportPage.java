package CorePages;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import utils.FileUtils;

public class UserReportPage {

private static final Logger logger = Logger.getLogger(UserReportPage.class.getName());
	
	private Page page;
	
	private Locator Reporting;
	private Locator Reports;
	private Locator usrttle;
	private Locator excel;
	private Locator next;
	private Locator previous;
	
	
	public UserReportPage(Page page) {
		this.page = page;
		Reporting = page.locator("//span[contains(text(),'Reporting')]");
		 Reports = page.locator("//li[@class = 'rmItem rmFirst']/a[contains(text(),'Reports')]");
		 usrttle = page.locator("//a[@title = 'User Report']");
		 excel = page.locator("//button[contains(@id,'btnExportToExcel')]");
		 next = page.locator("//span[@class = 'ag-icon ag-icon-last']");
			previous = page.locator("//span[@class = 'ag-icon ag-icon-first']");
			
	}
	public void usrrpt() {
		page.waitForTimeout(5000);
		Reporting.hover();
		page.waitForTimeout(3000);
		logger.info("Reporting hovered");
		Reports.click();
		logger.info("Reports Clicked");
		page.waitForTimeout(3000);
		usrttle.click();
		logger.info("User Report Clicked");
		page.waitForTimeout(3000);
		
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
	
	public void selectPageSize( String size) {
	    // Step 1: Click the dropdown
	    page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Page Size")).click();
	    logger.info("Arrow Clicked");

	    // Step 2: Select the desired value
	    page.getByText(size, new Page.GetByTextOptions().setExact(true)).click();
	    logger.info("Value " + size + " selected");
	}
}
