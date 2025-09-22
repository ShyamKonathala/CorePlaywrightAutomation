package CorePages;

import java.util.logging.Logger;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class GeneratorsearchPage {
	
	private Page page;
	private Locator Manage;
	private Locator gen;
	private Locator gensrch;
	private Locator srchbtn;
	private Locator rstbtn;
	private Locator genbtn;
	
	private static final Logger logger = Logger.getLogger(WorkorderPage.class.getName());
	
	public GeneratorsearchPage(Page page) {
		this.page = page;
		Manage = page.locator("//ul[@class = 'rmRootGroup rmHorizontal']//span[contains(text(),'Manage')]");
		gen = page.locator("//ul[@class = 'rmVertical rmGroup rmLevel1']//a[contains(text(),'Generators')]");
		gensrch = page.locator("//span[@id = 'ctl00_MainContent_txtGeneratorID_wrapper']/input[1]");
		srchbtn = page.locator("#btnSearch");
		rstbtn = page.locator("#MainContent_btnClear");
		genbtn = page.locator("//div[@class = 'ag-center-cols-container']/div[1]/div[1]//span[contains(text(),'')]");
	}
	
	public void srch(String generator) {
		Manage.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		Manage.hover();
		logger.info("Manage hovered");
		gen.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		gen.click();
		logger.info("Generator Clicked");
		gensrch.fill(generator);
		logger.info("Generator Entered");
		page.waitForTimeout(5000);
		srchbtn.click();
		logger.info("Search button Clicked");
		page.waitForTimeout(5000);
		genbtn.click();
		logger.info("Generator Opened");
		page.waitForTimeout(5000);
		page.goBack();
		page.waitForTimeout(5000);
		
		}
	public void reset() {
		rstbtn.click();
		logger.info("Button Reset Done");
		page.waitForTimeout(5000);
	}

}
