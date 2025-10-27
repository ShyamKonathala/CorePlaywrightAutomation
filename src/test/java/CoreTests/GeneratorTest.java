package CoreTests;

import org.testng.annotations.Test;

import CorePages.GeneratorPage;
import CorePages.LoginPage;
import base.basetest;
import utils.ExcelDataProvider;

public class GeneratorTest extends basetest {
	@Test(groups = {"smoke"},dataProvider = "Addgen",dataProviderClass = ExcelDataProvider.class,retryAnalyzer = utils.RetryAnalyzer.class)
	public void genertr(String user,String pass,String generator,String State,String County) throws Exception {
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		GeneratorPage gp = new GeneratorPage(getPage());
		gp.gen();
		gp.gendtls(generator, State, County);
		gp.save();
		gp.docupld();
		
	}

}
