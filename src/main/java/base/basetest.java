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
	
	   private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
	    private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
	    private static ThreadLocal<BrowserContext> tlContext = new ThreadLocal<>();
	    private static ThreadLocal<Page> tlPage = new ThreadLocal<>();

	    String baseurl = ConfigReader.get("baseUrl");

	    // ---- DOWNLOAD UTILITY ----
	    protected Path downloadFile(Runnable downloadTrigger) throws IOException {
	        Download download = getPage().waitForDownload(downloadTrigger);

	        Path destination = Paths.get("C:\\Users\\kshyamsai\\OneDrive - hsconline\\Documents\\" 
	                + download.suggestedFilename());
	        download.saveAs(destination);

	        System.out.println("File saved to: " + destination);
	        return destination;
	    }

	    // ---- THREAD-SAFE GETTERS ----
	    public static Playwright getPlaywright() {
	        return tlPlaywright.get();
	    }

	    public static Browser getBrowser() {
	        return tlBrowser.get();
	    }

	    public static BrowserContext getContext() {
	        return tlContext.get();
	    }

	    public static Page getPage() {
	        return tlPage.get();
	    }

	    // ---- SETUP ----
	    @BeforeMethod(alwaysRun = true)
	    public void setup() {
	        Playwright playwright = Playwright.create();
	        tlPlaywright.set(playwright);

	        Browser browser = playwright.chromium().launch(
	            new BrowserType.LaunchOptions()
	                .setHeadless(false)
	                .setArgs(Arrays.asList("--start-maximized"))
	        );
	        tlBrowser.set(browser);

	        BrowserContext context = browser.newContext(
	            new Browser.NewContextOptions().setViewportSize(null) // keeps maximized
	        );
	        tlContext.set(context);

	        Page page = context.newPage();
	        tlPage.set(page);

	        page.navigate(baseurl);
	        page.setDefaultTimeout(20000);
	    }

	    // ---- TEARDOWN ----
	    @AfterMethod(alwaysRun = true)
	    public void teardown() {
	        if (getContext() != null) getContext().close();
	        if (getBrowser() != null) getBrowser().close();
	        if (getPlaywright() != null) getPlaywright().close();

	        // Clean up ThreadLocals
	        tlContext.remove();
	        tlBrowser.remove();
	        tlPlaywright.remove();
	        tlPage.remove();
	    }
	}