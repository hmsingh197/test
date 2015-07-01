package com.allstate.auto.tests;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.BasicConfigurator; 
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.PageFactory;

import com.allstate.auto.pages.StartupPage;
import com.allstate.auto.pages.allianceEasyQuotePage;
import com.allstate.auto.pages.dwellingPage;
import com.allstate.auto.pages.householdPage;
import com.allstate.auto.pages.impersonateMenuPage;
import com.allstate.auto.pages.initializemenuPage;
import com.allstate.pages.common.AllstatePageFactory;
import com.allstate.pages.common.PageFactory;
import com.allstate.utilities.Actions;
import com.allstate.utilities.CommonEnvProperties;
import com.allstate.utilities.DriverDefault;
import com.allstate.utilities.FileIO;
import com.allstate.utilities.ISeleniumTestPart;
import com.allstate.utilities.LogHelper;
import com.allstate.utilities.SeleniumApis;
import com.allstate.utilities.Validations;
//import com.gsicommerce.webstore.selenium.pages.shopping.HomePage;
//import com.gsicommerce.pages.common.WebstorePageFactory;
import com.allstate.utilities.Utils.SearchType;

/*import com.allstate.integration_tests.ui.demo_objectDefinations;
import com.scalar.selenium_test_helper.CommonEnvProperties;
import com.scalar.selenium_test_helper.DriverDefault;
import com.scalar.selenium_test_helper.ISeleniumTestPart;
import com.scalar.selenium_test_helper.LogHelper;
import com.scalar.selenium_test_helper.SeleniumApis;
import com.scalar.selenium_test_helper.utility.Actions;
import com.scalar.selenium_test_helper.utility.FileIO;
import com.scalar.selenium_test_helper.utility.Validations;*/
/**
 * This is a unit test to test the Agent Search functionality
 * @author Shekhar
 *
 */
//@RunWith(Parameterized.class)
public class ScenarioID1test extends Validations implements ISeleniumTestPart {
	private SeleniumApis apis;
	private WebDriver driver;
	private AllstatePageFactory allstatePageFactory;
	
	private static String WORKING_DIR =  System.getProperty("user.dir");
	String excelFilePath = WORKING_DIR + "\\src\\test\\resources\\ScenarioSheet.xls";
	
	public void setSelenium(SeleniumApis apis, PropertiesConfiguration testData) {
		this.apis = apis;
	}

	@Before
	public void setUp() throws Exception {
		
		DriverDefault.setUp(this);
		//driver = apis.createBrowserDriver("IE");
		String path = apis.getProperty(CommonEnvProperties.BROWSER_PATH);
		System.out.println(path);
		
		String IEDriver = "C:\\IEDriver\\IEDriverServer.exe";
		File file = new File(IEDriver);
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		driver = new InternetExplorerDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Implicit wait
		
		driver.get(path);
		driver.manage().window().maximize();
		Actions.ACT_changeWaitTime(driver, 20);
	//	allstatePageFactory = PageFactory.getWebstorePages(driver);
		
		
	}
	
	@After
	public void addNewDefect() {
		driver.quit();
	//	driver.close();
	}
	
	
	


	@Test
	public void ScenarioID1test() {
		testCaseName = "ScenarioID 1 Test Case";
		String title = "Description still needs to be created";
		try {
						
			LogHelper.logTestCaseHeader(testCaseName, title);
			HashMap<String, String> BusinessScenarioData = new HashMap<String, String>();
			String sqlQuery = "select * from [BusinessScenario$] where SCID = 1";
			BusinessScenarioData = FileIO.excelGetTestData(excelFilePath, sqlQuery);
			
			
			HashMap<String, String> insuredData = new HashMap<String, String>();
			sqlQuery = "select * from [Insured$] where InsuredID = 1" ;
			insuredData = FileIO.excelGetTestData(excelFilePath, sqlQuery);
			
					
			 impersonateMenuPage.launchFromImpersonateMenu(driver, 1, excelFilePath);
			 initializemenuPage.selectTransactionType(driver, BusinessScenarioData.get("TransactionType_1"), BusinessScenarioData.get("ProductType_1"));
		/*	 initializemenuPage.selectTransactionType(driver, "New Quote", "Homeowners");
	
		
			  Actions.ACT_clickObject(driver, initializemenuPage.selectButton_xpath, SearchType.XPATH);
			 
			 StartupPage.enterPrimaryInsuredInfo(driver, BusinessScenarioData.get("InsuredID_1"), BusinessScenarioData.get("IsPropertyAddressSame_1"),excelFilePath);
			
			 Actions.ACT_clickObject(driver, StartupPage.easyQuote_xpath, SearchType.XPATH);
			 
			 Actions.ACT_clickObject(driver, StartupPage.retrieveButton_id, SearchType.ID);
			 
			 allianceEasyQuotePage.orderCustomerReports(driver,BusinessScenarioData.get("OrderCustomerReports_1") );
			 
			 Actions.ACT_clickObject(driver, allianceEasyQuotePage.ok_name, SearchType.NAME);
			 
			 householdPage.checkErrors(driver);
			 Actions.ACT_dropdownSelect(driver, householdPage.piMaritalStatus_name, SearchType.NAME, insuredData.get("MaritalStatus_1"));
			 Actions.ACT_clickObject(driver, householdPage.piFirst_name, SearchType.NAME);
			 
			 
			// Thread.sleep(5000);
			 householdPage.enterOccupantData(driver, insuredData, 1);
			 householdPage.enterotherdata(driver,insuredData,BusinessScenarioData);
			
			 
			 //TODO add sql query to get the total number of occupants for the Insured.
		//	 Thread.sleep(5000);
			 householdPage.addAnotherOccupant(driver, insuredData, 3);
			 
			 Actions.ACT_clickObject(driver, householdPage.continueToDwellingButton_class, SearchType.CLASS);
			 
			 dwellingPage.enterstaticdata(driver, BusinessScenarioData);
			 
			 
			 Thread.sleep(5000);
		//	 Actions.ACT_clickLink(driver, dwellingPage.addAnotherKitchenItem_linktext, SearchType.LINKTEXT); */
			 
			 ReportLog("", "END OF TEST", "TEST COMPLETED");
		     
			 
		      
		
		}
			catch (Exception e) {
			
			
			ReportLog("FAIL", "END OF TEST", "vxvxvxvx");	
			Assert.fail("Test Case failed due to " + e.getMessage() );
			System.out.println(e.getMessage());
		}
	}
	
/*	@Parameterized.Parameters
	public static List<Object[]> data() {
	    return Arrays.asList(new Object[1][0]);
	}*/
	
	
	
}


