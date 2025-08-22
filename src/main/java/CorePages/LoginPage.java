package CorePages;

import org.testng.Assert;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.basetest;

public class LoginPage {
	
	 private final Page page;

	    // Locators
	    private final String loginbtn = "#showHideOldLogin";
	    private final String username = "#Login1_UserName";
	    private final String pwd = "#Login1_Password";
	    private final String oldloginbtn = "#Login1_LoginButton";
	    private final String dashboardFrame = "#frmMain"; // post-login element

	    public LoginPage(Page page) {
	        this.page = basetest.getPage();
	        page.setDefaultTimeout(20000);
	        
	       
	    }

	    public void login(String user, String pass) {
	        page.setDefaultTimeout(90000);

	        // Step 1: Open login form
	        page.click(loginbtn);

	        // Step 2: Fill credentials
	        page.fill(username, user);
	        page.fill(pwd, pass);

	        // Step 3: Click login without waiting for navigation
	        page.locator(oldloginbtn).click(new Locator.ClickOptions().setTimeout(90000));
	        

	        page.waitForSelector("#ajaxLoading", 
	                new Page.WaitForSelectorOptions().setState(WaitForSelectorState.HIDDEN));

	            // 2. Wait until dashboard form is attached & visible
	            page.waitForSelector("form#frmMain", 
	                new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));

	            // 3. Optionally wait until "Profiles Assigned to Me" table appears
	            page.waitForSelector("text=Profiles Assigned to Me", 
	                new Page.WaitForSelectorOptions().setTimeout(90000));

	        // Step 5: Assert page title (post-login verification)
	        String title = page.title();
	        System.out.println("Page Title after login: " + title);

	        Assert.assertEquals(title, "User Dashboard - CORE", "Login failed or unexpected page title.");
	    }
}
