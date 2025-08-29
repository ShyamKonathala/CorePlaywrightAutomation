package CoreTests;

import java.io.IOException;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import CorePages.ScannedDrumPage;
import base.basetest;
import utils.CommonDropdown;
import utils.ExcelDataProvider;
import utils.PageLocators;

public class ScannedDrumTest extends basetest {
	@Test(dataProvider = "ScannedReport",dataProviderClass = ExcelDataProvider.class,retryAnalyzer = utils.RetryAnalyzer.class)
	public void scdrum(String user,String pass,String startDate) throws IOException {
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		ScannedDrumPage sp = new ScannedDrumPage(getPage());
		sp.Scndrm();
		sp.start(startDate);
		sp.srch();
		sp.expexl();
		sp.buttons();
		CommonDropdown cp = new CommonDropdown();
		cp.selectFromDropdown(getPage(), PageLocators.customer_Arrow, PageLocators.customer_size, "20");
		cp.selectFromDropdown(getPage(), PageLocators.customer_Arrow, PageLocators.customer_size, "50");
		getPage().waitForTimeout(5000);
		
	}

}
