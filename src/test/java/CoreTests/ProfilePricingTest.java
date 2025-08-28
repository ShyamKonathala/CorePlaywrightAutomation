package CoreTests;

import java.io.IOException;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import CorePages.ProfilePricingPage;
import base.basetest;
import utils.CommonDropdown;
import utils.ExcelDataProvider;
import utils.PageLocators;

public class ProfilePricingTest extends basetest {
	@Test(dataProvider = "PricingReport",dataProviderClass = ExcelDataProvider.class)
	public void prflepr(String user, String pass,String customer,String generator,String svalue) throws IOException {
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		ProfilePricingPage ppp = new ProfilePricingPage(getPage());
		ppp.pricing();
		ppp.cusgen(customer, generator);
		ppp.status(svalue);
		ppp.srch();
		ppp.expexl();
		ppp.buttons();
		CommonDropdown cp = new CommonDropdown();
		cp.selectFromDropdown(getPage(), PageLocators.customer_Arrow, PageLocators.customer_size, "20");
		cp.selectFromDropdown(getPage(), PageLocators.customer_Arrow, PageLocators.customer_size, "50");
		getPage().waitForTimeout(5000);
	}

}
