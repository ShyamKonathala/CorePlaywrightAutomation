package CorePages;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import utils.FileUtils;

public class WorkordersonHoldPage {
	
private static final Logger logger = Logger.getLogger(WorkordersonHoldPage.class.getName());
	
	private Page page;
	
	private Locator Reporting;
	private Locator Reports;
	private Locator wrkntinv;
	private Locator excel;
	private Locator next;
	private Locator previous;
	
	public WorkordersonHoldPage(Page page) {
		this.page = page;
		Reporting = page.locator("//span[contains(text(),'Reporting')]");
		 Reports = page.locator("//li[@class = 'rmItem rmFirst']/a[contains(text(),'Reports')]");
		 wrkntinv = page.locator("//a[@title = 'Workorders On Hold']");
		 excel = page.locator("//a[contains(@id,'lbExport')]");
		 next = page.locator("//div[@class = 'rgWrap rgArrPart2']/button[2]");
		 previous = page.locator("//div[@class = 'rgWrap rgArrPart1']/button[1]");
	}
	
	public void workorder() {
		Reporting.hover();
		page.waitForTimeout(3000);
		logger.info("Reporting hovered");
		Reports.click();
		logger.info("Reports Clicked");
		page.waitForTimeout(3000);
		wrkntinv.click();
		logger.info("Workorder Title Clicked");
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

}
