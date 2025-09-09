package CorePages;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

import utils.FileUtils;

public class UniversalWastePage {
 
private static final Logger logger = Logger.getLogger(UniversalWastePage.class.getName());
	
	private Page page;
	
	private Locator Reporting;
	private Locator Reports;
	private Locator unvttle;
	private Locator Arrow;
	private Locator startDate;
	private Locator endDate;
	private Locator srchbtn;
	private Locator Export;
	
	
	public UniversalWastePage(Page page) {
		this.page = page;
		Reporting = page.locator("//span[contains(text(),'Reporting')]");
		 Reports = page.locator("//li[@class = 'rmItem rmFirst']/a[contains(text(),'Reports')]");
		 unvttle = page.locator("//a[@title = 'Universal Waste']");
		 Arrow = page.locator("#ctl00_MainContent_PlantId button.rcbActionButton");
		 startDate = page.locator("//div[@id = 'ctl00_MainContent_rdpStartDate_dateInput_wrapper']/input[1]");
			endDate = page.locator("//div[@id = 'ctl00_MainContent_rdpEndDate_dateInput_wrapper']/input[1]");
			srchbtn = page.locator("//input[@id = 'MainContent_btnSearch']");
			Export = page.locator("#MainContent_ReportViewer1_ReportToolbar_ExportGr_Export");
	}
	
	public void Universal() {
		page.waitForTimeout(5000);
		Reporting.hover();
		page.waitForTimeout(3000);
		logger.info("Reporting hovered");
		Reports.click();
		logger.info("Reports Clicked");
		page.waitForTimeout(3000);
		unvttle.click();
		logger.info("Unbilled Report Clicked");
		page.waitForTimeout(3000);
		
	}
	public void dropdwn(String Plant) {
		Arrow.click();
		page.waitForTimeout(4000);
		logger.info("Arrow Clicked");
		String value = "//div[@id = 'ctl00_MainContent_PlantId_DropDown']/div/ul/li[contains(text(),'"+ Plant  +"')]";
		page.click(value);
		logger.info("Value Selected");
		page.waitForTimeout(4000);
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
		page.waitForTimeout(5000);
		logger.info("Search button Clicked");
	}
	
	public void drpdwn() throws IOException {
		page.selectOption("#MainContent_ReportViewer1_ReportToolbar_ExportGr_FormatList_DropDownList", new SelectOption().setValue("PDF"));
		page.waitForTimeout(10000);
		Path downloadedFile = FileUtils.downloadFile(page, () -> Export.click());
	    logger.info("Excel Downloaded to: " + downloadedFile.toString());
	    page.waitForTimeout(5000);
		
	}
}
