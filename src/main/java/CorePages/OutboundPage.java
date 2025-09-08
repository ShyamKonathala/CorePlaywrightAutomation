package CorePages;

import java.io.IOException;
import java.util.logging.Logger;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import utils.ConfigReader;
import utils.ExcelUtils;
import utils.ManifestUtils;

public class OutboundPage {
	
private static final Logger logger = Logger.getLogger(OutboundPage.class.getName());

	
	private Page page;
	
	private Locator PP;
	private Locator outbounds;
	private Locator newwrkdr;
	private Locator cstmr;
	private Locator facArrw;
	private Locator svebtn;
	private Locator mnf;
	private Locator facArrw2;
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
	private Locator Cntrno;
	private Locator Cntrtpe;
	private Locator QTY;
	private Locator Unit;
	private Locator weight;
	private Locator Edit;
	private Locator nextline;
	private Locator sveext;
	
	public OutboundPage(Page page) {
this.page = page;
		
		PP = page.locator("//ul[@class = 'rmRootGroup rmHorizontal']//span[contains(text(),'Plant Processing')]");
		outbounds = page.locator("//ul[@class = 'rmVertical rmGroup rmLevel1']//li[4]//a[contains(text(),'Outbounds')]");
		newwrkdr = page.locator("//a[@href = '/App/Outbounds/EditOutbound.aspx']");
		cstmr = page.locator("//input[@name = 'ctl00$MainContent$DetailsView1$racbCustomerAjax']");
		facArrw = page.locator("#ctl00_MainContent_DetailsView1_comboVendorFacilities button.rcbActionButton");
		svebtn = page.locator("#MainContent_DetailsView1_btnUpdate");
		mnf = page.locator("#MainContent_DetailsView1_lbManifests");
		facArrw2 = page.locator("#ctl00_MainContent_DetailsView1_vendorDDL button.rcbActionButton");
		tredit = page.locator("//div[@class = 'col-sm-6 text-right']//button[@name = 'ctl00$MainContent$DetailsView1$btntransEdit']");
		trans = page.locator("//div[@id = 'ctl00_MainContent_rlbAvailableTranspoters']//div[2]//ul//li[2]");
		transarrw = page.locator("//span[@class = 'rlbButtonIcon rlbIconTransferRight']");
		transsve = page.locator("//button[@id = 'btnTransEditUpdate']");
		save = page.locator("//button[@id = 'btnBottomSaveManifest']");
		detal = page.locator("#MainContent_LinkButton1");
		lines = page.locator("//span[@id = 'ctl00_MainContent_lineItemCount_wrapper']/input[1]");
		Addlines = page.locator("#MainContent_btnAddLines");
		prflearrw = page.locator("#ctl00_MainContent_DetailsView1_rcbProfileName button.rcbActionButton");
		dtnarrw = page.locator("#ctl00_MainContent_DetailsView1_rcbDOTName button.rcbActionButton");
		Cntrno = page.locator("//span[@id = 'ctl00_MainContent_DetailsView1_rtbNumberofContainers_wrapper']/input[1]");
		Cntrtpe = page.locator("#ctl00_MainContent_DetailsView1_rcbType button.rcbActionButton");
		QTY = page.locator("//span[@id = 'ctl00_MainContent_DetailsView1_rtbTotalQnt_wrapper']/input[1]");
		Unit = page.locator("#ctl00_MainContent_DetailsView1_rcbUnitWt button.rcbActionButton");
		weight = page.locator("//span[@id = 'ctl00_MainContent_DetailsView1_rtbWeight_wrapper']/input[1]");
		Edit = page.locator("//button[@name = 'ctl00$MainContent$DetailsView1$RadButton1']//span[contains(text(),'Edit...')]");
		nextline = page.locator("#MainContent_DetailsView1_btnNext");
		sveext = page.locator("#MainContent_DetailsView1_btnEdit");
	}
public void outbnd() {
	PP.hover();
	logger.info("Plant Processing hovered");
	page.waitForTimeout(3000);
	outbounds.click();
	logger.info("Outbounds Clicked");
	page.waitForTimeout(3000);
	newwrkdr.click();
	logger.info("New Outbound Workorder Clicked");
	page.waitForTimeout(15000);
	
}
public void custmr(String customer) {
	cstmr.fill(customer);
	page.waitForTimeout(5000);
	page.keyboard().press("ArrowDown");
	page.waitForTimeout(5000);
	page.keyboard().press("Enter");
	page.waitForTimeout(5000);
	logger.info("Customer Entered");
	page.waitForTimeout(20000);
	
}
public void plant(String facility) {
	facArrw.click();
	logger.info("facility Arrow clicked");
	page.waitForTimeout(5000);
	String value = "//div[@id = 'ctl00_MainContent_DetailsView1_comboVendorFacilities_DropDown']/div/ul/li[contains(text(),'"+ facility +"')]";
	page.click(value);
	logger.info("facility selected");
	page.waitForTimeout(5000);
	page.keyboard().press("ArrowDown");
	page.waitForTimeout(5000);
	page.keyboard().press("Enter");
	page.waitForTimeout(5000);
	
}

public void save() {
	svebtn.click();
	page.waitForTimeout(5000);
	logger.info("Outbound Workorder Saved");
	mnf.click();
	logger.info("Manifest Clicked");
	page.waitForTimeout(25000);
	
}

public void manifest() {
	String manifestnumber = ManifestUtils.generateManifestTrackingNumber();
	System.out.println(manifestnumber);
	
	page.locator("//span[@id = 'ctl00_MainContent_DetailsView1_rtbManifestTrackingNumber_wrapper']/input[1]").fill(manifestnumber);
	page.waitForTimeout(5000);
	
	
}
public void faclty(String facilityName) {
	facArrw2.click();
	page.waitForTimeout(5000);
	String value = "//div[@id = 'ctl00_MainContent_DetailsView1_vendorDDL_DropDown']/div/ul/li[contains(text(),'"+ facilityName +"')]";
	page.click(value);
	logger.info("Facility Selected : " + facilityName);
	page.waitForTimeout(5000);
	
}
public void transporter() {
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
	page.waitForTimeout(10000);
}

public void detail() {
	detal.click();
	logger.info("detail clicked");
	page.waitForTimeout(10000);
	lines.fill("2");
	page.waitForTimeout(10000);
	logger.info("Lines Entered");
	Addlines.click();
	logger.info("Lines Added");
	page.waitForTimeout(10000);
}

public void prdtdata(String type,String UNT) throws IOException {
	String filepath = ConfigReader.get("excelFilePath");
	int rowcount = ExcelUtils.getRowCount(filepath, "ManifestProfiles");

	for (int i = 1; i <= rowcount; i++) {
	    if (i == 6 || i == 7) {   // only process rows 6 and 7
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
	        logger.info("Dot Name Arrow Clicked");

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
			
			FrameLocator epa = page.frameLocator("iframe[name='EPACodesEditor']");
			page.waitForTimeout(5000);
			
			if(i==6) {
			
			epa.locator("//ul[@class = 'rlbList']//li[2]").click();
			page.waitForTimeout(5000);
			epa.locator("//button[span[contains(@class,'rlbIconTransferRight')]]").click();
			logger.info("Transfer1 Clicked"); 
			page.waitForTimeout(5000);
			epa.locator("//ul[@class = 'rlbList']//li[@data-id = '11']").click();
			page.waitForTimeout(5000);
			
			epa.locator("//button[span[contains(@class,'rlbIconTransferRight')]]").click();
			logger.info("Transfer2 Clicked"); 
			}
		if(i==7) {
			epa.locator("//ul[@class = 'rlbList']//li[2]").click();
			page.waitForTimeout(5000);
			epa.locator("//button[span[contains(@class,'rlbIconTransferRight')]]").click();
			logger.info("Transfer1 Clicked"); 
			page.waitForTimeout(5000);
		}
		   
			epa.locator("//button[@id = 'btnSaveEpaCode']").click();
			logger.info("EPA code Saved");
			
			page.waitForTimeout(10000);
			
			if(i<7) {
				  nextline.click();
		            logger.info("Next line clicked");
			}
			else {
	            sveext.click();
	            logger.info("Save & Exit clicked");
	        }
			
	    }
	}
}
}
