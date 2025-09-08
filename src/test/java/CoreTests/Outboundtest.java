package CoreTests;

import java.io.IOException;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import CorePages.OutboundPage;
import base.basetest;
import utils.ExcelDataProvider;

public class Outboundtest extends basetest{
	
	  private String facilityName;
	@Test(dataProvider = "InterCompany",dataProviderClass = ExcelDataProvider.class,retryAnalyzer = utils.RetryAnalyzer.class)
	public void outbond(String user,String pass,String customer,String facility,String facilityName,String type,String UNT) throws IOException {
		
		this.facilityName = facility;
		LoginPage lo = new LoginPage(getPage());
		lo.login(user, pass);
		OutboundPage op = new OutboundPage(getPage());
		op.outbnd();
		op.custmr(customer);
		op.plant(facility);
		op.save();
		op.manifest();
		op.faclty(facilityName); 
		op.transporter();
		op.detail();
		op.prdtdata(type, UNT);
		
	}
	
}
