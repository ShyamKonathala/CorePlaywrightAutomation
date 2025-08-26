package CorePages;

import java.util.List;
import java.util.logging.Logger;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import com.microsoft.playwright.assertions.PlaywrightAssertions;

import base.basetest;

public class PInvoicePage {
	
	private static final Logger logger = Logger.getLogger(PInvoicePage.class.getName());
	
	private Page page;
	
	private Locator CP;
	private Locator Pinvoice;
	private Locator cstmr;
	private Locator genertr;
	private Locator search;
	private Locator rdobtn;
	private Locator genrte;
	
	public PInvoicePage(Page page) {
this.page = basetest.getPage();
		
		CP = page.locator("//ul[@class = 'rmRootGroup rmHorizontal']//span[contains(text(),'Customer Processing')]");
		Pinvoice = page.locator("//ul[@class = 'rmVertical rmGroup rmLevel1']//li/a[contains(text(),'Package Invoices')]");
		cstmr = page.locator("//input[@name = 'ctl00$MainContent$ucCustomerAjax$racbCustomerAjax']");
		genertr = page.locator("//input[@name = 'ctl00$MainContent$ucGeneratorAjax$racbGeneratorAjax']");
		search = page.locator("#MainContent_btnSearch");
		rdobtn = page.locator("//table[@id = 'MainContent_rblPDF']//input[@id = 'MainContent_rblPDF_1']");
		genrte = page.locator("#MainContent_btnGenerate");
	}
	
	public void Invoice() {
		
		CP.hover();
		logger.info("Customer Processing hovered");
		page.waitForTimeout(5000);
		Pinvoice.click();
		logger.info("Package Invoice Clicked");
	
	}
	
	public void custmr(String customer) {
		cstmr.fill(customer);
		page.waitForTimeout(5000);
		page.keyboard().press("ArrowDown");
		page.waitForTimeout(5000);
		page.keyboard().press("Enter");
		logger.info("Customer Entered");
	}
	
	public void genertr(String generator) {
		genertr.fill(generator);
		page.waitForTimeout(10000);
		page.keyboard().press("ArrowDown");
		page.keyboard().press("ArrowDown");
		page.waitForTimeout(5000);
		page.keyboard().press("Enter");
		logger.info("Generator Selected");
	}
	public void srch() {
		search.click();
		logger.info("Search clicked");
		page.waitForTimeout(5000);
	}
	
	public void checkbox(List<String> idsToSelect) {
	    for (String id : idsToSelect) {
	        Locator checkbox = page.locator(
	            "//div[@id='ctl00_MainContent_RadGrid1']//tbody//tr[td[text()='" + id + "']]//input[@type='checkbox']"
	        );
	        if (checkbox.isVisible()) {
	        	page.waitForTimeout(5000);
	            checkbox.click();
	            logger.info("Checkbox selected for ID: " + id);
	        }
	    }
	}
	public void doctypes(List<String> idsSelect) {
		for(String type : idsSelect) {
			Locator checkbox = page.locator("//table[@id='MainContent_cblDocTypes']//label[normalize-space(text())='" + type + "']/preceding-sibling::input[@type='checkbox']");
			
			if(checkbox.isVisible()) {
				
				page.waitForTimeout(5000);
				checkbox.click();
				logger.info("Checkbox Clicked, selected value is " + type);
			}
		}
	}
	
	public void radio() {
		rdobtn.click();
		logger.info("Radio Button Clicked");
		page.waitForTimeout(5000);
		genrte.click();
		logger.info("PDF Generated");
		page.waitForTimeout(5000);
		
	    
	    Locator message = page.locator("#MainContent_msgLabel");
	    PlaywrightAssertions.assertThat(message).hasText("Your message has been sent.");
	}
}
