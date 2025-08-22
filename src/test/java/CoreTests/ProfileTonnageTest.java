package CoreTests;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import CorePages.ProfileTonnagePage;
import base.basetest;
import utils.CommonDropdown;
import utils.DatePickerUtils;
import utils.ExcelDataProvider;
import utils.PageLocators;

public class ProfileTonnageTest extends basetest{
	@Test(dataProvider = "TonnageReport", dataProviderClass = ExcelDataProvider.class)
	public void ton(String user,String pass,String customer,String generator) {
		
		LoginPage lo = new LoginPage(page);
		lo.login(user, pass);
		ProfileTonnagePage ptp = new ProfileTonnagePage(page);
		ptp.Tonnage();
		CommonDropdown cp = new CommonDropdown();
		cp.selectFromDropdown(page, PageLocators.Facility_Arrow, PageLocators.FACILITY_LIST, "2138 - Petro-Chem Processing Group (ESOL) - 421 Lycaste, Detroit, MI 48214 - 2138");
		cp.selectFromDropdown(page, PageLocators.Facility_Arrow1, PageLocators.Facility_LIST1, "2138 - Petro-Chem Processing Group (ESOL)");
		ptp.cstmr(customer);
		ptp.genertr(generator);
		DatePickerUtils.previousselectDate(page, "//a[@id = 'ctl00_MainContent_rdpStartDate_popupButton']","//span[contains(@id,'StartDate_calendar_Title')]","//a[@id= 'ctl00_MainContent_rdpStartDate_calendar_NP']", "//div[contains(@id,'ctl00_MainContent_rdpStartDate_calendar')]//td[@title='Tuesday, July 01, 2025']/a","July 2025","01");
		page.waitForTimeout(5000);
		DatePickerUtils.currentselectDate(page, "//a[contains(@id,'EndDate_popupButton')]", "//span[contains(@id,'EndDate_calendar_Title')]", "//a[@id = 'ctl00_MainContent_rdpEndDate_calendar_NN']//span[@class = 't-font-icon t-i-arrow-right']", "//div[contains(@id,'ctl00_MainContent_rdpEndDate_calendar')]//td[@title = 'Monday, September 01, 2025']/a", "September 2025", "1");
		page.waitForTimeout(5000);
		ptp.srch();
		
	}

}
