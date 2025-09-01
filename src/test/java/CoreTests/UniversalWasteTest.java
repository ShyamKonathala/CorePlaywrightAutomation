package CoreTests;

import java.io.IOException;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import CorePages.UniversalWastePage;
import base.basetest;
import utils.ExcelDataProvider;

public class UniversalWasteTest extends basetest {
	@Test(dataProvider = "Facilities",dataProviderClass = ExcelDataProvider.class,retryAnalyzer = utils.RetryAnalyzer.class)
	public void unvwste(String user,String pass,String Plant,String startdate,String enddate) throws IOException {
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		UniversalWastePage up = new UniversalWastePage(getPage());
		up.Universal();
		up.dropdwn(Plant);
		up.start(startdate);
		up.end(enddate);
		up.srch();
		up.drpdwn();
		
	}

}
