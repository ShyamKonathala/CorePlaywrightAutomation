package CoreTests;

import java.io.IOException;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import CorePages.TanksPage;
import base.basetest;
import utils.ExcelDataProvider;

public class TanksTest extends basetest {
	@Test(dataProvider = "Tanks",dataProviderClass = ExcelDataProvider.class)
	public void tanktest(String user, String pass,String tankNumber,String ManifestId,String record,String JobId) throws IOException {
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		TanksPage tp = new TanksPage(getPage());
		tp.Tnks(tankNumber,ManifestId);
		tp.save();
		tp.sampleAndNewWindow(record, JobId);
		
	}

}
