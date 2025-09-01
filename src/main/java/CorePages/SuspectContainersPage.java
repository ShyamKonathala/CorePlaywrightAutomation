package CorePages;

import java.util.logging.Logger;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SuspectContainersPage {

private static final Logger logger = Logger.getLogger(SuspectContainersPage.class.getName());
	
	private Page page;
	
	private Locator Reporting;
	private Locator Reports;
	private Locator sscnttle;
	private Locator startDate;
	private Locator endDate;
	private Locator srchbtn;
	private Locator next;
	private Locator previous;
	
	public SuspectContainersPage(Page page) {
		this.page = page;
		Reporting = page.locator("//span[contains(text(),'Reporting')]");
		 Reports = page.locator("//li[@class = 'rmItem rmFirst']/a[contains(text(),'Reports')]");
		 sscnttle = page.locator("//a[@title = 'Suspect Containers Report']");
		 startDate = page.locator("//div[@id = 'ctl00_MainContent_rdpStartDate_dateInput_wrapper']/input[1]");
			endDate = page.locator("//div[@id = 'ctl00_MainContent_rdpEndDate_dateInput_wrapper']/input[1]");
			srchbtn = page.locator("//input[@id = 'MainContent_btnSearch']");
			next = page.locator("//div[@class = 'rgWrap rgArrPart2']/button[2]");
			previous = page.locator("//div[@class = 'rgWrap rgArrPart1']/button[1]");
	}
	public void sspcntr() {
		Reporting.hover();
		page.waitForTimeout(3000);
		logger.info("Reporting hovered");
		Reports.click();
		logger.info("Reports Clicked");
		page.waitForTimeout(3000);
		sscnttle.click();
		page.waitForTimeout(3000);
		logger.info("Suspect Title Clicked");
		
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
	public void buttons() {
		next.click();
		logger.info("Next Button Clicked");
		page.waitForTimeout(5000);
		previous.click();
		logger.info("Previous Button Clicked");
		page.waitForTimeout(5000);
		
	}
}
