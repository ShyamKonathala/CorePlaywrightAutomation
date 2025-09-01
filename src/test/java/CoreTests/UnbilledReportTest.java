package CoreTests;

import java.io.IOException;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import CorePages.UnbilledReportPage;
import base.basetest;
import utils.CommonDropdown;
import utils.ExcelDataProvider;
import utils.PageLocators;

public class UnbilledReportTest extends basetest{
@Test(dataProvider = "login",dataProviderClass = ExcelDataProvider.class,retryAnalyzer = utils.RetryAnalyzer.class)
	public void rprt(String user,String pass) throws IOException {
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		UnbilledReportPage up = new UnbilledReportPage(getPage());
		up.Unbilled();
		up.date();
		up.rrprt();
		up.expexl();
		up.buttons();
		CommonDropdown cp = new CommonDropdown();
		cp.selectFromDropdown(getPage(), PageLocators.customer_Arrow, PageLocators.customer_size, "20");
		getPage().waitForTimeout(5000);
		cp.selectFromDropdown(getPage(), PageLocators.customer_Arrow, PageLocators.customer_size, "50");
		getPage().waitForTimeout(5000);
		
	}
}
