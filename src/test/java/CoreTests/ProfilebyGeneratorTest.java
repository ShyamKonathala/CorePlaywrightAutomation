package CoreTests;

import java.io.IOException;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import CorePages.ProfilesbyGeneratorPage;
import base.basetest;
import utils.CommonDropdown;
import utils.ExcelDataProvider;
import utils.PageLocators;

public class ProfilebyGeneratorTest extends basetest {
@Test(dataProvider = "GeneratorReport",dataProviderClass = ExcelDataProvider.class,retryAnalyzer = utils.RetryAnalyzer.class)
	public void gener(String user,String pass, String generator) throws IOException {
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		ProfilesbyGeneratorPage pgp = new ProfilesbyGeneratorPage(getPage());
		pgp.gen(generator);
		pgp.expexl();
		pgp.buttons();
		CommonDropdown cp = new CommonDropdown();
		cp.selectFromDropdown(getPage(), PageLocators.customer_Arrow, PageLocators.customer_size, "20");
		cp.selectFromDropdown(getPage(), PageLocators.customer_Arrow, PageLocators.customer_size, "50");
	}
}
