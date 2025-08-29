package CoreTests;

import java.io.IOException;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import CorePages.ProfileRecert30DaysPage;
import base.basetest;
import utils.CommonDropdown;
import utils.ExcelDataProvider;
import utils.PageLocators;

public class Profile30daysrecrttest extends basetest {
	@Test(dataProvider = "login",dataProviderClass = ExcelDataProvider.class,retryAnalyzer = utils.RetryAnalyzer.class)
	public void recert(String user,String pass) throws IOException {
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		ProfileRecert30DaysPage prp = new ProfileRecert30DaysPage(getPage());
		prp.recrt();
		CommonDropdown cp = new CommonDropdown();
		cp.selectFromDropdown(getPage(), PageLocators.slsrp_Arrow, PageLocators.slsrp_size, "Abadia, Julio");
		prp.expexl();
		
	}

}
