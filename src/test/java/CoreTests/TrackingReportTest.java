package CoreTests;

import java.io.IOException;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import CorePages.TrackingReportPage;
import base.basetest;
import utils.CommonDropdown;
import utils.ExcelDataProvider;
import utils.PageLocators;

public class TrackingReportTest extends basetest{
	@Test(dataProvider = "TrackingReport",dataProviderClass = ExcelDataProvider.class,retryAnalyzer = utils.RetryAnalyzer.class)
	public void trrprt(String user,String pass,String dvalue,String startdate,String enddate) throws IOException {
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		TrackingReportPage tp = new TrackingReportPage(getPage());
		
		tp.trrprt();
		tp.reset();
		tp.srchdrpdwn(dvalue);
		tp.srccrtia();
		tp.start(startdate);
		tp.end(enddate);
		tp.srch();
		tp.expexl();
		tp.buttons();
		
		CommonDropdown cp = new CommonDropdown();
		cp.selectFromDropdown(getPage(), PageLocators.customer_Arrow, PageLocators.customer_size, "10");
		getPage().waitForTimeout(5000);
		cp.selectFromDropdown(getPage(), PageLocators.customer_Arrow, PageLocators.customer_size, "50");
		getPage().waitForTimeout(5000);
		
	}
}
