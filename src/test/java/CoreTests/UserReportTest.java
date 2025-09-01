package CoreTests;

import java.io.IOException;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import CorePages.UserReportPage;
import base.basetest;
import utils.ExcelDataProvider;

public class UserReportTest extends basetest {
	@Test(dataProvider = "login",dataProviderClass = ExcelDataProvider.class,retryAnalyzer = utils.RetryAnalyzer.class)
	public void user(String user,String pass) throws IOException {
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		UserReportPage up = new UserReportPage(getPage());
		up.usrrpt();
		up.expexl();
		up.buttons();
		up.selectPageSize("50");
		getPage().waitForTimeout(5000);
	}

}
