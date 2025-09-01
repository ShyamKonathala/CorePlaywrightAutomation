package CoreTests;

import java.io.IOException;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import CorePages.TrackingAlternatePage;
import base.basetest;
import utils.CommonDropdown;
import utils.ExcelDataProvider;
import utils.PageLocators;

public class TrackingAlternatetest extends basetest {
	@Test(dataProvider = "TrackingAlterNateReport",dataProviderClass = ExcelDataProvider.class,retryAnalyzer = utils.RetryAnalyzer.class)
	public void tratnte(String user,String pass,String customer,String generator, String startdate,String enddate) throws IOException {
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		TrackingAlternatePage tp = new TrackingAlternatePage(getPage());
		tp.traltnte();
		tp.cusgen(customer, generator);
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
		tp.reset();
		getPage().waitForTimeout(5000);
		
	}

}
