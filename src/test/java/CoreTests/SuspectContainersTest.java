package CoreTests;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import CorePages.SuspectContainersPage;
import base.basetest;
import utils.CommonDropdown;
import utils.ExcelDataProvider;
import utils.PageLocators;

public class SuspectContainersTest extends basetest {
@Test(dataProvider = "loginData",dataProviderClass = ExcelDataProvider.class,retryAnalyzer = utils.RetryAnalyzer.class)
	public void sspcntr(String user,String pass,String startdate,String enddate ) {
	LoginPage lo = new LoginPage(getPage());
	lo.login(user, pass);
	SuspectContainersPage sp = new SuspectContainersPage(getPage());
	sp.sspcntr();
	sp.start(startdate);
	sp.end(enddate);
	sp.srch();
	sp.buttons();
	CommonDropdown cp = new CommonDropdown();
	getPage().waitForTimeout(10000);
	cp.selectFromDropdown(getPage(), PageLocators.customer_Arrow, PageLocators.customer_size, "20");
	getPage().waitForTimeout(10000);
	cp.selectFromDropdown(getPage(), PageLocators.customer_Arrow, PageLocators.customer_size, "50");
	getPage().waitForTimeout(10000);
	}
}
