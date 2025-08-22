package CoreTests;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import CorePages.ProfileApprovalHistoryPage;
import base.basetest;
import utils.ExcelDataProvider;

public class ProfileApprovalReport extends basetest {
	@Test(dataProvider = "loginData",dataProviderClass = ExcelDataProvider.class)
	public void ProfileApproval(String user,String pass,String startdate,String enddate) throws InterruptedException {
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		ProfileApprovalHistoryPage php = new ProfileApprovalHistoryPage(getPage());
		php.Approval();
		php.start(startdate);
		php.end(enddate);
		php.srch();
		php.expexcel();
		php.btn();
		php.dropdown();
	}

}
