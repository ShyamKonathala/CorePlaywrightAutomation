package CoreTests;

import java.io.IOException;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import CorePages.ProfileTgeExcelPage;
import base.basetest;
import utils.CommonDropdown;
import utils.ExcelDataProvider;
import utils.PageLocators;

public class ProfileTgeExcelTest extends basetest {

	@Test(dataProvider = "loginData",dataProviderClass = ExcelDataProvider.class,retryAnalyzer = utils.RetryAnalyzer.class)
	public void tongerprt(String user, String pass, String start, String end) throws IOException {
		
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		ProfileTgeExcelPage ptp = new ProfileTgeExcelPage(getPage());
		ptp.excel();
		CommonDropdown cp = new CommonDropdown();
		cp.selectFromDropdown(getPage(), PageLocators.prfleexcel_Arrow, PageLocators.prfleexcel_list, "257 - Republic Env Sys  (PA) LLC");
		ptp.strtdte(start);
		ptp.enddte(end);
		ptp.search();
		ptp.expexl();
		ptp.button();
		cp.selectFromDropdown(getPage(), PageLocators.page_Arrow, PageLocators.page_size, "20");
		cp.selectFromDropdown(getPage(), PageLocators.page_Arrow, PageLocators.page_size, "50");
		
	}
}
