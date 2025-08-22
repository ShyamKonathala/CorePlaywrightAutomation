package CoreTests;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import base.basetest;
import utils.ExcelDataProvider;

public class LoginTest extends basetest {
     
	@Test(dataProvider = "login",dataProviderClass = ExcelDataProvider.class)
	public void Login(String user, String pass) {
		LoginPage login = new LoginPage(getPage());
		login.login(user, pass);
	}
	
}
