package utils;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class CommonDropdown {
	
	public void selectFromDropdown(Page page, String arrowLocator, String optionLocatorPattern, String optionValue) {
        int maxRetries = 3;
        boolean success = false;

        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            try {
                System.out.println("Attempt " + attempt + ": Clicking dropdown arrow...");

                // Fresh locator each attempt
                Locator arrow = page.locator(arrowLocator);
                arrow.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
                arrow.scrollIntoViewIfNeeded();

                // Try clicking the arrow
                arrow.click(new Locator.ClickOptions().setTimeout(5000).setForce(true));
                System.out.println("Dropdown Arrow Clicked: " + arrowLocator);

                
               

                // Replace %s with actual value
                String optionLocator = String.format(optionLocatorPattern, optionValue);

                // Click the option
                page.waitForSelector(optionLocator).click();
                System.out.println("Option Selected: " + optionValue);

                success = true;
                break; // Exit loop if successful
            } catch (Exception e) {
                System.out.println("Attempt " + attempt + " failed: " + e.getMessage());

                // Fallback: Try clicking the whole combobox container instead of arrow
                if (attempt == maxRetries) {
                    throw new RuntimeException("Dropdown selection failed after " + maxRetries + " attempts", e);
                } else {
                    page.waitForTimeout(1000); // short pause before retry
                }
            }
        }

        if (!success) {
            throw new RuntimeException("Failed to select dropdown option: " + optionValue);
        }
    }
}
