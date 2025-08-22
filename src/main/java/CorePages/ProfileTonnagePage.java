package CorePages;

import java.util.logging.Logger;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProfileTonnagePage {
	
	private static final Logger logger = Logger.getLogger(ProfileTonnagePage.class.getName());
	
	private Page page;
	
	private Locator Reporting;
	private Locator Reports;
	private Locator Tonttle;
	private Locator cstmer;
	private Locator generatr;
	private Locator searchbtn;
	
	public ProfileTonnagePage(Page page) {
		
		this.page = page;
		
		Reporting = page.locator("//span[contains(text(),'Reporting')]");
		Reports = page.locator("//li[@class = 'rmItem rmFirst']/a[contains(text(),'Reports')]");
		Tonttle = page.locator("//a[@title = 'Profile Tonnage Report']");
		cstmer = page.locator("//input[@name = 'ctl00$MainContent$ucCustomerAjax$racbCustomerAjax']");
		generatr = page.locator("//input[@name = 'ctl00$MainContent$ucGeneratorAjax$racbGeneratorAjax']");
		 searchbtn = page.locator("#MainContent_btnSearch");
		
	}
	
	public void Tonnage() {
		
		Reporting.hover();
		logger.info("Reports hovered");
		Reports.click();
		logger.info("Reports clicked");
		Tonttle.click();
		logger.info("Title clicked");
		
		
	}
	public void cstmr(String customer) {
		cstmer.fill(customer);
		page.waitForTimeout(5000);
		page.keyboard().press("ArrowDown");
		page.waitForTimeout(5000);
		page.keyboard().press("Enter");
		logger.info("Customer Selected");
		
	}
	
	public void genertr(String generator) {
		generatr.fill(generator);
		page.waitForTimeout(5000);
		page.keyboard().press("ArrowDown");
		page.waitForTimeout(5000);
		page.keyboard().press("ArrowDown");
		page.waitForTimeout(5000);
		page.keyboard().press("Enter");
		logger.info("Generator Selected");
		
	}
	
	public void srch() {
		searchbtn.click();
		logger.info("Search clicked");
		page.waitForTimeout(5000);
		
	}

}
