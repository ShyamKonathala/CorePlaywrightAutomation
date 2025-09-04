package CoreTests;

import org.testng.annotations.Test;

import CorePages.InboundPage;
import CorePages.LoginPage;
import base.basetest;
import utils.ExcelDataProvider;

public class InboundsTest extends basetest {
	@Test(dataProvider = "InboundsDB",dataProviderClass = ExcelDataProvider.class,retryAnalyzer = utils.RetryAnalyzer.class)
	public void inbnd(String user,String pass,String manifestNumber,String gendte,String trndate) {
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		InboundPage ip = new InboundPage(getPage());
		ip.inbnd(manifestNumber);
		ip.mnf();
		ip.contrs();
		ip.dates(gendte,trndate);
		ip.received();
		ip.cnfrmtn();
		ip.invntry();
	}

}
