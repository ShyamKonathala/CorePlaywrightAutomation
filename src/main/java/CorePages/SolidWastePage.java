package CorePages;

import java.util.logging.Logger;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SolidWastePage {

private static final Logger logger = Logger.getLogger(SolidWastePage.class.getName());
	
	private Page page;
	
	private Locator Reporting;
	private Locator Reports;
	private Locator slwsttle;
	
	public SolidWastePage(Page page) {
		this.page = page;
		Reporting = page.locator("//span[contains(text(),'Reporting')]");
		 Reports = page.locator("//li[@class = 'rmItem rmFirst']/a[contains(text(),'Reports')]");
		 slwsttle = page.locator("//a[@title = 'Solid Waste']");
	}
}
