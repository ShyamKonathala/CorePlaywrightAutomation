package CoreTests;

import java.io.IOException;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import CorePages.WorkOrdersNotInvoicedPage;
import CorePages.WorkordersonHoldPage;
import base.basetest;
import utils.CommonDropdown;
import utils.ExcelDataProvider;
import utils.PageLocators;

public class WorkordersonHoldTest extends basetest {
	@Test(dataProvider = "login",dataProviderClass = ExcelDataProvider.class,retryAnalyzer = utils.RetryAnalyzer.class)
	public void wrkord(String user,String pass) throws IOException {
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		WorkordersonHoldPage wnp = new WorkordersonHoldPage(getPage());
		wnp.workorder();
		wnp.expexl();
		wnp.buttons();
		CommonDropdown cp = new CommonDropdown();
		cp.selectFromDropdown(getPage(), PageLocators.customer_Arrow, PageLocators.customer_size, "20");
		getPage().waitForTimeout(5000);
		cp.selectFromDropdown(getPage(), PageLocators.customer_Arrow, PageLocators.customer_size, "50");
		getPage().waitForTimeout(5000);
		cp.selectFromDropdown(getPage(), PageLocators.customer_Arrow, PageLocators.customer_size, "100");
		getPage().waitForTimeout(5000);
	}

}
