package CoreTests;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import CorePages.ProfilesConstituentPage;
import base.basetest;
import utils.ExcelDataProvider;

public class ProfileConstituentTest extends basetest {
	@Test(dataProvider = "login",dataProviderClass = ExcelDataProvider.class)
	public void profile(String user, String pass) {
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		ProfilesConstituentPage pcp = new ProfilesConstituentPage(getPage());
		pcp.constt();
	}

}
