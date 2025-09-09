package CorePages;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import utils.FileUtils;

public class SolidWasteInboundPage {

private static final Logger logger = Logger.getLogger(SolidWasteInboundPage.class.getName());
	
	private Page page;
	
	private Locator Reporting;
	private Locator Reports;
	private Locator slwsttle;
	private Locator Arrow;
	private Locator startDate;
	private Locator endDate;
	private Locator srchbtn;
	private Locator excel;
	
	public SolidWasteInboundPage(Page page) {
		this.page = page;
		Reporting = page.locator("//span[contains(text(),'Reporting')]");
		 Reports = page.locator("//li[@class = 'rmItem rmFirst']/a[contains(text(),'Reports')]");
		 slwsttle = page.locator("//a[@title = 'Solid Waste Inbound']");
		 Arrow = page.locator("#ctl00_MainContent_PlantId button.rcbActionButton");
		 startDate = page.locator("//div[@id = 'ctl00_MainContent_rdpStartDate_dateInput_wrapper']/input[1]");
			endDate = page.locator("//div[@id = 'ctl00_MainContent_rdpEndDate_dateInput_wrapper']/input[1]");
			srchbtn = page.locator("//input[@id = 'MainContent_btnSearch']");
			 excel = page.locator("//a[contains(@id,'lbExport')]");
	}
	
	public void swste() {
		page.waitForTimeout(3000);
		Reporting.hover();
		page.waitForTimeout(3000);
		logger.info("Reporting hovered");
		Reports.click();
		logger.info("Reports Clicked");
		page.waitForTimeout(3000);
		slwsttle.click();
		logger.info(" Solid Waste Title Clicked");
		page.waitForTimeout(3000);
		
	}
	
	public void plnt(String Plant) {
		Arrow.click();
		page.waitForTimeout(5000);
		logger.info("Arrow Clicked");
		String value = "//div[@id = 'ctl00_MainContent_PlantId_DropDown']/div/ul/li[contains(text(),'"+ Plant +"')]";
		page.click(value);
		page.waitForTimeout(5000);
		logger.info("Facility Selected");
		page.waitForTimeout(5000);
		
	}
public void start(String startdate) {
		
		startDate.fill(startdate);
		page.waitForTimeout(5000);
	}

	public void end(String enddate) {
		endDate.fill(enddate);
		page.waitForTimeout(5000);
	}
	public void srch() {
		srchbtn.click();
		page.waitForTimeout(15000);
		logger.info("Search button Clicked");
	}
	public void expexl() throws IOException {
		Path downloadedFile = FileUtils.downloadFile(page, () -> excel.click());
	    logger.info("Excel Downloaded to: " + downloadedFile.toString());
	    page.waitForTimeout(5000);
	}
	
}
