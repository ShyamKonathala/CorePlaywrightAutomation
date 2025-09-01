package CoreTests;

import java.io.IOException;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import CorePages.SolidWasteInboundPage;

import base.basetest;
import utils.ExcelDataProvider;

public class SolidWasteInboundTest extends basetest {
	@Test(dataProvider = "SolidReport",dataProviderClass = ExcelDataProvider.class,retryAnalyzer = utils.RetryAnalyzer.class)
	public void inbnd(String user, String pass,String Plant,String startdate,String enddate) throws IOException {
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		SolidWasteInboundPage sp = new SolidWasteInboundPage(getPage());
		sp.swste();
		sp.plnt(Plant);
		sp.start(startdate);
		sp.end(enddate);
		sp.srch();
		sp.expexl();
	}
}
