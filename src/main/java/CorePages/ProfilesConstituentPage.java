package CorePages;

import java.util.logging.Logger;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import base.basetest;

public class ProfilesConstituentPage {
	
	private static final Logger logger = Logger.getLogger(ProfilesConstituentPage.class.getName());
	
	
	private Page page;

	private Locator Reporting;
	private Locator Reports;
	private Locator cnsttle;
	private Locator constituent;
	private Locator gobtn;
	
	public ProfilesConstituentPage(Page page) {
this.page = basetest.getPage();
	
Reporting = page.locator("//span[contains(text(),'Reporting')]");
 Reports = page.locator("//li[@class = 'rmItem rmFirst']/a[contains(text(),'Reports')]");
 cnsttle = page.locator("//a[@title = 'Profiles By Constituent']");
 constituent = page.locator("//span[@id = 'ctl00_MainContent_RadTextBox1_wrapper']/input[1]");
 gobtn = page.locator("#MainContent_btnGo");
	}
	
	public void constt() {
		Reporting.hover();
		logger.info("Reporting hovered");
		Reports.click();
		logger.info("Reports Clicked");
		cnsttle.click();
		logger.info("Title Clicked");
		constituent.fill("NULLIFLY 32 OZ");
		logger.info("Value entered");
		gobtn.click();
		logger.info("Go Button clicked");
		constituent.fill("NULLIFLY 32OZ");
		logger.info("Value2 entered");
		gobtn.click();
		logger.info("Go Button clicked");
		page.waitForTimeout(5000);
		
		}
}
