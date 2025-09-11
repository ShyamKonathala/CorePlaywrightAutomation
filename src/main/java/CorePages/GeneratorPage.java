package CorePages;

import java.util.logging.Logger;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import utils.NameGenerator;

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
	public void gendtls(String generator,String State) {
		String gename = NameGenerator.getAlphaNumName();
		page.fill("//span[@id = 'ctl00_MainContent_txtGeneratorName_wrapper']/input[1]",gename);
		logger.info("Generator Details Entered");
		genarrw.click();
		logger.info("Generator Arrow Clicked");
		String genvle = "//div[@id = 'ctl00_MainContent_RCSiteCountry_DropDown']/div/ul/li[contains(text(),'"+ generator +"')]";
		page.click(genvle);
		logger.info("Generator Selected");
		
		stecty.fill("Texas");
		logger.info("City Entered");
		
		sttearrw.click();
		logger.info("Generator Arrow Clicked");
		String sttevle = "//div[@id = 'ctl00_MainContent_ddlState_DropDown']/div/ul/li[contains(text(),'"+ State +"')]";
		page.click(sttevle);
		logger.info("State Selected");
		
		genzp.fill("35637");
		logger.info("ZIP entered");
		
		cntyarrw.click();
		logger.info("County Arrow Clicked");
		
		
		
		
		
		
	}
}
