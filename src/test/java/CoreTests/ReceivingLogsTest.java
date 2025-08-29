package CoreTests;

import java.io.IOException;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import CorePages.ReceivingLogsPage;
import base.basetest;
import utils.CommonDropdown;
import utils.ExcelDataProvider;
import utils.PageLocators;

public class ReceivingLogsTest extends basetest{
@Test(dataProvider = "loginData",dataProviderClass = ExcelDataProvider.class,retryAnalyzer = utils.RetryAnalyzer.class)
	public void rlogs(String user,String pass,String startDate,String endDate) throws IOException {
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		ReceivingLogsPage rp = new ReceivingLogsPage(getPage());
		rp.logs();
		rp.start(startDate);
		rp.enddte(endDate);
		rp.srch();
		rp.expexl();
		rp.buttons();
		CommonDropdown cp = new CommonDropdown();
		cp.selectFromDropdown(getPage(), PageLocators.customer_Arrow, PageLocators.customer_size, "20");
		cp.selectFromDropdown(getPage(), PageLocators.customer_Arrow, PageLocators.customer_size, "50");
		getPage().waitForTimeout(5000);
	}
}
