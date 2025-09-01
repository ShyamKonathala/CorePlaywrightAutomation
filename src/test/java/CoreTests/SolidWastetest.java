package CoreTests;

import java.io.IOException;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import CorePages.SolidWastePage;
import base.basetest;
import utils.ExcelDataProvider;

public class SolidWastetest extends basetest{
	@Test(dataProvider = "SolidReport",dataProviderClass = ExcelDataProvider.class,retryAnalyzer = utils.RetryAnalyzer.class)
	public void sldwste(String user, String pass,String Plant,String startdate,String enddate) throws IOException {
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		SolidWastePage sp = new SolidWastePage(getPage());
		sp.swste();
		sp.plnt(Plant);
		sp.start(startdate);
		sp.end(enddate);
		sp.srch();
		sp.dropdown();
		sp.iframe();
	}

}
