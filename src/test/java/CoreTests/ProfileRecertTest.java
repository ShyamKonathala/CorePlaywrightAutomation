package CoreTests;

import java.io.IOException;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import CorePages.ProfileRecertPage;
import base.basetest;
import utils.DatePickerUtils;
import utils.DropdownUtils;
import utils.ExcelDataProvider;

public class ProfileRecertTest extends basetest {
@Test(dataProvider = "RecertReport", dataProviderClass = ExcelDataProvider.class)
	public void recrt(String user, String pass, String salesrep,String customer) throws IOException {
		
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		ProfileRecertPage prp = new ProfileRecertPage(getPage());
		prp.recert();
		prp.dropdown(salesrep);
		prp.customer(customer);
		DatePickerUtils.previousselectDate(getPage(), "//a[@id = 'ctl00_MainContent_rdpStartDate_popupButton']","//span[contains(@id,'StartDate_calendar_Title')]","//a[@id= 'ctl00_MainContent_rdpStartDate_calendar_NP']", "//div[contains(@id,'ctl00_MainContent_rdpStartDate_calendar')]//td[@title='Tuesday, July 01, 2025']/a","July 2025","10" );
		
		DatePickerUtils.currentselectDate(getPage(), "//a[contains(@id,'EndDate_popupButton')]", "//span[contains(@id,'EndDate_calendar_Title')]", "//a[@id = 'ctl00_MainContent_rdpEndDate_calendar_NN']//span[@class = 't-font-icon t-i-arrow-right']", "//div[contains(@id,'ctl00_MainContent_rdpEndDate_calendar')]//td[@title = 'Monday, September 01, 2025']/a", "September 2025", "8");
		
		prp.srch();
		
	}
	
}
