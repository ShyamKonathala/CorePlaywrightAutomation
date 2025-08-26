package CorePages;

import java.util.logging.Logger;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import base.basetest;

public class InvoicePage {
	
	private static final Logger logger = Logger.getLogger(InvoicePage.class.getName());

	
	private Page page;
	
	
	private Locator CP;
	private Locator custmr;
	private Locator search;
	private Locator genertr;
	private Locator nextbtn;
	private Locator prevsbtn;
	private Locator Invoices;
	
	public InvoicePage(Page page) {
		this.page = basetest.getPage();
		
		CP = page.locator("//ul[@class = 'rmRootGroup rmHorizontal']//span[contains(text(),'Customer Processing')]");
		
		custmr = page.locator("//input[@name = 'ctl00$MainContent$ucCustomerAjax$racbCustomerAjax']");
		search = page.locator("//input[@id = 'MainContent_btnSearch']");
		genertr = page.locator("//input[@id = 'racbGeneratorAjax']");
		nextbtn = page.locator("//div[@class = 'rgWrap rgArrPart2']//button[1]");
		prevsbtn = page.locator("//button[contains(@name,'$RadGrid1$ctl00$ctl03$ctl01$ctl03')]");
		Invoices = page.locator("//ul[@class = 'rmVertical rmGroup rmLevel1']//li/a[@href = '../Invoices/ManageInvoices.aspx']");
	}
	
	public void invoice(String customer,String generator) {
		
		CP.hover();
		logger.info("Custoemr Processing Hovered");
		Invoices.click();
		logger.info("Invoices clicked");
		page.waitForTimeout(5000);
		
		custmr.fill(customer);
		
		page.waitForTimeout(5000);
	page.keyboard().press("ArrowDown");
	page.waitForTimeout(5000);
	page.keyboard().press("Enter");
	logger.info("Customer Entered");
	genertr.fill(generator);
	page.waitForTimeout(10000);
	page.keyboard().press("ArrowDown");
	page.keyboard().press("ArrowDown");
	page.waitForTimeout(5000);
	page.keyboard().press("Enter");
	logger.info("Generator Selected");
	page.waitForTimeout(10000);
	search.click();
		logger.info("Search clicked");
		page.waitForTimeout(5000);
		
		
		}
	public void buttons() {
		nextbtn.click();
		logger.info("Next button clicked");
		page.waitForTimeout(5000);
		prevsbtn.click();
		logger.info("Previous Button clicked");
		page.waitForTimeout(5000);
		
	}
	
	}
