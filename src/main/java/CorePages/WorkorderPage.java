package CorePages;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.Logger;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.basetest;
import utils.ConfigReader;
import utils.ExcelUtils;

public class WorkorderPage {
	
	private static final Logger logger = Logger.getLogger(WorkorderPage.class.getName());
	
	private Page page;
	private Locator CP;
	private Locator Workorder;
	private Locator Neworder;
	private BrowserContext context;
	private Locator cstmr;
	private Locator wrdrtpe;
	private Locator genrtr;
	private Locator Revenue;
	private Locator OrcleArrw;
	private Locator Save;
	private Locator mnf;
	private Locator mnftrnmbr;
	private Locator facarrw;
	private Locator tredit;
	private Locator trans;
	private Locator transarrw;
	private Locator transsve;
	private Locator save;
	private Locator detal;
	private Locator lines;
	private Locator Addlines;
	private Locator prflearrw;
	private Locator dtnarrw;
	private Locator nextline;
	private Locator sveext;
	private Locator SalesRep;
	private Locator InSalesRep;
	private Locator CSR;
	private Locator Cntrno;
	private Locator Cntrtpe;
	private Locator QTY;
	private Locator Unit;
	private Locator weight;
	private Locator Edit;
	private Locator None;
	private Locator Transfer;
	private Locator Savebtn;
	
	
	
	public WorkorderPage(Page page) {
		this.page = basetest.getPage();
		this.context = page.context();
		
		CP = page.locator("//ul[@class = 'rmRootGroup rmHorizontal']//span[contains(text(),'Customer Processing')]");
		Workorder = page.locator("//ul[@class = 'rmVertical rmGroup rmLevel1']//li/a[contains(text(),'Work Orders')]");
		Neworder = page.locator("#ctl00_MainContent_RadGrid1_ctl00_ctl02_ctl00_lbAddWorkorder");
		cstmr = page.locator("//input[@name = 'ctl00$MainContent$DetailsView1$customerDropdownAjax$racbCustomerAjax']");
		wrdrtpe = page.locator("#ctl00_MainContent_DetailsView1_WorkorderTypeDropdown button.rcbActionButton");
		genrtr = page.locator("//input[@name = 'ctl00$MainContent$DetailsView1$CustomerGeneratorDropdown']");
		Revenue = page.locator("//div[@id = 'ctl00_MainContent_DetailsView1_rtbEstimatedRevenue_wrapper']/input[1]");
		OrcleArrw = page.locator("#ctl00_MainContent_DetailsView1_rcbOracleLocation button.rcbActionButton");
		Save = page.locator("//input[@name = 'ctl00$MainContent$DetailsView1$ctl23']");
		mnf = page.locator("#MainContent_DetailsView1_lbManifests");
		mnftrnmbr = page.locator("//span[@id = 'ctl00_MainContent_DetailsView1_rtbManifestTrackingNumber_wrapper']/input[1]");
		facarrw = page.locator("#ctl00_MainContent_DetailsView1_vendorDDL button.rcbActionButton");
		tredit = page.locator("//div[@class = 'col-sm-6 text-right']//button[@name = 'ctl00$MainContent$DetailsView1$btntransEdit']");
		trans = page.locator("//div[@id = 'ctl00_MainContent_rlbAvailableTranspoters']//div[2]//ul//li[2]");
		transarrw = page.locator("//span[@class = 'rlbButtonIcon rlbIconTransferRight']");
		transsve = page.locator("//button[@id = 'btnTransEditUpdate']");
		save = page.locator("//button[@id = 'btnBottomSaveManifest']");
		detal = page.locator("#MainContent_lbDetails");
		lines = page.locator("//span[@id = 'ctl00_MainContent_lineItemCount_wrapper']/input[1]");
		Addlines = page.locator("#MainContent_btnAddLines");
		prflearrw = page.locator("#ctl00_MainContent_DetailsView1_rcbProfileName button.rcbActionButton");
		dtnarrw = page.locator("#ctl00_MainContent_DetailsView1_rcbDOTName button.rcbActionButton");
		nextline = page.locator("#MainContent_DetailsView1_btnNext");
		sveext = page.locator("#MainContent_DetailsView1_btnEdit");
		SalesRep = page.locator("#ctl00_MainContent_DetailsView1_SalesRepDropdown1_comboSalesRep button.rcbActionButton");
		InSalesRep = page.locator("#ctl00_MainContent_DetailsView1_InsideSalesRepDropdown1_comboInsideSalesRep button.rcbActionButton");
		CSR = page.locator("#comboICs button.rcbActionButton");
		Cntrno = page.locator("//span[@id = 'ctl00_MainContent_DetailsView1_rtbNumberofContainers_wrapper']/input[1]");
		Cntrtpe = page.locator("#ctl00_MainContent_DetailsView1_rcbType button.rcbActionButton");
		QTY = page.locator("//span[@id = 'ctl00_MainContent_DetailsView1_rtbTotalQnt_wrapper']/input[1]");
		Unit = page.locator("#ctl00_MainContent_DetailsView1_rcbUnitWt button.rcbActionButton");
		weight = page.locator("//span[@id = 'ctl00_MainContent_DetailsView1_rtbWeight_wrapper']/input[1]");
		Edit = page.locator("//button[@name = 'ctl00$MainContent$DetailsView1$RadButton1']//span[contains(text(),'Edit...')]");
		None = page.locator("//div[@class = 'rlbGroup']//li[contains(text(),'None')]");
		Transfer = page.locator("//span[@class = 'rlbButtonIcon rlbIconTransferRight']");
		Savebtn = page.locator("//button[@id = 'btnSaveEpaCode']");
	}
	
