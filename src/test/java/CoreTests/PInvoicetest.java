package CoreTests;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import CorePages.LoginPage;
import CorePages.PInvoicePage;
import base.basetest;
import utils.ExcelDataProvider;

public class PInvoicetest extends basetest {
	
    LoginPage lo;
    PInvoicePage pp;
    String generatorValue; // store generator for reuse
    String idvalue;
    String type;
    

    @Test(priority = 1, dataProvider = "PInvoice", dataProviderClass = ExcelDataProvider.class)
    public void Pinvtst(String user, String pass, String customer, String generator,String ids,String types) {
        lo = new LoginPage(getPage());
        pp = new PInvoicePage(getPage());

        lo.login(user, pass);
        pp.Invoice();
        pp.custmr(customer);
        pp.srch();

        // store generator for next step
        generatorValue = generator;
        idvalue = ids;
        type = types;
        
        
    }

    @Test(priority = 2, dependsOnMethods = "Pinvtst")
    public void gensrch() {
        // now directly run generator search on the same page/session
        pp.genertr(generatorValue);
        pp.srch();
        List<String> idList = Arrays.asList(idvalue.split(",")); 
        pp.checkbox(idList);
        List<String> typeList = Arrays.asList(type.split(","));
        pp.doctypes(typeList);
        pp.radio();
    }
}