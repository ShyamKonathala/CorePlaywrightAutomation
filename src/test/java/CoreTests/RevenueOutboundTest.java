package CoreTests;

import java.io.IOException;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import CorePages.RevenueOutboundPage;
import base.basetest;
import utils.CommonDropdown;
import utils.ExcelDataProvider;
import utils.PageLocators;

public class RevenueOutboundTest extends basetest {
@Test(dataProvider = "login",dataProviderClass = ExcelDataProvider.class,retryAnalyzer = utils.RetryAnalyzer.class)
	public void revneotbnd(String user, String pass) throws IOException {
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		RevenueOutboundPage rp = new RevenueOutboundPage(getPage());
		rp.outbound();
		rp.workodr();
		rp.expexl();
		rp.buttons();
		CommonDropdown cp = new CommonDropdown();
		cp.selectFromDropdown(getPage(), PageLocators.customer_Arrow, PageLocators.customer_size, "20");
		cp.selectFromDropdown(getPage(), PageLocators.customer_Arrow, PageLocators.customer_size, "50");
		getPage().waitForTimeout(10000);
	}
}