	public void wordr() {
		//page.waitForTimeout(10000);
		CP.hover();
		logger.info("CP Hovered");
		Workorder.click();
		logger.info("Workorder clicked");
		Neworder.click();
		logger.info("New Workorder");
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots","workorder.png")));
		context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));
		context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
	}
	
	public void newworder(String customer) {
		cstmr.fill(customer);
		page.waitForTimeout(5000);
		page.keyboard().press("ArrowDown");
		page.waitForTimeout(5000);
		page.keyboard().press("Enter");
		logger.info("Customer Selected");
		String value = "//div[@id = 'ctl00_MainContent_DetailsView1_WorkorderTypeDropdown_DropDown']/div/ul/li[1]";
		boolean found = false;
		int attempts = 0;
		int maxAttempts = 4;

		while (attempts < maxAttempts) {
		    try {
		        attempts++;
		        wrdrtpe.scrollIntoViewIfNeeded();
		        // Expand dropdown
		        wrdrtpe.click();
		        logger.info("Type Arrow Clicked (Attempt " + attempts + ")");
		        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Screenshots","failure.png")));

		        // Wait until option is visible
		        Locator option = page.locator("//div[@id='ctl00_MainContent_DetailsView1_WorkorderTypeDropdown_DropDown']//li[1]");
		        option.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

		        // Click option
		        option.click();
		        logger.info("Value Selected");
		        
		        found = true;
		        break; // exit loop if successful

		    } catch (Exception e) {
		        logger.info("Attempt " + attempts + " failed: " + e.getMessage());
		        if (attempts == maxAttempts) {
		            throw e; // rethrow after max retries
		        }
		    }
		}

		if (!found) {
		    logger.info("Validation Failed: Unable to select dropdown value after " + maxAttempts + " attempts.");
		}}
	
	public void gen(String generator) {
		genrtr.fill(generator);
		page.waitForTimeout(5000);
		page.keyboard().press("ArrowDown");
		page.waitForTimeout(5000);
		page.keyboard().press("Enter");
		logger.info("Generator Selected");
		page.waitForTimeout(5000);
		
	}
	
	public void rep(String Srep, String InSrep, String CSRtext) {
		SalesRep.click();
		logger.info("SalesRep Arrow Clicked");
		page.waitForTimeout(5000);
		String Salesrep = "//div[@id = 'ctl00_MainContent_DetailsView1_SalesRepDropdown1_comboSalesRep_DropDown']/div/ul/li[contains(text(),'"+ Srep +"')]";
		page.click(Salesrep);
		logger.info("Sales Rep Selected" + Srep);
		page.waitForTimeout(5000);
		
		InSalesRep.click();
		logger.info("Inside Sales Rep Clicked");
		page.waitForTimeout(5000);
		String Inslsrep = "//div[@id = 'ctl00_MainContent_DetailsView1_InsideSalesRepDropdown1_comboInsideSalesRep_DropDown']/div/ul/li[contains(text(),'"+ InSrep + "')]";
		page.click(Inslsrep);
		page.waitForTimeout(5000);
		logger.info("Inslsrep Selected" + InSrep);
		
		CSR.click();
		logger.info("CSR Arrow Clicked");
		page.waitForTimeout(5000);
		String CSRvalue = "//div[@id = 'comboICs_DropDown']/div/ul/li[contains(text(),'"+ CSRtext + "')]";
		page.click(CSRvalue);
		logger.info("CSR Selected" + CSRtext);
		page.waitForTimeout(5000);
		
		
	}
	public void orcle() {
		Revenue.fill("45");
		logger.info("Value Entered");
		page.waitForTimeout(5000);
		
		
      
       OrcleArrw.click();
       
       logger.info("Oracle Arrow clicked");
       
       page.locator("//div[@id = 'ctl00_MainContent_DetailsView1_rcbOracleLocation_DropDown']/div/ul/li[contains(text(),'Hayward, CA (1026)(AERCCA)')]").click();
       logger.info("Oracle Value selected");
       
       
		       
		 

		Save.click();
		logger.info("Workorder Saved");

		String currenturl = page.url();
		String[] parts = currenturl.split("WorkorderID=");
		String workorderId = parts.length > 1 ? parts[1] : "NOT_FOUND";
		logger.info("Workorder ID: " + workorderId);
		}
	
	public void manifest(String facility) {
		mnf.click();
		logger.info("New Manifest added");
		mnftrnmbr.fill("434536767CLE");
		logger.info("Manifest entered");
		
		String value = "//div[@id = 'ctl00_MainContent_DetailsView1_vendorDDL_DropDown']/div/ul/li[contains(text(),'" + facility + "')]";
		boolean found = false;
		int attempts = 0;
		int maxattempts = 3;
		while(attempts<maxattempts) {
		try {
			
				attempts++;
				facarrw.click();
				logger.info("facility arrow clicked");
				page.click(value);
				logger.info("Facility Entered");
				found = true;
				break;
				
			}
		
		catch(Exception e) {
			e.printStackTrace();
			logger.info("Facility Not found");
			
			
		}
		}
		if(!found) {
			logger.info("Facility Not found" + maxattempts);
			throw new RuntimeException(facility);
		}
		page.waitForTimeout(5000);
		tredit.click();
		logger.info("Transporter Edited");
		page.waitForTimeout(5000);
		trans.click();
		logger.info("Transporter selected");
		page.waitForTimeout(5000);
		transarrw.click();
		page.waitForTimeout(5000);
		transsve.click();
		page.waitForTimeout(5000);
		logger.info("Transporter Saved");
		save.click();
		page.waitForTimeout(5000);
		logger.info("Manifest Saved");
		
		String manifesturl = page.url();
		logger.info(manifesturl);
		
		String [] parts = manifesturl.split("ManifestID=");
		String manifestId = parts[1];
		
		logger.info(manifestId);
		
		}
	public void detail(String type, String UNT) throws IOException
{
		page.waitForTimeout(5000);
		detal.click();
		logger.info("detail clicked");
		page.waitForTimeout(10000);
		lines.fill("2");
		page.waitForTimeout(10000);
		logger.info("Lines Entered");
		Addlines.click();
		logger.info("Lines Added");
		page.waitForTimeout(5000);
		String filepath = ConfigReader.get("excelFilePath");
		
		int rowcount = ExcelUtils.getRowCount(filepath, "ManifestProfiles");
		for(int i = 1;i<=2;i++) {
			String profile = ExcelUtils.getCellData(filepath, "ManifestProfiles", i, 0);
			String DotName = ExcelUtils.getCellData(filepath, "ManifestProfiles", i, 1);
		page.waitForTimeout(10000);
		prflearrw.click();
		logger.info("Profile Arrow Clicked");
		String prfvle = "//div[@id = 'ctl00_MainContent_DetailsView1_rcbProfileName_DropDown']/div/ul/li[contains(text(),'" + profile + "')]";
		page.click(prfvle);
		logger.info("Profile Value Selected");
		page.waitForTimeout(10000);
		
		dtnarrw.click();
		logger.info("Dot NAme Arrow Clicked");
		String dtvalue = "//div[@id = 'ctl00_MainContent_DetailsView1_rcbDOTName_DropDown']/div/ul/li[contains(text(),'" + DotName + "')]";
		page.click(dtvalue);
		logger.info("Dot Name Selected");
		
		Cntrno.fill("2");
		logger.info("Containers entered");
		page.waitForTimeout(5000);
		Cntrtpe.click();
		String value = "//div[@id = 'ctl00_MainContent_DetailsView1_rcbType_DropDown']/div/ul/li[contains(text(),'" + type + "')]";
		page.click(value);
		
		QTY.fill("3");
		logger.info("Quantity entered");
		
		Unit.click();
		String value2 = "//div[@id = 'ctl00_MainContent_DetailsView1_rcbUnitWt_DropDown']/div/ul/li[contains(text(),'"+ UNT +"')]";
		page.click(value2);
		logger.info("Unit entered");
		
		weight.fill("4");
		logger.info("Weight entered");
		
		Edit.click();
		logger.info("Edit button Clicked");
		
		FrameLocator epaFrame = page.frameLocator("iframe[name='EPACodesEditor']");

		// Now interact with elements inside that iframe
		epaFrame.locator("//li[normalize-space()='None']").click();
		
		epaFrame.locator("//button[span[contains(@class,'rlbIconTransferRight')]]").click();
		logger.info("Transfer Clicked"); 
		
		
		epaFrame.locator("//button[@id = 'btnSaveEpaCode']").click();
		logger.info("EPA code Saved");
		
		page.waitForTimeout(10000);
		
		
		
		
		if (i < 2) {
            nextline.click();
            logger.info("Next line clicked");
        } else {
            sveext.click();
            logger.info("Save & Exit clicked");
        }
		}
		page.waitForTimeout(5000);
		
		
		}
}
