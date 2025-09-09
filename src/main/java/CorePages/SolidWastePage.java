package CorePages;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

import utils.FileUtils;

public class SolidWastePage {

private static final Logger logger = Logger.getLogger(SolidWastePage.class.getName());
	
	private Page page;
	
	private Locator Reporting;
	private Locator Reports;
	private Locator slwsttle;
	private Locator Arrow;
	private Locator startDate;
	private Locator endDate;
	private Locator srchbtn;
	private Locator Export;
	
	
	public SolidWastePage(Page page) {
		this.page = page;
		Reporting = page.locator("//span[contains(text(),'Reporting')]");
		 Reports = page.locator("//li[@class = 'rmItem rmFirst']/a[contains(text(),'Reports')]");
		 slwsttle = page.locator("//a[@title = 'Solid Waste']");
		 Arrow = page.locator("#ctl00_MainContent_PlantId button.rcbActionButton");
		 startDate = page.locator("//div[@id = 'ctl00_MainContent_rdpStartDate_dateInput_wrapper']/input[1]");
			endDate = page.locator("//div[@id = 'ctl00_MainContent_rdpEndDate_dateInput_wrapper']/input[1]");
			srchbtn = page.locator("//button[@id = 'searchButton']");
			Export = page.locator("#MainContent_ReportViewer1_ReportToolbar_ExportGr_Export");
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
	
	public void dropdown() throws IOException {
		page.selectOption("#MainContent_ReportViewer1_ReportToolbar_ExportGr_FormatList_DropDownList", new SelectOption().setIndex(1));
		page.waitForTimeout(10000);
		Path downloadedFile = FileUtils.downloadFile(page, () -> Export.click());
	    logger.info("Excel Downloaded to: " + downloadedFile.toString());
	    page.waitForTimeout(5000);
		
	}
	
	public void iframe() {
		FrameLocator frame = page.frameLocator("#MainContent_ReportViewer1ParametersArea");
		
		frame.locator("//div[@id = 'parameterEditorstartdate_valueEditorstartdate']//input[1]").fill("6/1/2025");
		page.waitForTimeout(5000);
		frame.locator("//div[@id = 'parameterEditorenddate_valueEditorenddate']//input[1]").fill("7/31/2025");
		page.waitForTimeout(5000);
		frame.locator("#Preview").click();
		page.waitForTimeout(5000);
		
		
	}
}
