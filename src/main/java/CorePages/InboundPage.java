package CorePages;

import java.util.logging.Logger;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class InboundPage {
	
private static final Logger logger = Logger.getLogger(InboundPage.class.getName());

	
	private Page page;
	
	private Locator PP;
	private Locator inbounds;
	private Locator inbnmr;
	private Locator mnfnmbr;
	private Locator ccntrs;
	private Locator edtcntr;
	private Locator gendate;
	private Locator genrdate;
	private Locator gensve;
	private Locator transdate;
	private Locator trdate;
	private Locator trsve;
	private Locator mnfrecv;
	private Locator svecnte;
	private Locator msg;
	private Locator okbtn;
	private Locator txt;
	private Locator done;
	private Locator chkbxid;
	private Locator accptinv;
	private Locator svebtn;
	
	public InboundPage(Page page) {
		this.page = page;
		
		PP = page.locator("//ul[@class = 'rmRootGroup rmHorizontal']//span[contains(text(),'Plant Processing')]");
		inbounds = page.locator("//ul[@class = 'rmVertical rmGroup rmLevel1']//li[3]//a[contains(text(),'Inbounds')]");
		inbnmr = page.locator("//input[contains(@id,'ManifestTrackingNumber')]");
		mnfnmbr = page.locator("//div[@id = 'ctl00_MainContent_RadGrid1_GridData']//tbody/tr/td[1]/a");
        ccntrs = page.locator("//div[@id = 'MainContent_notReceived']//a[normalize-space(text() = 'Create Containers')]");
        edtcntr = page.locator("//div[@id = 'MainContent_isReceived']/a[1]");
        genrdate = page.locator("#ctl00_MainContent_rbOpenGenSigneeDetail");
        gendate = page.locator("#modelGenSigneeUpdate_GeneratorSigneeDate");
        gensve = page.locator("#btnContainerModelGenSigneeSave");
        transdate = page.locator("#ctl00_MainContent_rbButtonUpdateSingerDetails");
        trdate = page.locator("//input[@class = 'custom-datepicker']");
        trsve = page.locator("#btnTransSignedDateUpdate");
        mnfrecv = page.locator("#MainContent_btnMarkReceived");
        svecnte = page.locator("#MainContent_lbtnContinue");
        msg = page.locator("//div[@class = 'message']");
        okbtn = page.locator("//div[@class = 'footer text-right']//button[contains(text(),'Ok')]");
        txt = page.locator("//span[contains(text(),'Manifest successfully received.')]");
        done = page.locator("#MainContent_btnDone");
        chkbxid = page.locator("//input[contains(@id,'ctl00_ctl02_ctl00_RowSelectCheckboxSelectCheckBox')]");
        accptinv = page.locator("//button[contains(@id,'ctl00_MainContent_rbAcceptIntoInventory')]");
        svebtn = page.locator("//div[@class = 'col-lg-12']//input[@id = 'MainContent_btnUpdate']");
        
		
	}
public void inbnd(String manifestNumber) {
	PP.hover();
	logger.info("Plant Processing hovered");
	page.waitForTimeout(3000);
	inbounds.click();
	logger.info("Inbounds Clicked");
	page.waitForTimeout(3000);
	inbnmr.fill(manifestNumber);
	logger.info("Manifest Entered");
	page.waitForTimeout(3000);
	page.keyboard().press("Enter");
	page.waitForTimeout(5000);
	
	}
public void mnf() {
	mnfnmbr.click();
	logger.info("Manifest Clicked");
	page.waitForTimeout(5000);
}
public void contrs() {
	//String text = ccntrs.innerText().trim();
	//logger.info("Text Message : " + text);
	if(ccntrs.isVisible()) {
		
		ccntrs.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		ccntrs.click();
		logger.info("Containers Created");
		edtcntr.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		edtcntr.click();
		logger.info("Containers Created and containers edited");
		
		
		}
	
	else {
		edtcntr.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		edtcntr.click();
		logger.info("Edit Container clicked");
		page.waitForTimeout(5000);
	}
}
public void dates(String gendte,String trndate) {
	page.waitForTimeout(10000);
	genrdate.click();
	logger.info("Generator Signed Date clicked");
	page.waitForTimeout(10000);
	gendate.fill(gendte);
	logger.info("Generator date entered");
	page.waitForTimeout(5000);
	gensve.click();
	logger.info("GenSignedDate Saved");
	page.waitForTimeout(5000);
	transdate.click();
	logger.info("TransSignedDate Clicked");
	page.waitForTimeout(5000);
	trdate.fill(trndate);
	logger.info("Transporter date entered");
	page.waitForTimeout(5000);
	trsve.click();
	logger.info("Transporter date saved");
	page.waitForTimeout(5000);
	
	
	}
public void received() {
	mnfrecv.click();
	logger.info("Mark Manifest Received");
	page.waitForTimeout(50000);
	svecnte.click();
	logger.info("Saved");
	page.waitForTimeout(10000);
}

public void cnfrmtn() {
	if(msg.isVisible()) {
		okbtn.click();
		logger.info("Clicked on OK button");
		page.waitForTimeout(50000);
	}
	else {
		String text = txt.innerText().trim();
		Assert.assertEquals(text, "Manifest successfully received.");
		logger.info("Text Verified : " + text);
		page.waitForTimeout(15000);
	}
}

public void invntry() {
	done.click();
	logger.info("Done Button Clicked");
	page.waitForTimeout(10000);
	chkbxid.click();
	logger.info("Checkbox Clicked");
	page.waitForTimeout(10000);
	accptinv.click();
	logger.info("Containers Accepted Into Inventory");
	page.waitForTimeout(10000);
	svebtn.click();
	logger.info("Save button clicked");
	page.waitForTimeout(5000);
}
}
