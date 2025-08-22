package utils;

import org.openqa.selenium.WebDriver;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DriverFactory {
	
	 private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
	    private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
	    private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
	    private static ThreadLocal<Page> tlPage = new ThreadLocal<>();

	    // initBrowser
	    public static void initBrowser(String browserName) {
	        Playwright playwright = Playwright.create();
	        tlPlaywright.set(playwright);

	        Browser browser;
	        switch (browserName.toLowerCase()) {
	            case "firefox":
	                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
	                break;
	            case "webkit":
	                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
	                break;
	            default:
	                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	                break;
	        }
	        tlBrowser.set(browser);

	        BrowserContext context = browser.newContext();
	        tlBrowserContext.set(context);

	        Page page = context.newPage();
	        tlPage.set(page);
	    }

	    // getters
	    public static Playwright getPlaywright() {
	        return tlPlaywright.get();
	    }

	    public static Browser getBrowser() {
	        return tlBrowser.get();
	    }

	    public static BrowserContext getBrowserContext() {
	        return tlBrowserContext.get();
	    }

	    public static Page getPage() {
	        return tlPage.get();
	    }

	    // cleanup
	    public static void closeBrowser() {
	        if (getPage() != null) getPage().close();
	        if (getBrowserContext() != null) getBrowserContext().close();
	        if (getBrowser() != null) getBrowser().close();
	        if (getPlaywright() != null) getPlaywright().close();
	    }

}
