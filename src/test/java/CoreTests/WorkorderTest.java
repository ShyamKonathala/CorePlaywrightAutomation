package CoreTests;

import java.io.IOException;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import CorePages.WorkorderPage;
import base.basetest;
import utils.ExcelDataProvider;

public class WorkorderTest extends basetest {
	@Test(dataProvider = "loginData2", dataProviderClass = ExcelDataProvider.class)
	public void workorder(String user,String pass,String customer,String generator,String Srep, String InSrep, String CSRtext,String facility,String type, String UNT) throws IOException {
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		WorkorderPage wp = new WorkorderPage(getPage());
		wp.wordr();
		wp.newworder(customer);
		wp.gen(generator);
		wp.rep(Srep, InSrep, CSRtext);
		wp.orcle();
		wp.manifest(facility);
		wp.detail(type, UNT);
	}

}
