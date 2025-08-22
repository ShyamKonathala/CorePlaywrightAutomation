package CoreTests;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import base.basetest;
import utils.ExcelDataProvider;

public class LoginTest extends basetest {
     
	@Test(dataProvider = "loginData",dataProviderClass = ExcelDataProvider.class)
	public void Login(String user, String pass) {
		LoginPage login = new LoginPage(page);
		login.login(user, pass);
	}
	
}
