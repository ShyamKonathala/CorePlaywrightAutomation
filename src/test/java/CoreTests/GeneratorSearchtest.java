package CoreTests;

import org.testng.annotations.Test;

import CorePages.GeneratorsearchPage;
import CorePages.LoginPage;
import base.basetest;
import utils.ExcelDataProvider;

public class GeneratorSearchtest extends basetest {
	@Test(dataProvider = "GeneratorDB", dataProviderClass = ExcelDataProvider.class,retryAnalyzer = utils.RetryAnalyzer.class)
	public void gentr(String user,String pass,String generator) {
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		GeneratorsearchPage gp = new GeneratorsearchPage(getPage());
		gp.srch(generator);
		gp.reset();
	}
}
