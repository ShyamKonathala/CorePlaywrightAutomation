package CorePages;

import java.nio.file.Paths;
import java.util.logging.Logger;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import utils.NameGenerator;
import utils.RetryUtils;

public class GeneratorPage {
	
	private static final Logger logger = Logger.getLogger(GeneratorPage.class.getName());
	
	private Page page;
	
	private Locator Manage;
	private Locator gen;
	private Locator addgen;
	private Locator genname;
	private Locator genarrw;
	private Locator stecty;
	private Locator sttearrw;
	private Locator genzp;
	private Locator cntyarrw;
	private Locator EPA;
	private Locator docarrw;
	private Locator docmnt;
	private Locator svebtn;
	
	public GeneratorPage(Page page) {
		this.page = page;
		
		Manage = page.locator("//ul[@class = 'rmRootGroup rmHorizontal']//span[contains(text(),'Manage')]");
		gen = page.locator("//ul[@class = 'rmVertical rmGroup rmLevel1']//a[contains(text(),'Generators')]");
		addgen = page.locator("#MainContent_lbAddGenerator");
		genname = page.locator("//span[@id = 'ctl00_MainContent_txtGeneratorName_wrapper']/input[1]");
		genarrw = page.locator("#ctl00_MainContent_RCSiteCountry button.rcbActionButton");
		stecty = page.locator("//span[@id = 'ctl00_MainContent_txtCity_wrapper']/input[1]");
		sttearrw = page.locator("#ctl00_MainContent_ddlState button.rcbActionButton");
		genzp = page.locator("//span[@id = 'ctl00_MainContent_txtZip_wrapper']/input[1]");
		cntyarrw = page.locator("#ctl00_MainContent_ddlCounty button.rcbActionButton");
		EPA = page.locator("//span[@id = 'ctl00_MainContent_txtEpaUS_wrapper']/input[1]");
		docarrw = page.locator("#ctl00_MainContent_FileUpload_ddlDocumentType button.rcbActionButton");
		docmnt = page.locator("input[type='file']");
		svebtn = page.locator("#MainContent_btnGeneratorSave");
	}

	
	public void gen() {
		Manage.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		Manage.hover();
		logger.info("Manage hovered");
		gen.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		gen.click();
		logger.info("Generator Clicked");
		addgen.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		addgen.click();
		logger.info("Add New Generator Clicked");
		
		}
	public void gendtls(String generator,String State,String County) throws Exception {
		
		 RetryUtils.runWithRetry(() -> {
		String gename = NameGenerator.getAlphaNumName();
		page.fill("//span[@id = 'ctl00_MainContent_txtGeneratorName_wrapper']/input[1]",gename);
		logger.info("Generator Details Entered");
		logger.info(gename);
		page.waitForTimeout(5000);
		genarrw.click();
		page.waitForTimeout(5000);
		logger.info("Generator Arrow Clicked");
		String genvle = "//div[@id = 'ctl00_MainContent_RCSiteCountry_DropDown']/div/ul/li[contains(text(),'"+ generator +"')]";
		page.click(genvle);
		logger.info("Generator Selected");
		
		stecty.fill("Texas");
		logger.info("City Entered");
		
		page.waitForTimeout(5000);
		sttearrw.click();
		page.waitForTimeout(5000);
		logger.info("Generator Arrow Clicked");
		String sttevle = "//div[@id = 'ctl00_MainContent_ddlState_DropDown']/div/ul/li[contains(text(),'"+ State +"')]";
		page.click(sttevle);
		logger.info("State Selected");
		
		
		
		genzp.fill("35637");
		logger.info("ZIP entered");
		
		boolean found = false;
		int attempts = 0;
		int maxAttempts = 2;

		while (attempts < maxAttempts && !found) {
		    try {
		        attempts++;
		        
		        // Click the dropdown arrow
		        cntyarrw.click();
		        logger.info("County Arrow Clicked");

		        // Dynamic XPath for county value
		        String cntyValueXpath = "//div[@id='ctl00_MainContent_ddlCounty_DropDown']/div/ul/li[contains(text(),'" + County + "')]";

		        // Wait for option to be visible before clicking
		        page.locator(cntyValueXpath).waitFor(new Locator.WaitForOptions().setTimeout(5000));
		        page.click(cntyValueXpath);

		        logger.info("County Value selected: " + County);
		        found = true; // ✅ Success → break the loop
		    } catch (Exception e) {
		       
		        if (attempts == maxAttempts) {
		            throw new RuntimeException("Failed to select county after " + maxAttempts + " attempts", e);
		        }
		    }
		}
		EPA.fill("EPA245156166");
		logger.info("EPA entered");
		page.waitForTimeout(5000);
		 }, 1, 2000); // retry once if fails
		
		}
	
	public void save() {
		svebtn.click();
		logger.info("Save button clicked");
		page.waitForTimeout(10000);
		
	}
	
	public void docupld() throws Exception {
		
		 RetryUtils.runWithRetry(() -> {
		docarrw.click();
		logger.info("document arrow clicked");
		
		String docvle = "//div[@id = 'ctl00_MainContent_FileUpload_ddlDocumentType_DropDown']/div/ul/li[contains(text(),'TSDF Approval List')]";
		page.click(docvle);
		logger.info("Document Type Selected");
		page.waitForTimeout(10000);
		
		docmnt.setInputFiles(Paths.get("C:\\Users\\kshyamsai\\OneDrive - hsconline\\Desktop\\Test1.xlsx"));
		logger.info("Select Document Clicked");
		page.waitForTimeout(5000);
		page.locator("//input[contains(@id,'btnUpload')]").click();
		logger.info("Document Uploadeed");
		page.waitForTimeout(5000);
		
		
		
		
		 }, 1, 2000); // retry once if fails
		
		
	}
}
