package base;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utils.ConfigReader;

public class basetest {
	
	protected Path downloadFile(Runnable downloadTrigger) throws IOException {
	    Download download = page.waitForDownload(downloadTrigger);

	    // Choose where to save
	    Path destination = Paths.get("C:\\Users\\kshyamsai\\OneDrive - hsconline\\Documents" + download.suggestedFilename());

	    // Save the downloaded file
	    download.saveAs(destination);

	    System.out.println("File saved to: " + destination);
	    return destination;
	}
	
	String baseurl = ConfigReader.get("baseUrl");

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected BrowserContext context;

    @BeforeMethod
    public void setup() {
        playwright = Playwright.create();

        browser = playwright.chromium().launch(
            new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setArgs(Arrays.asList("--start-maximized"))
        );

        // Create context with viewport disabled + download path set
        context = browser.newContext(
            new Browser.NewContextOptions()
                .setViewportSize(null)); // keeps browser in "maximized" size

        page = context.newPage();
        page.navigate(baseurl);
        page.setDefaultTimeout(20000); // Optional: set a default timeout
        
       
    }

   /* @AfterMethod
    public void teardown() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }*/

}
