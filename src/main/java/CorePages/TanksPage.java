package CorePages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.basetest;
import utils.FileUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.WebElement;



public class TanksPage {

	
	
	private Page page;
	private Page mainPage;
	
	
	private static final Logger logger = Logger.getLogger(TanksPage.class.getName());
	
	private Locator PP;
	private Locator Tanks;
	private Locator Sample;
	String Add = "#btnAdd";
	private Locator Color;
	private Locator colorInput;
	private Locator lnkmnf;
	private Locator Sve;
	private Locator Analytical;
	
		
	//String JobId = "87056";
	
	public TanksPage(Page page) {
		this.page = basetest.getPage();
		this.mainPage = page; 
		
		PP = page.locator("//span[contains(text(),'Plant Processing')]");
		Tanks = page.locator("//ul[@class = 'rmVertical rmGroup rmLevel1']//a[contains(text(),'Tanks')]");
		Sample = page.locator("//button[contains(text(),'TAKE SAMPLE')]");
		lnkmnf = page.locator("//button[contains(text(),'LINK MANIFESTS')]");
		Sve = page.locator("//button[contains(text(),'Save')]");
		Analytical = page.locator("//a[normalize-space(text())='Analytical Report History']");
	}
	
	public void Tnks(String tankNumber,String ManifestId) {
		PP.hover();
		logger.info("Tanks hovered");
		Tanks.click();
		logger.info("Tanks clicked");
		
		
		
		

		    boolean found = false;
		    int maxScrolls = 20; // safeguard to avoid infinite loops
		    int scrollCount = 0;

		    while (!found && scrollCount < maxScrolls) {

		        // Get all visible rows in the grid
		        List<Locator> rows = page.locator("//div[@class='ag-center-cols-container']//div[contains(@class,'ag-row')]").all();

		        for (Locator row : rows) {
		            String rowText = row.innerText();

		            if (rowText.contains(tankNumber)) {
		                // Click the checkbox inside this row
		                row.locator(".ag-selection-checkbox").click();
		                System.out.println("✅ Tank " + tankNumber + " selected");
		                found = true;
		                break;
		            }
		        }

		        if (!found) {
		            // Scroll the grid viewport to load more rows
		            page.locator(".ag-center-cols-viewport").evaluate("el => el.scrollBy(0, 300)");
		            page.waitForTimeout(300); // let DOM update
		            scrollCount++;
		        }
		    }

		    if (!found) {
		        throw new RuntimeException("❌ Tank " + tankNumber + " not found after scrolling");
		    }
	lnkmnf.click();
	logger.info("Manifest Linked");
	
	boolean found2 = false;
	int scrollCount2 = 0;
	int maxScrollCount = 5;
	
	while(!found2&&scrollCount2<maxScrollCount) {
		
		List<Locator> rows = page.locator("//div[@id = 'ManifestsGrid']//div[@class = 'ag-center-cols-container']//div[contains(@class,'ag-row')]").all();
		for(Locator ro : rows) {
			
			String text = ro.innerText().trim();
			if(text.equals(ManifestId)) {
				ro.locator(".ag-selection-checkbox").click();
				logger.info("Manifest Selected");
				found2 = true;
				break;
			}
		}
		
		if(!found2) {
			logger.info("Failed");
			break;
		}
	}
		    
		}
	
	public void save() {
		Sve.click();
		logger.info("Manifest Saved");
		
	}
	public void sampleAndNewWindow(String record, String jobId) throws IOException {
	    // --- STEP 1: Open first popup ---
	    Page firstPopup = page.waitForPopup(() -> {
	        Sample.click(new Locator.ClickOptions().setTimeout(20000));
	    });
	    logger.info("Sample Clicked - First popup opened");

	    firstPopup.waitForLoadState(LoadState.DOMCONTENTLOADED);

	    // --- STEP 2: Perform actions in first popup ---
	    firstPopup.locator(Add).click();
	    logger.info("Record Added in first popup");

	    // Wait for any processing in first popup
	    firstPopup.waitForTimeout(2000);

	    // --- STEP 3: Open second popup from inside first popup ---
	    Page secondPopup = firstPopup.waitForPopup(() -> {
	        firstPopup.locator("#MainContent_lbAnalyticalReportHistory").click();
	    });
	    logger.info("Analytical History Clicked - Second popup opened");

	    secondPopup.waitForLoadState(LoadState.DOMCONTENTLOADED);
	    logger.info("Second popup loaded");

	    // Optional: reload to ensure table is fresh
	    secondPopup.reload();

	    // --- STEP 4: Download the report in second popup ---
	    Locator downloadBtn = secondPopup.locator(
	    	    "//div[@class='ag-center-cols-container']//div[@role='row' and .//div[contains(text(),'" + jobId + "')]]" +
	    	    "//button[contains(normalize-space(.),'Download Report')]"
	    	);

	    	// Wait until visible
	    	downloadBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

	    	// Scroll into view
	    	downloadBtn.scrollIntoViewIfNeeded();

	    	// Click
	    	downloadBtn.click(new Locator.ClickOptions().setForce(true));
	    	
	    	Path downloadedfile = FileUtils.downloadFile(secondPopup, () -> downloadBtn.click());
	    	logger.info("File Downloaded" +downloadedfile.toString());
	    	

	    	

	    // --- STEP 5: Close popups and return to main page ---
	    secondPopup.close();
	    firstPopup.close();
	    mainPage.bringToFront();
	    mainPage.waitForTimeout(5000);
	    logger.info("Main window focused");
	    
	}
	}
	

