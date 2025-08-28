package CoreTests;

import java.io.IOException;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import CorePages.Profilebycustomerpage;
import base.basetest;
import utils.CommonDropdown;
import utils.ExcelDataProvider;
import utils.PageLocators;

public class ProfilesbyCustomerTest extends basetest {
@Test(dataProvider = "CustomerReport",dataProviderClass = ExcelDataProvider.class)
	public void customr(String user, String pass, String customer) throws IOException {
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		Profilebycustomerpage pcp = new Profilebycustomerpage(getPage());
		pcp.cstmer(customer);
		pcp.expexl();
		pcp.buttons();
		CommonDropdown cp = new CommonDropdown();
		cp.selectFromDropdown(getPage(), PageLocators.customer_Arrow, PageLocators.customer_size, "20");
		cp.selectFromDropdown(getPage(), PageLocators.customer_Arrow, PageLocators.customer_size, "50");
		
	}
}
