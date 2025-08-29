package CoreTests;

import org.testng.annotations.Test;

import CorePages.InvoicePage;
import CorePages.LoginPage;
import base.basetest;
import utils.CommonDropdown;
import utils.ExcelDataProvider;
import utils.PageLocators;

public class InvoiceTest extends basetest {
@Test(dataProvider = "Invoice",dataProviderClass = ExcelDataProvider.class,retryAnalyzer = utils.RetryAnalyzer.class)
	public void invce(String user, String pass,String customer,String generator) {
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		InvoicePage ip = new InvoicePage(getPage());
		ip.invoice(customer,generator);
		ip.buttons();
		CommonDropdown cp = new CommonDropdown();
		cp.selectFromDropdown(getPage(), PageLocators.dropdown_Arrow, PageLocators.dropdown_size, "20");
		cp.selectFromDropdown(getPage(), PageLocators.dropdown_Arrow, PageLocators.dropdown_size, "50");
		
		
		
	}
}
